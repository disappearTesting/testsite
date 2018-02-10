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

    private static final List<String> TEXT_LINK_SUBMENU_DROPDOWN = Arrays.asList("Test", "Test", "Test");

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

        new WebDriverWait(driver,5).until(presenceOfElementLocated(objMain.getSubmenuDropdown()));

        assertTrue(elementSubmenuDropdown.isDisplayed());
    }

    @Test
    public void test_SubmenuDropdownIsEnable() {

    }
}
