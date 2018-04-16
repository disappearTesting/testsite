package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestPage {
    private WebDriver driver;
    private Actions builder;

    private static By buttonClickAndHold = By.id("button-clickAndHold");
    private static By buttonContextMenuHard = By.id("button-hard-contextMenu");
    private static By contextMenuHard = By.className("context-menu-list");
    private static By inputTextContextMenuHard = By.name("context-menu-input-name");
    private static By checkboxContextMenuHard = By.name("context-menu-input-yesno");
    private static By radioButtonContextMenuHard = By.name("context-menu-input-radio");
    private static By inputDropdownMenuContextMenuHard = By.name("context-menu-input-select");

    public TestPage(WebDriver driver, Actions builder) {
        this.driver = driver;
        this.builder = builder;
    }

    public void test() {
        Select select = new Select(driver.findElement(inputDropdownMenuContextMenuHard));
        select.getOptions();
        builder.contextClick(driver.findElement(buttonContextMenuHard)).build().perform();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(contextMenuHard));
        //driver.findElement(inputDropdownMenuContextMenuHard).getAttribute("value");
        //List<WebElement> listOfElements = driver.findElements(inputDropdownMenuContextMenuHard);
        for(WebElement element : select.getOptions()) {
            System.out.println(element.getText());
            System.out.println(element.getAttribute("value"));
            //System.out.println(element.getAttribute("value"));
        }
//        if(select.getOptions().contains("1")) {
//
//        } else {
//            System.out.println("Error!");
//        }
    }
}
