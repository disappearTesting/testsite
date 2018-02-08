/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    private By submenu = By.className("submenu");

    public By getSubmenu() {
        return submenu;
    }

    public List<WebElement> getDropDownMenu(String linkText) {
        List<WebElement> dropDownMenuElements = driver.findElements(By.linkText(linkText));
        return dropDownMenuElements;
    }
}