package unitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.HomePage;
import pom.Login;

import static org.junit.Assert.assertTrue;

public class Unit_Login {

    private static final String URL_LOGIN_PAGE = "http://testsite.local/rest/loginPage/login.php";

    private WebDriver driver;
    private Login objLogin;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objLogin = new Login(driver);
        driver.get(URL_LOGIN_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_Login_CorrectCredentials() {
        objLogin.enterUserEmail("makarov@smartproject.ua");
        objLogin.enterUserPassword("123456");
        HomePage objHome = objLogin.submitLoginCredentials();
        assertTrue(objHome.checkLoginSuccess("makarov@smartproject.ua"));
    }
}
