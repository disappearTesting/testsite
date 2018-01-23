/**
 * @author hookie
 * @version 1.0
 */
package unitTests.loginPage;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.PomLogin;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Unit_LoginAsAdministrator {

    private static final String URL = "http://testsite.local/rest/loginPage/login.php";
    private static final String URL_EXPECTED = "http://testsite.local/rest/loginPage/welcome.php";

    private static final List<String> TEXT_VALIDATION_EXPECTED = Arrays.asList("Please enter username.", "Please enter your password.");
    private static final List<String> TEXT_ERROR_EXPECTED = Arrays.asList("No account found with that username.", "The password you entered was not valid.");

    private WebDriver driver;
    private PomLogin objLogin;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objLogin = new PomLogin(driver);
        driver.get(URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_LoginNamePassword() {
        objLogin.loginSetNamePassword("test1", "123456");

        new WebDriverWait(driver, 5).until(urlContains(URL_EXPECTED));

        assertTrue(driver.getCurrentUrl().equals(URL_EXPECTED));
    }

    @Test
    public void test_LoginSetNamePasswordNullParams() {
        objLogin.loginSetNamePassword("", "");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objLogin.getHelpBlock()));

        List<WebElement> elements = driver.findElements(objLogin.getHelpBlock());
        String[] TEXT_VALIDATION_ACTUAL = new String[elements.size()];
        int i = 0;
        for(WebElement element : elements) {
            TEXT_VALIDATION_ACTUAL[i] = element.getText();
            assertEquals(TEXT_VALIDATION_EXPECTED, TEXT_VALIDATION_ACTUAL[i]);
        }
    }

    @Test
    public void test_LoginSetNamePasswordUnvalidName() {
        objLogin.loginSetNamePassword("tets", "123456");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objLogin.getHelpBlock()));

        List<WebElement> elements = driver.findElements(objLogin.getHelpBlock());

        for(WebElement element : elements) {
            System.out.println(element.getText().equals(TEXT_ERROR_EXPECTED));
            assertTrue(element.getText().equals("No account found with that username."));
        }
    }

    @Test
    public void test_LoginSetNamePasswordUnvalidPassword() {
        objLogin.loginSetNamePassword("test1", "123");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objLogin.getHelpBlock()));

        List<WebElement> elements = driver.findElements(objLogin.getHelpBlock());

        for(WebElement element : elements) {
            System.out.println(element.getText().equals(TEXT_ERROR_EXPECTED));
            assertTrue(element.getText().equals("The password you entered was not valid."));
        }
    }
}