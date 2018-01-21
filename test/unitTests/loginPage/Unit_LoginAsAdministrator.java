/**
 * @author hookie
 * @version 1.0
 */
package unitTests.loginPage;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.PomLogin;

import javax.annotation.Nullable;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class Unit_LoginAsAdministrator {

    private static final String URL = "http://testsite.local/rest/loginPage/login.php";
    private static final String URL_EXPECTED = "http://testsite.local/rest/loginPage/welcome.php";

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

        System.out.println(driver.getCurrentUrl());
        assertEquals(URL_EXPECTED, driver.getCurrentUrl());
    }
}