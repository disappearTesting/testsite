/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class ActionPage {

    private WebDriver driver;
    private Actions builder;

    private static By buttonClickAndHold = By.id("button-clickAndHold");
    private static By buttonContextMenuHard = By.id("button-hard-contextMenu");
    private static By contextMenuHard = By.className("context-menu-list");
    private static By inputTextContextMenuHard = By.name("context-menu-input-name");
    private static By checkboxContextMenuHard = By.name("context-menu-input-yesno");

    public ActionPage(WebDriver driver, Actions builder) {
        this.driver = driver;
        this.builder = builder;
    }

    public SetTextTestResult getAlertClickAndHold_Action() {
        boolean result = true;
        String message = null;
        try {
            if(driver.findElement(buttonClickAndHold).isEnabled()) {
                builder.clickAndHold(driver.findElement(buttonClickAndHold)).pause(3000).build().perform();
                new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
                try {
                    driver.switchTo().alert().accept();
                } catch (NoAlertPresentException e) {
                    message = e.getMessage();
                    result =  false;
                }
            } else {
                message = "Error. Element buttonClickAndHold is't enabled!";
                result =  false;
            }
        } catch (NoSuchElementException | InvalidElementStateException e) {
            message = e.getMessage();
            result =  false;
        }
        return new SetTextTestResult(result, message);
    }

    public SetTextTestResult setTextToInput_ContextMenuHard_Action(String text) {
        boolean result = true;
        String message = null;
        try {
            if(driver.findElement(buttonContextMenuHard).isEnabled()) {
                builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
                new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
                if(driver.findElement(inputTextContextMenuHard).isEnabled()) {
                    builder.moveToElement(driver.findElement(inputTextContextMenuHard)).click().sendKeys(text).build().perform();
                } else {
                    message = "Error. Element inputTextContextMenuHard is't enabled!";
                    result =  false;
                }
                // close the ContextMenuHard
                builder.moveToElement(driver.findElement(buttonContextMenuHard)).click().build().perform();
            } else {
                message = "Error. Element buttonContextMenuHard is't enabled!";
                result =  false;
            }
        } catch (NoSuchElementException | InvalidElementStateException e) {
            message = e.getMessage();
            result =  false;
        }
        return new SetTextTestResult(result, message);
    }

    public SetTextTestResult setValueToCheckbox_ContextMenuHard_Action() {
        boolean result = true;
        String message = null;
        try {
            if(driver.findElement(buttonContextMenuHard).isEnabled()) {
                builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
                new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
                if(driver.findElement(checkboxContextMenuHard).isEnabled()) {
                    builder.moveToElement(driver.findElement(checkboxContextMenuHard));
                    for (int i = 1; i <= 2; i++) {
                        builder.click().build().perform();
                    }
                } else {
                    message = "Error. Element checkboxContextMenuHard is't enabled!";
                    result =  false;
                }
            }
        } catch (NoSuchElementException | InvalidElementStateException e) {
            message = e.getMessage();
            result =  false;
        }
        return new SetTextTestResult(result, message);
    }

    public SetTextTestResult setValueToCheckbox_ContextMenuHard() {
        boolean result = true;
        String message = null;
        try {
            builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
            for(int i = 1; i <= 2; i++) {
                driver.findElement(checkboxContextMenuHard).click();
            }
        } catch (NoSuchElementException | InvalidElementStateException e) {
            message = "Error. Element checkboxContextMenuHard is't enabled!";
            result =  false;
        }
        return new SetTextTestResult(result, message);
    }
}