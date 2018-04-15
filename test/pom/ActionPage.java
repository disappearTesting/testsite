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

    private boolean getContextMenu(WebElement elementContextMenu) {
        boolean result = false;
        if(elementContextMenu != null && elementContextMenu.isEnabled()) {
            try {
                builder.moveToElement(elementContextMenu).contextClick().build().perform();
                result = true;
            } catch (NoSuchElementException | InvalidElementStateException e) {
                System.out.println("getContextMenu(). Error, contextClick()!");
            }
        } else {
            System.out.println("getContextMenu(). Error, elementContextMenu is null or is enabled!");
        }
        return result;
    }

    private boolean selectOptionFromDropDown_useValue(WebElement elementSelect, String value) {
        boolean result = false;
        if(elementSelect != null && elementSelect.isEnabled()) {
            try {
                Select select = new Select(elementSelect);
                for(WebElement element : select.getOptions()) {
                    if(element.getAttribute("value").contains(value)) {
                        select.selectByValue(value);
                        result = true;
                        break;
                    } else {
                        System.out.println("selectOptionFromDropDown_useValue(). Error, getAttribute(value) is't contains value!");
                        break;
                    }
                }
            } catch (NoSuchElementException | InvalidElementStateException e) {
                e.getMessage();
            }
        } else {
            System.out.println("selectOptionFromDropDown_useValue(). Error, elementSelect is null or is enabled!");
        }
        return result;
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

    public SetTextTestResult toggleCheckbox_ContextMenuHard_Action() {
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

    public SetTextTestResult selectRadioButton_ContextMenuHard_Action() {
        boolean result = true;
        String message = null;
        try {
            if(driver.findElement(buttonContextMenuHard).isEnabled()) {
                builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
                new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
                List<WebElement> listRadioButtons = driver.findElements(radioButtonContextMenuHard);
                for(WebElement elementRadioButton : listRadioButtons) {
                    if(elementRadioButton.isEnabled()) {
                        builder.moveToElement(elementRadioButton).click().build().perform();
                    } else {
                        message = "Error. Element radioButtonContextMenuHard is't enabled!";
                        result =  false;
                    }
                }
            } else {
                message = "Error. Element buttonContextMenuHard is't enabled!";
                result =  false;
            }
        } catch (NoSuchElementException | InvalidElementStateException e) {
            message = e.getMessage();
            result = false;
        }
        return new SetTextTestResult(result, message);
    }

    public void selectOption_ContextMenuHard_Action(String value) {
        getContextMenu(driver.findElement(buttonContextMenuHard));
        selectOptionFromDropDown_useValue(driver.findElement(inputDropdownMenuContextMenuHard), value);
    }
}