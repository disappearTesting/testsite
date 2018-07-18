package pom;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class WriteBrowserSessionToFile {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://willowtreeapps.com/ideas/organizing-automated-tests-with-page-object-model");
        //new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("currentSession.txt", true));

        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String currentWindowHandle : allWindowHandles) {
            writer.write(driver.getCurrentUrl());
            writer.newLine();
            driver.switchTo().window(currentWindowHandle);
        }
        //writer.write(cookie.getValue());
        Cookie cookie = driver.manage().getCookieNamed("JSESSIONID");
        System.out.println(cookie.getValue());
        writer.close();
        driver.quit();
    }
}