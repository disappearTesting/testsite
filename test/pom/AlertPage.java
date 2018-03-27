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

    private void alertDoAcceptSetInputText(WebElement element, String inputText) {
        try {
            if(!(element == null)) {
                element.click();
            }
            if(!(inputText == null)) {
                driver.switchTo().alert().sendKeys(inputText);
            }
            driver.switchTo().alert().accept();
        } catch(NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    private void alertDoCancelSetInputText(WebElement element, String inputText) {
        try {
            if(!(element == null)) {
                element.click();
            } else if(!(inputText == null)) {
                driver.switchTo().alert().sendKeys(inputText);
            }
            driver.switchTo().alert().dismiss();
        } catch(NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public boolean checkSimpleAlertOK() {
        boolean result = false;
        if(driver.findElement(inputClickSimpleAlert).isEnabled()) {
            alertDoAcceptSetInputText(driver.findElement(inputClickSimpleAlert), null);
            result = true;
        }
        return result;
    }

    public boolean checkConfirmAlertOK() {
        boolean result = false;
        if(driver.findElement(inputClickConfirmAlert).isEnabled()) {
            alertDoAcceptSetInputText(driver.findElement(inputClickConfirmAlert), null);
            result = true;
        }
        return result;
    }

    public boolean checkConfirmAlertCancel() {
        boolean result = false;
        if(driver.findElement(inputClickConfirmAlert).isEnabled()) {
            alertDoCancelSetInputText(driver.findElement(inputClickConfirmAlert), null);
            alertDoAcceptSetInputText(null, null);
            result = true;
        }
        return result;
    }

    public boolean checkPromptAlertOK(String text) {
        boolean result = false;
        if(driver.findElement(inputClickPromptAlert).isEnabled()) {
            alertDoAcceptSetInputText(driver.findElement(inputClickPromptAlert),text);
            result = true;
        }
        return result;
    }

    public boolean checkPromptAlertCancel() {
        boolean result = false;
        if(driver.findElement(inputClickPromptAlert).isEnabled()) {
            alertDoCancelSetInputText(driver.findElement(inputClickPromptAlert), null);
            result = true;
        }
        return result;
    }
}