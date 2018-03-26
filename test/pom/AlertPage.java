/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

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
                driver.switchTo().alert().accept();
                result = true;
            } catch(NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean checkConfirmAlertOK() {
        boolean result = false;
        if(driver.findElement(inputClickConfirmAlert).isEnabled()) {
            try {
                driver.findElement(inputClickConfirmAlert).click();
                driver.switchTo().alert().accept();
                result = true;
            } catch(NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean checkConfirmAlertCancel() {
        boolean result = false;
        if(driver.findElement(inputClickPromptAlert).isEnabled()) {
            try {
                driver.findElement(inputClickPromptAlert).click();
                driver.switchTo().alert().dismiss();
                result = true;
            } catch(NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        return  result;
    }
}