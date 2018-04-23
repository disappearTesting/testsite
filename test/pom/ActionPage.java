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
    private JavascriptExecutor javascript;

    private static By buttonClickAndHold = By.id("button-clickAndHold");
    private static By buttonContextMenuHard = By.id("button-hard-contextMenu");
    private static By contextMenuHard = By.className("context-menu-list");
    private static By inputTextContextMenuHard = By.name("context-menu-input-name");
    private static By checkboxContextMenuHard = By.name("context-menu-input-yesno");
    private static By radioButtonContextMenuHard = By.name("context-menu-input-radio");
    private static By inputDropdownMenuContextMenuHard = By.name("context-menu-input-select");
    private static By textareaMain = By.id("input-textarea");
    private static By pContextMenuHard = By.id("demo");
    private static By resizeareaMain = By.className("box");
    private static By resizableHandleIconGrip = By.className("win-size-grip");

    public ActionPage(WebDriver driver, Actions builder) {
        this.driver = driver;
        this.builder = builder;
        this.javascript = (JavascriptExecutor)driver;
    }

    //logical method
    private Point getCoordinatesOfElement(WebElement element) throws TestRunException {
        Point position;
        if(element != null && element.isDisplayed()) {
           position = element.getLocation();
        } else {
            throw new TestRunException("getCoordinatesOfElement(). Error, element is null or is't displayed");
        }
        return position;
    }

    //logical method
    private int getSizeOfElement(WebElement element) throws TestRunException {
        int size;
        if(element != null && element.isDisplayed()) {
            int width = element.getSize().getWidth();
            int height = element.getSize().getHeight();
            size = width + height;
        } else {
            throw new TestRunException("getSizeOfElement(). Error, element is null or is't displayed");
        }
        return size;
    }

    //logical method
    private boolean resizeTheElement_UseJavascript() throws TestRunException {
        WebElement element = driver.findElement(textareaMain);
        if(element != null && element.isEnabled()) {
            javascript.executeScript("arguments[0].setAttribute('style', 'WIDTH:200px; HEIGHT:100px');", element);
            return true;
        } else {
            throw new TestRunException("resizeElement_UseJavascript(). Error, element is null or is't enabled");
        }
    }

    //logical method
    private boolean resizeTheElement(WebElement elementIcon, WebElement elementResize, int x, int y) throws TestRunException {
        int before = getSizeOfElement(elementResize);
        if(elementIcon != null && elementIcon.isEnabled()) {
            builder.dragAndDropBy(elementIcon, x, y).build().perform();
            new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(resizeareaMain));
            int after = getSizeOfElement(elementResize);
            if(after == (before + x + y) && elementResize.isDisplayed()) {
                return true;
            }
        } else {
            throw new TestRunException("resizeTheElement(). Error, element is null or is't enabled");
        }
        return false;
    }

    //action method
    public boolean resizeTheElement_ResizeArea() throws TestRunException {
        WebElement elementIconGrip = driver.findElement(resizableHandleIconGrip);
        WebElement elementResizeArea = driver.findElement(resizeareaMain);
        return resizeTheElement(elementIconGrip, elementResizeArea, 80, 80);
    }

    //logical method
    private String getCountOfRowsInElement_UseJavascript() throws TestRunException {
        String countOfRows;
        WebElement element = driver.findElement(pContextMenuHard);
        if(element != null && element.isEnabled()) {
            javascript.executeScript("var x = document.getElementsByTagName('textarea').rows; document.getElementById(\"demo\").innerHTML = x;");
            countOfRows = element.getText();
        } else {
            throw new TestRunException("getCountOfRowsInElement(). Error, element is null or is't enabled");
        }
        return countOfRows;
    }

    //logical method
    private boolean callAlertClickAndHold(WebElement element, String text) throws TestRunException {
        if(element != null && element.isEnabled()) {
            builder.clickAndHold(element).pause(3000).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            //  не использую описание ошибки, так как не юзаю класс Actions
            if(alert.getText().equals(text)) {
                alert.accept();
                return true;
            }
        } else {
            throw new TestRunException("callAlertClickAndHold(). Error, element is null or is't enabled");
        }
        return false;
    }

    //action method
    public boolean callAlertClickAndHold_ButtonClickAndHold() throws TestRunException {
        WebElement elementButton = driver.findElement(buttonClickAndHold);
        return callAlertClickAndHold(elementButton, "AlertClickAndHold");
    }

    //logical method
    private boolean callContextMenu(WebElement element) throws TestRunException {
        if(element != null && element.isEnabled()) {
            builder.contextClick(element).build().perform();
            if(driver.findElement(contextMenuHard).isEnabled()) {
                return true;
            }
        } else {
            throw new TestRunException("callContextMenu(). Error, element is null or is't enabled");
        }
        return false;
    }

    //action method
    public boolean callContextMenu_ButtonContextMenu() throws TestRunException {
        WebElement elementButton = driver.findElement(buttonContextMenuHard);
        return callContextMenu(elementButton);
    }

    //logical method
    private boolean selectOption_useValue(WebElement element, String value) throws TestRunException {
        if(element != null && element.isEnabled()) {
            Select select = new Select(element);
            for(WebElement elementSelect : select.getOptions()) {
                select.selectByValue(value);
                return true;
            }
        } else {
            throw new TestRunException("selectOption_ContextMenuHard_useValue(). Error, element is null or is't enabled");
        }
        return false;
    }

    //action method
    public boolean selectOption_useValue_InputDropdownMenu() throws TestRunException {
        WebElement elementDropdownMenu = driver.findElement(inputDropdownMenuContextMenuHard);
        return selectOption_useValue(elementDropdownMenu, "1");
    }

    //logical method
    private boolean setTextToInput(WebElement element, String text) throws TestRunException {
        if(element != null && element.isEnabled()) {
            builder.click(element).sendKeys(text).build().perform();
            return true;
        } else {
            throw new TestRunException("setTextToInput_ContextMenuHard(). Error, element is null or is't enabled");
        }
    }

    public boolean setTextToInput_inputText() throws TestRunException {
        WebElement elementInput = driver.findElement(inputTextContextMenuHard);
        return setTextToInput(elementInput, "test");

    }

    public boolean toggleCheckbox_ContextMenuHard() throws TestRunException {
        WebElement element = driver.findElement(checkboxContextMenuHard);
        if(element.isEnabled()) {
            builder.moveToElement(element);
            for (int i = 1; i <= 2; i++) {
                builder.click().build().perform();
                return true;
            }
        } else {
            throw new TestRunException("toggleCheckbox_ContextMenuHard(). Error, element is null or is't enabled");
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