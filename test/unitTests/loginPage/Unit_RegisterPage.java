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

public class Unit_RegisterPage {

    private static final String URL_REGISTER_PAGE = "http://testsite.local/rest/loginPage/register.php";

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

    public void test_RegisterSetNamePassword() {
        objRegister.registerSetNamePassword("test2", "456789");

        new WebDriverWait(driver, 5).until(urlContains(URL_REGISTER_PAGE));
    }

    public void test_AvoidDoubleRegisterSetNamePassword() {

    }
}
