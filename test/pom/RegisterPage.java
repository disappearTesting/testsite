package pom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private static WebDriver driver;

    private static By userName = By.name("name");
    private static By userEmail = By.name("email");
    private static By userPassword = By.name("password");

    private By buttonSignUp = By.name("btn-signup");
    private By textSignInHere = By.xpath("/html/body/div/div/form/div/div[9]/a");

    private By textDanger = By.className("text-danger");
    private By alertSuccess = By.xpath("/html/body/div/div/form/div/div[3]/div");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getButtonSignUp() {
        return buttonSignUp;
    }

    public void getLoginPage() {
        driver.findElement(textSignInHere).click();
    }

    public By getTextDanger() {
        return textDanger;
    }

    public By getRegisterSuccess() {
        return alertSuccess;
    }

    public void registerSetNameEmailPassword(String name, String email, String pass) {
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userPassword).sendKeys(pass);
        driver.findElement(buttonSignUp).click();
    }
}