package unitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pom.ActionPage;
import pom.TestPage;

import static org.junit.Assert.assertTrue;

public class Unit_Test {
    private static final String URL_ACTION_PAGE = "http://testsite.local/rest/actionPage/index.php";

    private WebDriver driver;
    private Actions builder;
    private TestPage objTest;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        builder = new Actions(driver);
        objTest = new TestPage(driver, builder);
        driver.get(URL_ACTION_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_Test() {
        objTest.test();
    }
}
