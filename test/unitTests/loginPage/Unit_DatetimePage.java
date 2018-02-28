package unitTests.loginPage;

import pom.DatetimeKendoUIPage;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Unit_DatetimePageKendoUI {

    private static final String URL_DATETIME_PAGE = "http://testsite.local/rest/datetimePage/datetime/index.php";

    private WebDriver driver;
    private DatetimeKendoUIPage objDatetime;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objDatetime = new DatetimeKendoUIPage(driver);
        driver.get(URL_DATETIME_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_SetDateTime_Javascript() {
        String resultDateTime = "01 January 1970 - 12:00 am";
        String resultDate = "01 January 1970";
        String resultTime = "00:00";

        WebElement elementDateTime = driver.findElement(objDatetime.getInputDateTime());
        WebElement elementDate = driver.findElement(objDatetime.getInputDate());
        WebElement elementTime = driver.findElement(objDatetime.getInputTime());

        // inputs has 'readonly' params, that because JS
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('input-datetime').value=" + "'" + resultDateTime + "'");
        javascriptExecutor.executeScript("document.getElementById('input-date').value=" + "'" + resultDate + "'");
        javascriptExecutor.executeScript("document.getElementById('input-time').value=" + "'" + resultTime + "'");

        assertEquals(resultDateTime, elementDateTime.getAttribute("value"));
        assertEquals(resultDate, elementDate.getAttribute("value"));
        assertEquals(resultTime, elementTime.getAttribute("value"));
    }

    @Test
    public void test_SetDateTime() {
        WebElement selectDatetime = driver.findElement(objDatetime.getDatetimeDropdownMenu());
        selectDatetime.click();
    }
}
