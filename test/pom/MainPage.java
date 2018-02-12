/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    private By submenuDropdown = By.className("submenu-dropdown");
    private By submenuCheckbox = By.className("submenu-checkbox");
    private By submenuRadioButton = By.className("submenu-radio-button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getTopMenuTitle(String className) {
        By topmenuTitle = By.className(className);
        return topmenuTitle;
    }

    // for check that submenu is visible
    public By getSubmenuDropdown() {
        return submenuDropdown;
    }

    public By getElementSubmenuDropdown(String linkText) {
        By elementSubmenuDropdown = By.linkText(linkText);
        return elementSubmenuDropdown;
    }

    public By getElementSubmenuCheckbox(String id) {
        By elementSubmenuCheckbox = By.id(id);
        return elementSubmenuCheckbox;
    }

    public By getElementSubmenuRadioButton(String id) {
        By elementSubmenuRadioButton = By.id(id);
        return elementSubmenuRadioButton;
    }

}