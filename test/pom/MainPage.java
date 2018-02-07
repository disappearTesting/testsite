/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;
    private static final String dropDownLinkText = null;

    public WebElement getDropDownMenu(String dropDownLinkText) {
        WebElement dropDownMenu = driver.findElement(By.linkText(dropDownLinkText));
        return dropDownMenu;
    }
}
