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

    public Point getCoordinatesOfElement(WebElement element) {
        Point position = null;
        if(element != null && element.isDisplayed()) {
           position = element.getLocation();
        }
        return position;
    }

    public int getSizeOfElement(WebElement element) throws TestRunException {
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

    public void resizeTheElement(WebElement element, int x, int y) throws TestRunException {
        if(element != null && element.isEnabled()) {
            builder.dragAndDropBy(element, x, y).build().perform();
        } else {
            throw new TestRunException("resizeTheElement(). Error, element is null or is't enabled");
        }
    }

    public void resizeElement_UseJavascript() throws TestRunException {
        WebElement element = driver.findElement(textareaMain);
        if(element != null && element.isEnabled()) {
            javascript.executeScript("arguments[0].setAttribute('style', 'WIDTH:200px; HEIGHT:100px');", element);
        } else {
            throw new TestRunException("resizeElement_UseJavascript(). Error, element is null or is't enabled");
        }
    }

    public boolean resizeTheElement_ResizeArea() throws TestRunException, InterruptedException {
        int x = 80;
        int y = 80;
        WebElement elementIconGrip = driver.findElement(resizableHandleIconGrip);
        WebElement elementResizeArea = driver.findElement(resizeareaMain);
        int before = getSizeOfElement(elementResizeArea);
        resizeTheElement(elementIconGrip, x, y);
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(resizeareaMain));
        int after = getSizeOfElement(elementResizeArea);
        if(after == (before + x + y)) {
            return true;
        }
        return false;
    }

    public String getCountOfRowsInElement_UseJavascript() throws TestRunException {
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

    public boolean callAlertClickAndHold(String textAlert) throws TestRunException {
        WebElement element = driver.findElement(buttonClickAndHold);
        if(element != null && element.isEnabled()) {
            builder.clickAndHold(element).pause(3000).build().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            //  не использую описание ошибки, так как не юзаю класс Actions
            if(alert.getText().equals(textAlert)) {
                alert.accept();
                return true;
            }
        } else {
            throw new TestRunException("callAlertClickAndHold(). Error, element is null or is't enabled");
        }
        return false;
    }

    public boolean callContextMenu() throws TestRunException {
        WebElement element = driver.findElement(buttonContextMenuHard);
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

    public boolean selectOption_ContextMenuHard_useValue(String value) throws TestRunException {
        WebElement element = driver.findElement(inputDropdownMenuContextMenuHard);
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

    public boolean setTextToInput_ContextMenuHard(String text) throws TestRunException {
        WebElement element = driver.findElement(inputTextContextMenuHard);
        if(element != null && element.isEnabled()) {
            builder.click(element).sendKeys(text).build().perform();
            return true;
        } else {
            throw new TestRunException("setTextToInput_ContextMenuHard(). Error, element is null or is't enabled");
        }
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