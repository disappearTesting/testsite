/**
 * @author hookie
 * @version 1.0
 */
package unitTests;

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

    private static final String URL_LOGIN_PAGE = "http://testsite.local/testsite_resources/loginPage/login.php";
    private static final String URL_REGISTER_PAGE = "http://testsite.local/testsite_resources/loginPage/register.php";
    private static final String URL_HOME_PAGE = "http://testsite.local/testsite_resources/loginPage/home.php";

    private static final List<String> TEXT_ERROR_EMPTY = Arrays.asList("Please enter your email address.", "Please enter your password.");
    private static final List<String> TEXT_ERROR_VALIDATE_VALUE = Arrays.asList("Please enter valid email address.");
    private static final String TEXT_ERROR_LOGIN = "Incorrect Credentials, Try again.";

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
    public void test_ButtonSignInIsActive() {
        WebElement buttonGignIn = driver.findElement(objLogin.getButtonSignIn());

        new WebDriverWait(driver, 5).until(elementToBeClickable(objLogin.getButtonSignIn()));

        assertTrue(buttonGignIn.isEnabled());
    }

    @Test
    public void test_GetRegisterPage() {
        objLogin.getRegisterPage();

        new WebDriverWait(driver, 5).until(urlContains(URL_REGISTER_PAGE));

        assertTrue(driver.getCurrentUrl().equals(URL_REGISTER_PAGE));
    }

    @Test
    public void test_Login() {
        objLogin.loginSetEmailPassword("makarov@smartproject.ua", "123456");

        new WebDriverWait(driver, 5).until(urlContains(URL_HOME_PAGE));

        assertTrue(driver.getCurrentUrl().equals(URL_HOME_PAGE));
    }

    @Test
    public void test_LoginSetNullParams() {
        int i = 0;
        int eqCount = 0;

        objLogin.loginSetEmailPassword("", "");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objLogin.getTextDanger()));

        List<WebElement> elements = driver.findElements(objLogin.getTextDanger());

        // Проверка каждого с каждым, на одном уровне
        for(WebElement element: elements) {
            if(TEXT_ERROR_EMPTY.get(i++).equals(element.getText())){
                eqCount++;
            }
        }
        assertTrue(elements.size() == eqCount);
    }

    @Test
    public void test_LoginSetInvalidEmail() {
        int i = 0;
        int eqCount = 0;

        objLogin.loginSetEmailPassword("scanword_test/test", "");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objLogin.getTextDanger()));

        List<WebElement> elements = driver.findElements(objLogin.getTextDanger());

        for(WebElement element: elements) {
            if(TEXT_ERROR_VALIDATE_VALUE.get(i++).equals(element.getText())){
                eqCount++;
            }
        }
        assertTrue(elements.size() == eqCount);
    }

    @Test
    public void test_LoginSetIncorrectCredentials() {
        objLogin.loginSetEmailPassword("makarov@smartproject.ua", "scanword_test/test");

        new WebDriverWait(driver, 5).until(presenceOfElementLocated(objLogin.getAlertDanger()));

        WebElement element = driver.findElement(objLogin.getAlertDanger());

        assertTrue(element.getText().equals(TEXT_ERROR_LOGIN));
    }
}