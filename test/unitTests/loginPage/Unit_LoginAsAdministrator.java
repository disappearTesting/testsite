/**
 * @author hookie
 * @version 1.0
 */
package unitTests.loginPage;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.PomLogin;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class Unit_LoginAsAdministrator {

    private static final String URL = "http://testsite.local/rest/loginPage/login.php";
    private static final String URL_EXPECTED = "http://testsite.local/rest/loginPage/welcome.php";
    private static final String[] EXPECTED_TEXT_VALIDATION = {"Please enter username.", "Please enter your password."};

    private WebDriver driver;
    private PomLogin objLogin;

    @Before
    public void before() {
        driver = new FirefoxDriver();
        objLogin = new PomLogin(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void test_loginNamePassword() {
        driver.get(URL);
        objLogin.loginSetNamePassword("test1", "123456");

        new WebDriverWait(driver, 5).until(urlContains(URL_EXPECTED));

        assertEquals(URL_EXPECTED, driver.getCurrentUrl());
    }

    @Test
    public void test_loginSetNamePasswordNullParams() {
        driver.get(URL);
        objLogin.loginSetNamePassword("", "");

        //  new WebDriverWait(driver, 5).until(presenceOfElementLocated(By.className("help-block")));

        List<WebElement> elements = driver.findElements(By.className("help-block"));
        String[] ACTUAL_TEXT_VALIDATION = new String[elements.size()];
        int i = 0;
        for(WebElement element : elements) {
            ACTUAL_TEXT_VALIDATION[i] = element.getText();
            assertEquals(EXPECTED_TEXT_VALIDATION, ACTUAL_TEXT_VALIDATION[i]);
        }
    }
}