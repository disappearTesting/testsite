package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage {

    private WebDriver driver;

    private By buttonClickSimpleAlert = By.name("input_simple_alert");
    private By buttonClickConfirmAlert = By.name("input_confirm_alert");
    private By buttonClickPromptAlert = By.name("input_prompt_alert");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkSimpleAlert() {
        boolean result = false;
        // make WebElement object
        if(driver.findElement(buttonClickSimpleAlert).isEnabled()) {
            try {
                driver.findElement(buttonClickSimpleAlert).click();
                new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
                result = true;
            } catch(NoAlertPresentException e) {
                System.out.println("Something went wrong!");
            }
        }
        return result;
    }

    public boolean getConfirmAlert() {
        boolean result = false;
        if(driver.findElement(buttonClickConfirmAlert).isEnabled()) {
            driver.findElement(buttonClickConfirmAlert).click();
            result = true;
        }
        return result;
    }

    public boolean getPromptAlert() {
        boolean result = false;
        if(driver.findElement(buttonClickPromptAlert).isEnabled()) {

        }
        return result;
    }
}
