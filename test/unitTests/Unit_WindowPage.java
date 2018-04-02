/**
 * @author hookie
 * @version 1.0
 */
package unitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.WindowPage;

public class Unit_WindowPage {

    private static final String URL_WINDOW_INDEX_PAGE = "http://testsite.local/rest/windowPage/index.php";
    private static final String URL_WINDOW_MAIN_PAGE = "http://testsite.local/rest/windowPage/main.php";
    private static final String URL_WINDOW_HOME_PAGE = "http://testsite.local/rest/windowPage/home.php";

    private WebDriver driver;
    private WindowPage objWindow;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objWindow = new WindowPage(driver);
        driver.get(URL_WINDOW_INDEX_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_BlankWindow() {
        objWindow.getParentWindowHandle();
        assertTrue("Something went wrong! getBlankWindow()", objWindow.getWindow("blank"));
        assertTrue("Something went wrong! getBlankWindowHandle()", objWindow.getParentWindow(objWindow.getParentWindowHandle(), URL_WINDOW_INDEX_PAGE));
    }

    @Test
    public void test_SelfWindow() {
        objWindow.getParentWindowHandle();
        assertTrue("Something went wrong! getBlankWindow()", objWindow.getWindow("self"));
        assertTrue("Something went wrong! getBlankWindowHandle()", objWindow.getParentWindow(objWindow.getParentWindowHandle(), URL_WINDOW_INDEX_PAGE));
    }

    @Test
    public void test_NewWindow() {
        objWindow.getParentWindowHandle();
        assertTrue("Something went wrong! getBlankWindow()", objWindow.getWindow("new"));
        assertTrue("Something went wrong! getBlankWindowHandle()", objWindow.getParentWindow(objWindow.getParentWindowHandle(), URL_WINDOW_INDEX_PAGE));
    }

    @Test
    public void test_IFrameWindow() {
        objWindow.getParentWindowHandle();
        objWindow.getIFrameWindow();
    }
}
