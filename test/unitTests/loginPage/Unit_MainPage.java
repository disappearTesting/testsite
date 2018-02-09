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
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Unit_MainPage {

    private static final String URL_MAIN_PAGE = "http://testsite.local/rest/mainPage/main.php";
    private static final String TEXT_LINK_TOPMENU = "Main Page";

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
    public void test_TopmenuTitleIsActive() {

    }
}
