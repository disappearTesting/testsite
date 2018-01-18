/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PomLogin {

    WebDriver driver;

    By username = By.name("username");
    By useremail = By.name("useremail");
    By password = By.name("password");
    By submitbutton = By.name("submitbutton");

    public PomLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void loginSetNamePassword(String name, String pass) {
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submitbutton).submit();
    }

    public void loginSetEmailPassword(String email, String pass) {
        driver.findElement(useremail).sendKeys(email);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submitbutton).submit();
    }
}
