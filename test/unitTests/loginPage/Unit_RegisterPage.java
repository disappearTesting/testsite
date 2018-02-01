package unitTests.loginPage;

import pom.RegisterPage;

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

public class Unit_RegisterPage {

    private static final String URL_REGISTER_PAGE = "http://testsite.local/rest/loginPage/register.php";
    private static final String URL_LOGIN_PAGE = "http://testsite.local/rest/loginPage/login.php";

    private static final List<String> TEXT_VALIDATION = Arrays.asList("Please enter a username.", "Please enter a password.", "Please confirm password.");

    private static final String TEXT_ERROR_USER_ALREADY_TAKEN = "This username is already taken.";

    private WebDriver driver;
    private RegisterPage objRegister;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objRegister = new RegisterPage(driver);
        driver.get(URL_REGISTER_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_SubmitButtonIsActive() {
        WebElement submitButton = driver.findElement(objRegister.getSubmitButton());

        new WebDriverWait(driver, 5).until(elementToBeClickable(objRegister.getSubmitButton()));

        assertTrue(submitButton.isEnabled());
    }

    @Test
    public void test_ResetButtonIsActive() {
        WebElement resetButton = driver.findElement(objRegister.getResetButton());

        new WebDriverWait(driver, 5).until(elementToBeClickable(objRegister.getResetButton()));

        assertTrue(resetButton.isEnabled());
    }

    @Test
    public void test_TextLoginHereIsActive() {
        WebElement textLoginHere = driver.findElement(objRegister.getTextLoginHere());

        new WebDriverWait(driver, 5).until(urlContains(URL_LOGIN_PAGE));

        assertTrue(driver.getCurrentUrl().equals(URL_LOGIN_PAGE));
    }

    @Test
    public void test_RegisterSetNamePassword() {
        objRegister.registerSetNamePassword("test2", "456789");

        new WebDriverWait(driver, 5).until(urlContains(URL_LOGIN_PAGE));

        assertTrue(driver.getCurrentUrl().equals(URL_LOGIN_PAGE));
    }

    @Test
    public void test_RegisterSetNamePasswordNullParams() {
        boolean testFail = false;

        objRegister.registerSetNamePassword("", "");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objRegister.getHelpBlock()));

        List<WebElement> elements = driver.findElements(objRegister.getHelpBlock());

        for(WebElement element: elements) {
            testFail = testFail || TEXT_VALIDATION.contains(element.getText());
        }
        assertTrue(testFail);
    }

    @Test
    public void test_AvoidDoubleRegisterSetNamePassword() {
        boolean testFail = false;

        objRegister.registerSetNamePassword("test3", "456456");

        new WebDriverWait(driver, 5).until(urlContains(URL_LOGIN_PAGE));

        driver.get(URL_REGISTER_PAGE);

        new WebDriverWait(driver, 5).until(urlContains(URL_REGISTER_PAGE));

        objRegister.registerSetNamePassword("test3", "456456");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objRegister.getHelpBlock()));

        List<WebElement> elements = driver.findElements(objRegister.getHelpBlock());

        for(WebElement element: elements) {
            testFail = testFail || element.getText().equals(TEXT_ERROR_USER_ALREADY_TAKEN);
        }
        assertTrue(testFail);
    }

    @Test
    public void test_ResetEnteredParams() {
        boolean testFail = false;
        objRegister.resetDataFromTextFields("test", "test");

        new WebDriverWait(driver, 5).until(urlContains(URL_REGISTER_PAGE));

        List<WebElement> elements = objRegister.getRegisterTextFields();

        for(WebElement element : elements) {
            testFail = testFail || element.getText().isEmpty();
        }
        assertTrue(testFail);
    }
}