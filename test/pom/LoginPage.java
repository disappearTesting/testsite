/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By userEmail = By.name("email");
    private By userPassword = By.name("password");

    private By buttonSignIn = By.name("btn-login");
    private By textSignUpHere = By.xpath("/html/body/div/div/form/div/div[8]/a");

    private By textError = By.className("text-danger");
    private By alertError = By.xpath("/html/body/div/div/form/div/div[3]/div");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getButtonSignIn() {
        return buttonSignIn;
    }

    public RegisterPage getRegisterPage() {
        driver.findElement(textSignUpHere).click();
        return new RegisterPage(driver);
    }

    public By getTextDanger() {
        return textError;
    }

    public By getAlertDanger() {
        return alertError;
    }

    public HomePage loginSetEmailPassword(String email, String pass) {
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userPassword).sendKeys(pass);
        driver.findElement(buttonSignIn).click();
        return new HomePage(driver);
    }
}