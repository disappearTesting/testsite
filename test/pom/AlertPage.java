/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.StringJoiner;

public class AlertPage {

    private WebDriver driver;

    private By inputClickSimpleAlert = By.name("input_simple_alert");
    private By inputClickConfirmAlert = By.name("input_confirm_alert");
    private By inputClickPromptAlert = By.name("input_prompt_alert");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    private boolean alertDoAcceptSetInputText(WebElement element, String inputText) {
        boolean isAccepted = false;
        try {
            if(!(element == null)) {
                element.click();
            }
            if(!(inputText == null)) {
                element.sendKeys(inputText);
            }
            driver.switchTo().alert().accept();
            isAccepted = true;
        } catch(NoAlertPresentException e) {
            e.printStackTrace();
        }
        return isAccepted;
    }

    private boolean alertDoCancelSetInputText(WebElement element, String inputText) {
        boolean isCanceled = false;
        try {
            if(!(element == null)) {
                element.click();
            }
            if(!(inputText == null)) {
                element.sendKeys(inputText);
            }
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
            if(alertDoAcceptSetInputText(driver.findElement(inputClickSimpleAlert), null)) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkConfirmAlertOK() {
        boolean result = false;
        if(driver.findElement(inputClickConfirmAlert).isEnabled()) {
            if(alertDoAcceptSetInputText(driver.findElement(inputClickConfirmAlert), null)) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkConfirmAlertCancel() {
        boolean result = false;
        if(driver.findElement(inputClickConfirmAlert).isEnabled()) {
            if(alertDoCancelSetInputText(driver.findElement(inputClickConfirmAlert), null)) {
                alertDoAcceptSetInputText(null, null);
                result = true;
            }
        }
        return result;
    }
}