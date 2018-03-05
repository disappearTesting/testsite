/**
 * @author hookie
 * @version 1.0
 */
package unitTests;

import pom.CurrentDatetime;
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

import java.util.List;

public class Unit_DatetimeKendoUIPage {

    private static final String URL_DATETIME_PAGE = "http://testsite.local/rest/datetimePage/datetime/index.php";

    private WebDriver driver;
    private DatetimeKendoUIPage objDatetime;
    private CurrentDatetime objCurrentDatetime;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objDatetime = new DatetimeKendoUIPage(driver);
        objCurrentDatetime = new CurrentDatetime(driver);
        driver.get(URL_DATETIME_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_DateTimeDropdownMenu() {
        objDatetime.getDatetimeDropdownMenu();

        List<WebElement> elements = objDatetime.getElementsDatetimeDropdownMenu();
        boolean elementIsEnabled = false;
        for(WebElement element: elements) {
            elementIsEnabled = elementIsEnabled || element.isEnabled();
            System.out.println(elementIsEnabled);
        }
        assertTrue(elementIsEnabled);
    }

    @Test
    public void test_SetDateTimeAndRemove_Javascript() {
        String resultDateTime = "01 January 1970 - 12:00 am";

        WebElement elementInputDateTime = driver.findElement(objDatetime.getInputDateTime());

        // inputs has 'readonly' params, that because JS
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('input-datetime').value=" + "'" + resultDateTime + "'");

        assertEquals(resultDateTime, elementInputDateTime.getAttribute("value"));

        javascriptExecutor.executeScript("document.getElementsByClassName('icon-remove')[0].click()");

        assertEquals("", elementInputDateTime.getAttribute("value"));
    }

    @Test
    public void test_GetTodayDatetime() {

        String today = objDatetime.getCurrentDatetime();
        String currentDatetime = objCurrentDatetime.getCurrentDatetime();
        assertEquals(currentDatetime, today);
    }

    @Test
    public void test_SelectDatetime() {
        objDatetime.getDatetimeDropdownMenu();
        objDatetime.setYearDatetime("1970");
    }

}
