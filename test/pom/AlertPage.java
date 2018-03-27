/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertPage {

    private WebDriver driver;

    private By inputClickSimpleAlert = By.name("input_simple_alert");
    private By inputClickConfirmAlert = By.name("input_confirm_alert");
    private By inputClickPromptAlert = By.name("input_prompt_alert");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    private boolean alertDoAccept(WebElement element) {
        boolean isAccepted = false;
        try {
            element.click();
            driver.switchTo().alert().accept();
            isAccepted = true;
        } catch(NoAlertPresentException e) {
            e.printStackTrace();
        }
        return isAccepted;
    }

    private boolean alertDoCancel(WebElement element) {
        boolean isCanceled = false;
        try {
            element.click();
            driver.switchTo().alert().dismiss();
            isCanceled = true;
        } catch(NoAlertPresentException e) {
            e.printStackTrace();
        }
        return isCanceled;
    }

    public boolean checkSimpleAlertOK() {
        boolean result = false;
        if(driver.findElement(inputClickSimpleAlert).isEnabled()) {
            if(alertDoAccept(driver.findElement(inputClickSimpleAlert))) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkConfirmAlertOK() {
        boolean result = false;
        if(driver.findElement(inputClickConfirmAlert).isEnabled()) {
            if(alertDoAccept(driver.findElement(inputClickConfirmAlert))) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkConfirmAlertCancel() {
        boolean result = false;
        if(driver.findElement(inputClickConfirmAlert).isEnabled()) {
            if(alertDoCancel(driver.findElement(inputClickConfirmAlert))) {
                driver.switchTo().alert().accept();
                result = true;
            }
        }
        return result;
    }
}