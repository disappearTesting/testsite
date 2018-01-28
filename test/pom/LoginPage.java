/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By username = By.name("username");
    private By password = By.name("password");

    private By submitButton = By.name("submitbutton");
    private By textSignUpNow = By.xpath("/html/body/div/form/p/a");

    private By formGroupHasError = By.className("form-group-has-error");
    private By helpBlock = By.className("help-block");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getSubmitButton() {
        return submitButton;
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
        driver.findElement(submitButton).submit();
    }
}