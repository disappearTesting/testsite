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
    private static By textareaContextMenuHard = By.name("context-menu-input-area2");
    private static By pContextMenuHard = By.id("demo");
    private static By resizeareaMain = By.className("box");
    private static By resizableHandleIconGrip = By.className("win-size-grip");
    private static By selectSelectBoxMain = By.id("demoSel");
    private static By liSortBoxMain = By.className("ui-sortable-handle");

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
    private boolean resizeTheElement_UseJavascript(WebElement element) throws TestRunException {
        if(element != null && element.isEnabled()) {
            javascript.executeScript("arguments[0].setAttribute('style', 'WIDTH:250px; HEIGHT:200px');", element);
            return true;
        } else {
            throw new TestRunException("resizeElement_UseJavascript(). Error, element is null or is't enabled");
        }
    }

    //action method
    public boolean resizeTheElement_UseJavascript_Textarea_ContextMenu() throws TestRunException {
        WebElement elementTextarea = driver.findElement(textareaContextMenuHard);
        return resizeTheElement_UseJavascript(elementTextarea);
    }

    //logical method
    private boolean resizeTheElement_UseDragAndDrop(WebElement elementIcon, WebElement elementResize, int x, int y) throws TestRunException {
        if(elementResize != null && elementResize.isEnabled()) {
            int before = getSizeOfElement(elementResize);
            if(elementIcon != null && elementIcon.isEnabled()) {
                builder.dragAndDropBy(elementIcon, x, y).build().perform();
                new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(resizeareaMain));
                int after = getSizeOfElement(elementResize);
                if(after == (before + x + y) && elementResize.isDisplayed()) {
                    return true;
                }
            } else {
                throw new TestRunException("resizeTheElement(). Error, elementIcon is null or is't enabled");
            }
        } else {
            throw new TestRunException("resizeTheElement(). Error, elementResize is null or is't enabled");
        }
        return false;
    }

    //action method
    public boolean resizeTheElement_ResizeArea(int x, int y) throws TestRunException {
        WebElement elementIconGrip = driver.findElement(resizableHandleIconGrip);
        WebElement elementResizeArea = driver.findElement(resizeareaMain);
        return resizeTheElement_UseDragAndDrop(elementIconGrip, elementResizeArea, x, y);
    }

    //logical method
    private String getCountOfRowsInElement_UseJavascript() throws TestRunException {
        String countOfRows;
        WebElement setCount = driver.findElement(pContextMenuHard);
        if(setCount != null && setCount.isEnabled()) {
            javascript.executeScript("var x = document.getElementById('input-textarea').rows; document.getElementById(\"demo\").innerHTML = x;");
            countOfRows = setCount.getText();
        } else {
            throw new TestRunException("getCountOfRowsInElement_UseJavascript(). Error, element is null or is't enabled");
        }
        return countOfRows;
    }

    //action method
    public String getCountOfRowsInTextArea_UseJavascript() throws TestRunException {
        return getCountOfRowsInElement_UseJavascript();
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
    private boolean selectOption_UseValue(WebElement element, String attribute, String[] values) throws TestRunException {
        if(element != null) {
            Select select = new Select(element);
            for(WebElement option : select.getOptions()) {
                for(String value : values) {
                    if(option.getAttribute(attribute).equals(value) && option.isEnabled()) {
                        select.selectByValue(value);
                    } else {
                        builder.moveToElement(option);
                    }
                }
                if(select.getOptions().indexOf(option) == (select.getOptions().size() -1)) {
                    return true;
                }
            }
        } else {
            throw new TestRunException("selectOption_UseValue(). Error, element is null or is't enabled");
        }
        return false;
    }

    //action method
    public boolean selectOption_UseValue_InputDropdownMenu(String attribute, String[] values) throws TestRunException {
        WebElement elementDropdownMenu = driver.findElement(inputDropdownMenuContextMenuHard);
        return selectOption_UseValue(elementDropdownMenu, attribute, values);
    }

    //action method
    public boolean selectOption_UseValue_SelectBox(String attribute, String[] values) throws TestRunException {
        WebElement selectBox = driver.findElement(selectSelectBoxMain);
        return selectOption_UseValue(selectBox, attribute, values);
    }

    //logical method
    public WebElement getElementFromList_UseText(List<WebElement> listOfElements, String item) throws TestRunException {
        for(WebElement element : listOfElements) {
            if(element.getText().equals(item)) {
                return element;
            }
        }
        return null;
    }

    //logical method
    public boolean sortElement_UseDragAndDrop(String itemThat, String itemTo) throws TestRunException {
        List<WebElement> listOfElements = driver.findElements(liSortBoxMain);
        WebElement elementThat = getElementFromList_UseText(listOfElements, itemThat);
        WebElement elementTo = getElementFromList_UseText(listOfElements, itemTo);
        if(elementThat.isEnabled()) {
            builder.clickAndHold(elementThat).moveToElement(elementTo).release().build().perform();
        } else {
            throw new TestRunException("sortElement_UseDragAndDrop(). Error, element is't displayed");
        }
        //builder.clickAndHold(elementThat).moveToElement(elementTo).release().build().perform();
        return false;
    }

    //logical method
    private boolean selectMultipleOption_UseDragAndDrop(List<WebElement> listOfElements, String value) {
        for(WebElement element : listOfElements) {
            if(element != null && element.isEnabled()) {
                //builder.moveToElement().clickAndHold();
            }
        }
        return false;
    }

    //logical method
    private boolean setTextToInput(WebElement element, String text) throws TestRunException {
        if(element != null && element.isEnabled()) {
            builder.click(element).sendKeys(text).build().perform();
            return true;
        } else {
            throw new TestRunException("setTextToInput(). Error, element is null or is't enabled");
        }
    }

    //action method
    public boolean setTextToInput_InputText() throws TestRunException {
        WebElement elementInput = driver.findElement(inputTextContextMenuHard);
        return setTextToInput(elementInput, "test");

    }

    //logical method
    private boolean toggleCheckbox(WebElement element) throws TestRunException {
        if(element.isEnabled()) {
            builder.moveToElement(element);
            for (int i = 1; i <= 2; i++) {
                builder.click().build().perform();
                return true;
            }
        } else {
            throw new TestRunException("toggleCheckbox(). Error, element is null or is't enabled");
        }
        return false;
    }

    //action method
    public boolean toggleCheckbox_ElementCheckbox() throws TestRunException {
        WebElement elementCheckbox = driver.findElement(checkboxContextMenuHard);
        return toggleCheckbox(elementCheckbox);
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

    //logical method
    private boolean selectRadioButton(List<WebElement> listOfElements) throws TestRunException {
        for(WebElement elementRadioButton : listOfElements) {
            if(elementRadioButton != null && elementRadioButton.isDisplayed()) {
                if(!elementRadioButton.isEnabled()) {
                    builder.moveToElement(elementRadioButton);
                } else {
                    builder.click(elementRadioButton).build().perform();
                }
                if(listOfElements.indexOf(elementRadioButton) == (listOfElements.size() -1) && elementRadioButton.isSelected()) {
                    return true;
                }
            } else {
                throw new TestRunException("selectRadioButton(). Error, element is null or is't enabled");
            }
        }
        return false;
    }

    //action method
    public boolean selectRadioButton_RadioButton() throws TestRunException {
        List<WebElement> listRadioButtons = driver.findElements(radioButtonContextMenuHard);
        return selectRadioButton(listRadioButtons);
    }
}