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

    private By textDanger = By.className("text-danger");
    private By alertDanger = By.xpath("/html/body/div/div/form/div/div[3]/div");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getButtonSignIn() {
        return buttonSignIn;
    }

    public void getRegisterPage() {
        driver.findElement(textSignUpHere).click();
    }

    public By getTextDanger() {
        return textDanger;
    }

    public By getAlertDanger() {
        return alertDanger;
    }

    public void loginSetEmailPassword(String email, String pass) {
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userPassword).sendKeys(pass);
        driver.findElement(buttonSignIn).click();
    }
}