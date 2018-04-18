/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class ActionPage {

    private WebDriver driver;
    private Actions builder;

    private static By buttonClickAndHold = By.id("button-clickAndHold");
    private static By buttonContextMenuHard = By.id("button-hard-contextMenu");
    private static By contextMenuHard = By.className("context-menu-list");
    private static By inputTextContextMenuHard = By.name("context-menu-input-name");
    private static By checkboxContextMenuHard = By.name("context-menu-input-yesno");
    private static By radioButtonContextMenuHard = By.name("context-menu-input-radio");
    private static By inputDropdownMenuContextMenuHard = By.name("context-menu-input-select");

    public ActionPage(WebDriver driver, Actions builder) {
        this.driver = driver;
        this.builder = builder;
    }

    public boolean callAlertClickAndHold(String textAlert) {
        WebElement elementButton = driver.findElement(buttonClickAndHold);
        if(elementButton != null && elementButton.isEnabled()) {
            builder.clickAndHold(elementButton).pause(3000).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            if(alert.getText().equals(textAlert)) {
                alert.accept();
                return true;
            }
        }
        return false;
    }

    public boolean callContextMenu() {
        WebElement elementContextMenu = driver.findElement(buttonContextMenuHard);
        if(elementContextMenu != null && elementContextMenu.isEnabled()) {
            builder.moveToElement(elementContextMenu).contextClick().build().perform();
            if(driver.findElement(contextMenuHard).isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public boolean selectOptionFromDropdownMenu_useValue(String value) {
        WebElement elementSelect = driver.findElement(inputDropdownMenuContextMenuHard);
        if(elementSelect != null && elementSelect.isEnabled()) {
            Select select = new Select(elementSelect);
            for(WebElement element : select.getOptions()) {
                select.selectByValue(value);
                return true;
            }
        }
        return false;
    }

    public boolean setTextToInput_ContextMenuHard_Action(String text) {
        WebElement elementInput = driver.findElement(inputTextContextMenuHard);
        if(elementInput != null && elementInput.isEnabled()) {
            builder.click(elementInput).sendKeys(text).build().perform();
            return true;
        }
        return false;
    }

    public boolean toggleCheckbox_ContextMenuHard_Action() {
        if(driver.findElement(buttonContextMenuHard).isEnabled()) {
            builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
            if(driver.findElement(checkboxContextMenuHard).isEnabled()) {
                builder.moveToElement(driver.findElement(checkboxContextMenuHard));
                for (int i = 1; i <= 2; i++) {
                    builder.click().build().perform();
                }
            }
        }
        return false;
    }


    // analogue method, without use class Actions
    public boolean toggleCheckbox_ContextMenuHard() {
        boolean result = false;
        try {
            builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
            for(int i = 1; i <= 2; i++) {
                driver.findElement(checkboxContextMenuHard).click();
            }
            result = true;
        } catch (NoSuchElementException | InvalidElementStateException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean selectRadioButton_ContextMenuHard_Action() {
        if(driver.findElement(buttonContextMenuHard).isEnabled()) {
            builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
            List<WebElement> listRadioButtons = driver.findElements(radioButtonContextMenuHard);
            for(WebElement elementRadioButton : listRadioButtons) {
                if(elementRadioButton.isEnabled()) {
                    builder.moveToElement(elementRadioButton).click().build().perform();
                }
            }
        }
        return false;
    }
}