package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCustomerPage {

    private WebDriver driver;

    private By userName = By.name("name");
    private By userEmail = By.name("email");
    private By userMobile = By.name("mobile");

    private By buttonCreate = By.className("button-create");
    private By textBack = By.className("a-button-back");

    private By textError = By.className("help-inline");

    public CreateCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getButtonCreate() {
        return buttonCreate;
    }

    public void getIndexPage() {
        driver.findElement(textBack).click();
    }

    public void createSetNameEmailMobile(String name, String email, String mobile) {
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userMobile).sendKeys(mobile);
        driver.findElement(buttonCreate).click();
    }
}
