package unitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.GetCookies;
import pom.HomePage;
import pom.Login;
import pom.TestRunException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class Unit_Login {

    private static final String URL_LOGIN_PAGE = "http://testsite.local/rest/loginPage/login.php";
    private static final String COOKIE_PATH = "C:\\Users\\hookie\\IdeaProjects\\testsite\\rest\\loginPage\\folderToCookiesFile\\";
    private static final String COOKIE_FILENAME = "Login.Cookies.data";

    private WebDriver driver;
    private Login objLogin;
    private GetCookies objCookies;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objLogin = new Login(driver);
        objCookies = new GetCookies(driver, COOKIE_PATH + COOKIE_FILENAME);
        //driver.get(URL_LOGIN_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_GenerateCookieFile() throws IOException {
        objCookies.getTheCookieFile();
        assertTrue(objCookies.checkExistingCookieFile(COOKIE_PATH, COOKIE_FILENAME));
    }
    @Test
    public void test_Login_CorrectCredentials() throws IOException, InterruptedException {
        objLogin.enterUserEmail("makarov@smartproject.ua");
        objLogin.enterUserPassword("123456");
        HomePage objHome = objLogin.submitLoginCredentials();
        assertTrue(objHome.checkLoginSuccess("makarov@smartproject.ua"));
        //driver.manage().getCookies();
        Set<Cookie> cookiesList =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.println(getcookies );
        }
        objCookies.getTheCookieFile();
        assertTrue(objCookies.checkExistingCookieFile(COOKIE_PATH, COOKIE_FILENAME));
    }

    @Test
    public void test() throws InterruptedException, IOException, ParseException {
        objCookies.addCookie_Q();
    }
}