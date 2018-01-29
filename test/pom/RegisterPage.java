package pom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    private By username = By.name("username");
    private By password = By.name("password");
    private By confirmPassword = By.name("confirm_password");

    private By submitButton = By.name("submitbutton");
    private By resetButton = By.name("resetbutton");
    private By textLoginHere = By.xpath("/html/body/div/form/p/a");

    private By helpBlock = By.className("help-block");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getSubmitButton() {
        return submitButton;
    }

    public By getResetButton() {
        return resetButton;
    }

    public By getTextLoginHere() {
        return textLoginHere;
    }

    public By getHelpBlock() {
        return helpBlock;
    }

    public void registerSetNamePassword(String name, String pass) {
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(submitButton).submit();
    }

    public void resetDataFromTextFields(String name, String pass) {
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(resetButton).click();
    }
}
