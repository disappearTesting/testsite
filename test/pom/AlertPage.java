/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage {

    private WebDriver driver;

    private By inputClickSimpleAlert = By.name("input_simple_alert");
    private By inputClickConfirmAlert = By.name("input_confirm_alert");
    private By inputClickPromptAlert = By.name("input_prompt_alert");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkSimpleAlertOK() {
        boolean result = false;
        if(driver.findElement(inputClickSimpleAlert).isEnabled()) {
            try {
                driver.findElement(inputClickSimpleAlert).click();
                new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
                result = true;
            } catch(NoAlertPresentException e) {

            }
        }
        return result;
    }

    public boolean checkConfirmAlertOK() {
        boolean result = false;
        if(driver.findElement(inputClickConfirmAlert).isEnabled()) {
            try {
                driver.findElement(inputClickConfirmAlert).click();
                new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
                result = true;
            } catch(NoAlertPresentException e) {

            }
        }
        return result;

    }
}
