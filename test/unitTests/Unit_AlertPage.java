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
import pom.AlertPage;

public class Unit_AlertPage {

    private static final String URL_ALERT_PAGE = "http://testsite.local/rest/alertPage/index.php";

    private WebDriver driver;
    private AlertPage objAlert;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objAlert = new AlertPage(driver);
        driver.get(URL_ALERT_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_CheckSimpleAlertOK() {
        assertTrue("Something went wrong! checkSimpleAlertOK()", objAlert.checkSimpleAlertOK());
    }

    @Test
    public void test_CheckConfirmAlertOK() {
        assertTrue("Something went wrong! checkSimpleAlertOK()", objAlert.checkConfirmAlertOK());
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        assertEquals("User wants to continue!", driver.findElement(By.tagName("body")).getText());

        // or
        assertTrue(driver.getPageSource().contains("User wants to continue!"));
    }
}