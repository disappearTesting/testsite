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

    private By submenuDropdown = By.className("submenu-dropdown");
    private By submenuCheckbox = By.className("submenu-checkbox");
    private By submenuRadioButton = By.className("submenu-radio-button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getTopMenuTitle(String className) {
        By topMenuTitle = By.className(className);
        return topMenuTitle;
    }

    public By getSubmenuDropdown() {
        return submenuDropdown;
    }

    public By getSubmenuCheckbox() {
        return submenuCheckbox;
    }

    public By getSubmenuRadioButton() {
        return submenuRadioButton;
    }
}