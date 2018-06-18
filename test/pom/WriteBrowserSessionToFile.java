package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class WriteBrowserSessionToFile {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        Set<String> allWindowHandles = driver.getWindowHandles();
        if(allWindowHandles.size() > 1) {
            for(String currentWindowHandle : allWindowHandles) {
                System.out.println(driver.getCurrentUrl());
                driver.switchTo().window(currentWindowHandle);
            }
        }
    }
}