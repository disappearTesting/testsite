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

    By formGroupHasError = By.className("form-group-has-error");
    By helpBlock = By.className("help-block");
    By textSignUpNow = By.xpath("/html/body/div/form/p/a");

    public PomLogin(WebDriver driver) {
        this.driver = driver;
    }

    public By getSubmitbutton() {
        return submitbutton;
    }

    public By getTextSignUpNow() {
        return textSignUpNow;
    }

    public By getFormGroupHasError() {
        return formGroupHasError;
    }

    public By getHelpBlock() {
        return helpBlock;
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