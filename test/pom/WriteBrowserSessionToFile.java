package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class WriteBrowserSessionToFile {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://willowtreeapps.com/ideas/organizing-automated-tests-with-page-object-model");
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("currentSession.txt", true));

        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String currentWindowHandle : allWindowHandles) {
            writer.write(driver.getCurrentUrl());
            writer.newLine();
            driver.switchTo().window(currentWindowHandle);
        }
        String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
        System.out.println(sessionId);
        writer.close();
        //driver.quit();
    }
}