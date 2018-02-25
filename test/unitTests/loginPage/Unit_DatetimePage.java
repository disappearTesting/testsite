package unitTests.loginPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.DatetimePage;

import java.util.concurrent.TimeUnit;

public class Unit_DatetimePage {

    private static final String URL_DATETIME_PAGE = "http://testsite.local/rest/datetimePage/datetime/index.php";

    private WebDriver driver;
    private DatetimePage objDatetime;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objDatetime = new DatetimePage(driver);
        driver.get(URL_DATETIME_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_SetDateTime_JavaScript() {
        // inputs has 'readonly' params, that because JS
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('input-datetime').value='01 January 1970 - 12:00 am'");
        javascriptExecutor.executeScript("document.getElementById('input-date').value='01 January 1970'");
        javascriptExecutor.executeScript("document.getElementById('input-time').value='00:00'");
        System.out.println(javascriptExecutor.executeScript("document.getElementById('input-datetime').value"));
    }

    @Test
    public void test_SetDateTime() {
        objDatetime.setDateTime("01 January 1970 - 12:00 am");
    }
}
