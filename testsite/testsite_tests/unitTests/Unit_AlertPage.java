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

    private static final String URL_ALERT_PAGE = "http://testsite.local/testsite_resources/alertPage/index.php";

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

    @Test
    public void test_CheckConfirmAlertCancel() {
        assertTrue("Something went wrong! checkSimpleAlertCancel()", objAlert.checkConfirmAlertCancel());
    }

    @Test
    public void test_CheckPromptAlertOK() {
        String expectedValue = "admin";
        assertTrue("Something went wrong! checkPromptAlertOK()", objAlert.checkPromptAlertOK(expectedValue));
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("body")));
        assertEquals("You have entered : " + expectedValue, driver.findElement(By.tagName("body")).getText());
    }

    @Test
    public void test_CheckPromptAlertCancel() {
        assertTrue("Something went wrong! checkPromptAlertCancel()", objAlert.checkPromptAlertCancel());
    }
}