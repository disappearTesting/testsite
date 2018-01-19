package unitTests.loginPage;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.PomLogin;

public class Unit_LoginAsAdministrator {

    WebDriver driver;
    PomLogin objLogin;

    @Before
    public void before() {
        driver = new FirefoxDriver();
        objLogin = new PomLogin(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

//    @Test
//    public void test_loginNamePassword() {
//        objLogin.loginEmailPassword("test1", "test1");
//        assertEquals();
//    }
}
