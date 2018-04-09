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

    public boolean getAlertClickAndHold() {
        boolean result = false;
        try {
            builder.clickAndHold(driver.findElement(buttonClickAndHold)).pause(3000).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
            try {
                driver.switchTo().alert().accept();
                result = true;
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        } catch (NoSuchElementException | InvalidElementStateException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean setTextToInput_ContextMenuHard(String text) {
        boolean result = false;
        try {
            builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
            builder.moveToElement(driver.findElement(inputTextContextMenuHard)).click().sendKeys(text).build().perform();
            // click outside the area of the ContextMenuHard
            builder.moveToElement(driver.findElement(buttonContextMenuHard)).click().build().perform();
            result = true;
        } catch (NoSuchElementException | InvalidElementStateException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean setValueToCheckbox_ContextMenuHard() {
        boolean result =false;
        try {
            builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
            builder.moveToElement(driver.findElement(checkboxContextMenuHard));
            for(int i = 1; i <= 2; i++) {
                builder.click().build().perform();
                result = true;
            }
        } catch (NoSuchElementException | InvalidElementStateException e) {
            e.printStackTrace();
        }
        return result;
    }
}