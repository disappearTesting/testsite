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

    public Point getCoordinatesofElement(WebElement element) {
        if(element != null && element.isDisplayed()) {
            return element.getLocation();
        }
    }

    public int getSizeOfElement(WebElement element) {
        int size = 0;
        if(element != null && element.isDisplayed()) {
            int width = element.getSize().getWidth();
            int height = element.getSize().getHeight();
            size = width + height;
        }
        return size;
    }

    public boolean callAlertClickAndHold(String textAlert) throws TestRunException {
        WebElement elementButton = driver.findElement(buttonClickAndHold);
        if(elementButton != null && elementButton.isEnabled()) {
            builder.clickAndHold(elementButton).pause(3000).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            //  не использую описание ошибки, так как не юзаю класс Actions
            if(alert.getText().equals(textAlert)) {
                alert.accept();
                return true;
            }
        } else {
            throw new TestRunException("Error, elementButton is null or is't enabled");
        }
        return false;
    }

    public boolean callContextMenu() throws TestRunException {
        WebElement elementContextMenu = driver.findElement(buttonContextMenuHard);
        if(elementContextMenu != null && elementContextMenu.isEnabled()) {
            builder.contextClick(elementContextMenu).build().perform();
            if(driver.findElement(contextMenuHard).isEnabled()) {
                return true;
            }
        } else {
            throw new TestRunException("Error, elementContextMenu is null or is't enabled");
        }
        return false;
    }

    public boolean selectOption_ContextMenuHard_useValue(String value) throws TestRunException {
        WebElement elementSelect = driver.findElement(inputDropdownMenuContextMenuHard);
        if(elementSelect != null && elementSelect.isEnabled()) {
            Select select = new Select(elementSelect);
            for(WebElement element : select.getOptions()) {
                select.selectByValue(value);
                return true;
            }
        } else {
            throw new TestRunException("Error, elementSelect is null or is't enabled");
        }
        return false;
    }

    public boolean setTextToInput_ContextMenuHard(String text) throws TestRunException {
        WebElement elementInput = driver.findElement(inputTextContextMenuHard);
        if(elementInput != null && elementInput.isEnabled()) {
            builder.click(elementInput).sendKeys(text).build().perform();
            return true;
        } else {
            throw new TestRunException("Error, elementInput is null or is't enabled");
        }
    }

    public boolean toggleCheckbox_ContextMenuHard() throws TestRunException {
        WebElement elementCheckbox = driver.findElement(checkboxContextMenuHard);
        if(elementCheckbox.isEnabled()) {
            builder.moveToElement(elementCheckbox);
            for (int i = 1; i <= 2; i++) {
                builder.click().build().perform();
                return true;
            }
        } else {
            throw new TestRunException("Error, elementCheckbox is null or is't enabled");
        }
        return false;
    }

    // analogue method, without use class Actions
//    public boolean toggleCheckbox_ContextMenuHard() {
//        boolean result = false;
//        try {
//            builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
//            new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
//            for(int i = 1; i <= 2; i++) {
//                driver.findElement(checkboxContextMenuHard).click();
//            }
//            result = true;
//        } catch (NoSuchElementException | InvalidElementStateException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    public boolean selectRadioButton_ContextMenuHard() {
        List<WebElement> listRadioButtons = driver.findElements(radioButtonContextMenuHard);
        for(WebElement elementRadioButton : listRadioButtons) {
            if(!elementRadioButton.isEnabled()) {
                builder.moveToElement(elementRadioButton);
            } else {
                builder.click(elementRadioButton).build().perform();
            }
            if(listRadioButtons.indexOf(elementRadioButton) == (listRadioButtons.size() -1) && elementRadioButton.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public boolean performDragAndDropTextArea_ContextMenuHard() {
        return false;
    }
}