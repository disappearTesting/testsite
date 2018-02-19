/**
 * @author hookie
 * @version 1.0
 */
package unitTests.loginPage;

import pom.MySQLQueries_Testsite;
import pom.RegisterPage;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Unit_RegisterPage {

    private static final String URL_REGISTER_PAGE = "http://testsite.local/rest/loginPage/register.php";
    private static final String URL_LOGIN_PAGE = "http://testsite.local/rest/loginPage/login.php";

    private static final List<String> TEXT_ERROR_EMPTY = Arrays.asList("Please enter your full name.", "Please enter valid email address.", "Please enter password.");
    private static final List<String> TEXT_ERROR_VALIDATE_VALUE = Arrays.asList("Name must contain alphabets and space.", "Please enter valid email address.", "Please enter password.");
    private static final List<String> TEXT_ERROR_VALIDATE_LENGTH = Arrays.asList("Name must have at least 3 characters.", "Please enter valid email address.", "Password must have at least 6 characters.");
    private static final List<String> TEXT_ERROR_VALIDATE_ALREADY_USE = Arrays.asList("", "Provided Email is already in use.", "");

    private static final String TEXT_SUCCESS_REGISTER = "Successfully registered, you may login now.";

    private static final String SQL_DELETE_FROM_WHERE = "DELETE FROM testsite.users WHERE userName = 'ATester'";

    private WebDriver driver;
    private RegisterPage objRegister;
    private MySQLQueries_Testsite objSQLQueries;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objRegister = new RegisterPage(driver);
        objSQLQueries =  new MySQLQueries_Testsite();
        driver.get(URL_REGISTER_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_ButtonSignUpIsActive() {
        WebElement submitButton = driver.findElement(objRegister.getButtonSignUp());

        new WebDriverWait(driver, 5).until(elementToBeClickable(objRegister.getButtonSignUp()));

        assertTrue(submitButton.isEnabled());
    }

    @Test
    public void test_GetLoginPage() {
        objRegister.getLoginPage();

        new WebDriverWait(driver, 5).until(urlContains(URL_LOGIN_PAGE));

        assertTrue(driver.getCurrentUrl().equals(URL_LOGIN_PAGE));
    }

    @Test
    public void test_Register() throws SQLException, ClassNotFoundException {
        objRegister.registerSetNameEmailPassword("ATester", "atest@example.com", "456456");

        new WebDriverWait(driver, 5).until(presenceOfElementLocated(objRegister.getRegisterSuccess()));

        WebElement element = driver.findElement(objRegister.getRegisterSuccess());

        objSQLQueries.getSQLQueries(SQL_DELETE_FROM_WHERE);
        assertEquals(1, objSQLQueries.getSQLExecuteUpdated(SQL_DELETE_FROM_WHERE));
        objSQLQueries.disconnect();

        assertTrue(element.getText().equals(TEXT_SUCCESS_REGISTER));
    }

    @Test
    public void test_RegisterNullParams() {
        int i = 0;
        int eqCount = 0;

        objRegister.registerSetNameEmailPassword("", "", "");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objRegister.getTextDanger()));

        List<WebElement> elements = driver.findElements(objRegister.getTextDanger());

        // Проверка каждого с каждым, на одном уровне
        for(WebElement element: elements) {
            if(TEXT_ERROR_EMPTY.get(i++).equals(element.getText())){
                eqCount++;
            }
        }
        assertTrue(elements.size() == eqCount);
    }

    @Test
    public void test_RegisterInvalidParamsValidateValue() {
        int i = 0;
        int eqCount = 0;

        objRegister.registerSetNameEmailPassword("@Tester", "", "");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objRegister.getTextDanger()));

        List<WebElement> elements = driver.findElements(objRegister.getTextDanger());

        // Проверка каждого с каждым, на одном уровне
        for(WebElement element: elements) {
            if(TEXT_ERROR_VALIDATE_VALUE.get(i++).equals(element.getText())){
                eqCount++;
            }
        }
        assertTrue(elements.size() == eqCount);
    }

    @Test
    public void test_RegisterInvalidParamsValidateLength() {
        int i = 0;
        int eqCount = 0;

        objRegister.registerSetNameEmailPassword("t", "@example.com", "test");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objRegister.getTextDanger()));

        List<WebElement> elements = driver.findElements(objRegister.getTextDanger());

        // Проверка каждого с каждым, на одном уровне
        for(WebElement element: elements) {
            if(TEXT_ERROR_VALIDATE_LENGTH.get(i++).equals(element.getText())){
                eqCount++;
            }
        }
        assertTrue(elements.size() == eqCount);
    }

    @Test
    public void test_AvoidDoubleRegister() {
        int i = 0;
        int eqCount = 0;

        objRegister.registerSetNameEmailPassword("BTester", "btest@example.com", "456456");

        new WebDriverWait(driver, 5).until(presenceOfElementLocated(objRegister.getRegisterSuccess()));

        objRegister.registerSetNameEmailPassword("BTester", "btest@example.com", "456456");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objRegister.getTextDanger()));

        List<WebElement> elements = driver.findElements(objRegister.getTextDanger());

        for(WebElement element: elements) {
            if(TEXT_ERROR_VALIDATE_ALREADY_USE.get(i++).equals(element.getText())){
                eqCount++;
            }
        }
        assertTrue(elements.size() == eqCount);
    }
}