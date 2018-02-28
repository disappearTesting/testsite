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

<<<<<<< HEAD:test/unitTests/loginPage/Unit_DatetimePage.java
public class Unit_DatetimePageKendoUI {
=======
import java.util.List;

public class Unit_DatetimeKendoUIPage {
>>>>>>> 2722adb9a385e4c68099027cbd7d2d514d7c54c8:test/unitTests/loginPage/Unit_DatetimeKendoUIPage.java

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

        WebElement elementDateTime = driver.findElement(objDatetime.getInputDateTime());

        // inputs has 'readonly' params, that because JS
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('input-datetime').value=" + "'" + resultDateTime + "'");

        assertEquals(resultDateTime, elementDateTime.getAttribute("value"));
    }

    @Test
<<<<<<< HEAD:test/unitTests/loginPage/Unit_DatetimePage.java
    public void test_SetDateTime() {
        WebElement selectDatetime = driver.findElement(objDatetime.getDatetimeDropdownMenu());
        selectDatetime.click();
=======
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
>>>>>>> 2722adb9a385e4c68099027cbd7d2d514d7c54c8:test/unitTests/loginPage/Unit_DatetimeKendoUIPage.java
    }
}
