package unitTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        List<WebElement> listOfElements = driver.findElements(By.className("js-delete"));
        Actions builder = new Actions(driver);
        //Cookie cookie = new Cookie("lightShot","5b6d0776eceee11c3d7622074e7dec5fe8382788f74a2a36f5d896b634986293");
        driver.get("https://prntscr.com/gallery.html");
        Thread.sleep(5000);
        Set<Cookie> cookiesList =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.println(getcookies );
        }
    }
}
