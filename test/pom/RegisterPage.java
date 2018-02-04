package pom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage {

    private static WebDriver driver;

    private static By userName = By.name("name");
    private static By userEmail = By.name("name");
    private static By password = By.name("password");

    private By buttonSignUp = By.name("btn-signup");
    private By textSignInHere = By.xpath("/html/body/div/div/form/div/div[9]");

    private By helpBlock = By.className("help-block");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getButtonSignUp() {
        return buttonSignUp;
    }

    public void getLoginPage() {
        driver.findElement(textSignInHere).click();
    }

    public By getHelpBlock() {
        return helpBlock;
    }

    public void registerSetNamePassword(String name, String pass, String confirmPass) {
        driver.findElement(userName).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(confirmPass);
        driver.findElement(submitButton).click();
    }

    public List<WebElement> getRegisterTextFields() {
        ArrayList elementsTextFields = new ArrayList<String>();

        elementsTextFields.add(driver.findElement(userName));
        elementsTextFields.add(driver.findElement(password));
        elementsTextFields.add(driver.findElement(confirmPassword));

        return elementsTextFields;
    }
}