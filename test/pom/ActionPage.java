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

import java.util.NoSuchElementException;

public class ActionPage {

    private WebDriver driver;
    private Actions builder;

    private By buttonClickAndHold = By.id("button-clickAndHold");

    public ActionPage(WebDriver driver, Actions builder) {
        this.driver = driver;
        this.builder = builder;
    }

    public boolean getAlertClickAndHold() {
        boolean result = false;
        try {
            builder.clickAndHold(driver.findElement(buttonClickAndHold)).pause(3000).build().perform();
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
}
