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

import java.util.List;

public class Unit_DatetimeKendoUIPage {

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
        driver.quit();
    }

    @Test
    public void test_SetDateTime_JavaScript() {
        String resultDateTime = "01 January 1970 - 12:00 am";

        WebElement elementDateTime = driver.findElement(objDatetime.getInputDateTime());

        // inputs has 'readonly' params, that because JS
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('input-datetime').value=" + "'" + resultDateTime + "'");

        assertEquals(resultDateTime, elementDateTime.getAttribute("value"));
    }

    @Test
    public void test_DateTimeDropdownMenu() {
        WebElement iconDatetime = driver.findElement(objDatetime.getIconDatetime());
        iconDatetime.click();

        List<WebElement> elements = objDatetime.getElementsDatetimeDropdownMenu();
        boolean elementIsEnabled = false;
        for(WebElement element: elements) {
            elementIsEnabled = elementIsEnabled || element.isEnabled();
            System.out.println(elementIsEnabled);
        }
        assertTrue(elementIsEnabled);
    }
}
