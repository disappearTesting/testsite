package pom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage {

    private static WebDriver driver;

    private static By username = By.name("username");
    private static By password = By.name("password");
    private static By confirmPassword = By.name("confirm_password");

    private By submitButton = By.name("submitbutton");
    private By resetButton = By.name("resetbutton");
    private By textLoginHere = By.xpath("/html/body/div/form/p/a");

    private By helpBlock = By.className("help-block");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return driver.findElement(username);
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

    public void getRegisterTextFields() {
        ArrayList elementsTextFields = new ArrayList<String>();

        elementsTextFields.add(driver.findElement(username).getText());
        elementsTextFields.add(driver.findElement(password).getText());
        elementsTextFields.add(driver.findElement(confirmPassword).getText());

        for(Object textFromTextFields: elementsTextFields) {
            textFromTextFields = elementsTextFields;
            System.out.println(textFromTextFields);
        }
    }
}
