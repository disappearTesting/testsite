/**
 * @author hookie
 * @version 1.0
 */
package unitTests.loginPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Unit_MainPage {

    private static final String URL_MAIN_PAGE = "http://testsite.local/rest/mainPage/main.php";
    private static final String TEXT_CLASSNAME_DROPDOWN = "topmenu-dropdown";
    private static final String TEXT_CLASSNAME_CHECKBOX = "topmenu-checkbox";

    private static final List<String> TEXT_LINK_SUBMENU_DROPDOWN = Arrays.asList("Test", "Test", "Test");
    private static final List<String> TEXT_ID_SUBMENU_CHECKBOX = Arrays.asList("option_1", "option_2", "option_3");

    private WebDriver driver;
    private MainPage objMain;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objMain = new MainPage(driver);
        driver.get(URL_MAIN_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_SubmenuMenuIsVisible() {
        Actions builder = new Actions(driver);

        WebElement elementTopmenuTitle = driver.findElement(objMain.getTopMenuTitle(TEXT_CLASSNAME_DROPDOWN));
        WebElement elementSubmenuDropdown = driver.findElement(objMain.getSubmenuDropdown());

        builder.moveToElement(elementTopmenuTitle).perform();

        assertTrue(elementSubmenuDropdown.isDisplayed());
    }

    @Test
    public void test_SubmenuDropdownIsEnable() {
        Actions builder = new Actions(driver);

        WebElement elementTopmenuTitle = driver.findElement(objMain.getTopMenuTitle(TEXT_CLASSNAME_DROPDOWN));

        builder.moveToElement(elementTopmenuTitle).perform();

        for(int i = 0; i < TEXT_LINK_SUBMENU_DROPDOWN.size(); i++) {
            String linkTextSubmenuDropdown = TEXT_LINK_SUBMENU_DROPDOWN.get(i);
            WebElement elementSubmenuDropdown = driver.findElement(objMain.getElementSubmenuDropdown(linkTextSubmenuDropdown));
            elementSubmenuDropdown.isEnabled();
        }
    }

    @Test
    public void test_SubmenuCheckboxIsSelected() {
        Actions builder = new Actions(driver);

        WebElement elementTopmenuTitle = driver.findElement(objMain.getTopMenuTitle(TEXT_CLASSNAME_CHECKBOX));

        builder.moveToElement(elementTopmenuTitle).perform();

        for(int i = 0; i < TEXT_ID_SUBMENU_CHECKBOX.size(); i++) {
            String idSubmenuCheckbox = TEXT_ID_SUBMENU_CHECKBOX.get(i);
            WebElement elementSubmenuCheckbox = driver.findElement(objMain.getElementSubmenuCheckbox(idSubmenuCheckbox));
            elementSubmenuCheckbox.click();
            System.out.println(elementSubmenuCheckbox.isSelected());
        }

    }
}




























