/**
 * @author hookie
 * @version 1.0
 */
package unitTests.loginPage;

import pom.LoginPage;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.Arrays;
import java.util.List;

public class Unit_LoginPage {

    private static final String URL_LOGIN_PAGE = "http://testsite.local/rest/loginPage/login.php";
    private static final String URL_WELCOME_PAGE = "http://testsite.local/rest/loginPage/welcome.php";

    private static final List<String> TEXT_VALIDATION = Arrays.asList("Please enter username.", "Please enter your password.");

    private static final String TEXT_ERROR_UNVALID_NAME = "No account found with that username.";
    private static final String TEXT_ERROR_UNVALID_PASSWORD = "The password you entered was not valid.";

    private WebDriver driver;
    private LoginPage objLogin;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objLogin = new LoginPage(driver);
        driver.get(URL_LOGIN_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_SubmitButtonIsActive() {
        WebElement submitButton = driver.findElement(objLogin.getSubmitButton());

        new WebDriverWait(driver, 5).until(elementToBeClickable(objLogin.getSubmitButton()));

        assertTrue(submitButton.isEnabled());
    }

    @Test
    public void test_TextSignUpNowUpIsActive() {
        WebElement textSignUpNow = driver.findElement(objLogin.getTextSignUpNow());

        new WebDriverWait(driver, 5).until(elementToBeClickable(objLogin.getTextSignUpNow()));

        assertTrue(textSignUpNow.isEnabled());
    }

    @Test
    public void test_LoginNamePassword() {
        objLogin.loginSetNamePassword("test1", "123456");

        new WebDriverWait(driver, 5).until(urlContains(URL_WELCOME_PAGE));

        assertTrue(driver.getCurrentUrl().equals(URL_WELCOME_PAGE));
    }

    @Test
    public void test_LoginSetNamePasswordNullParams() {
        boolean testFail = false;

        objLogin.loginSetNamePassword("", "");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objLogin.getHelpBlock()));

        List<WebElement> elements = driver.findElements(objLogin.getHelpBlock());

        for(WebElement element : elements) {
            testFail = testFail || TEXT_VALIDATION.contains(element.getText());
        }
        assertTrue(testFail);
    }

    @Test
    public void test_LoginSetNamePasswordUnvalidName() {
        boolean testFail = false;

        objLogin.loginSetNamePassword("tets", "123456");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objLogin.getHelpBlock()));

        List<WebElement> elements = driver.findElements(objLogin.getHelpBlock());

        for(WebElement element : elements) {
            testFail = testFail || element.getText().equals(TEXT_ERROR_UNVALID_NAME);
        }
        assertTrue(testFail);
    }

    @Test
    public void test_LoginSetNamePasswordUnvalidPassword() {
        boolean testFail = false;

        objLogin.loginSetNamePassword("test1", "123");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objLogin.getFormGroupHasError()));

        List<WebElement> elements = driver.findElements(objLogin.getHelpBlock());

        for(WebElement element : elements) {
            testFail = testFail || element.getText().equals(TEXT_ERROR_UNVALID_PASSWORD);
        }
        assertTrue(testFail);
    }
}