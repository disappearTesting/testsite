/**
 * @author hookie
 * @version 1.0
 */
package restAssured;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.PomLogin;

public class Test_LoginAsAdministrator {

    private static String URL_LOGIN_PAGE = "http://testsite.local/loginPage/login.php";

    WebDriver driver;
    PomLogin objLogin;

    @Before
    public void before() {
        driver = new FirefoxDriver();
        driver.get(URL_LOGIN_PAGE);
        objLogin = new PomLogin(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void test_loginNamePassword() {
        objLogin.loginEmailPassword("test1", "test1");
        assertEquals();
    }
}