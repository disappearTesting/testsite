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

    WebElement useremail = driver.findElement(By.name("useremail"));
    WebElement username = driver.findElement(By.name("username"));
    WebElement userpassword = driver.findElement(By.name("userpassword"));
    WebElement submitbutton = driver.findElement(By.name("submitbutton"));

    public PomLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void loginNamePassword(String name, String pass) {
        username.sendKeys(name);
        userpassword.sendKeys(pass);
        submitbutton.submit();
    }

    public void loginEmailPassword(String email, String pass) {
        useremail.sendKeys(email);
        userpassword.sendKeys(pass);
        submitbutton.submit();
    }
}
