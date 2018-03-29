/**
 * @author hookie
 * @version 1.0
 */
package unitTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        driver.quit();
    }
}
