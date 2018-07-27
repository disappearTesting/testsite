package unitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.GetCookies;
import pom.Login;

import java.io.IOException;
import java.text.ParseException;

public class Unit_Login_UseCookies {

    private static final String URL_LIGHTSHOT_PAGE = "https://prntscr.com/gallery.html";
    private static final String COOKIE_PATH_LIGHTSHOT = "C:\\Users\\hookie\\IdeaProjects\\testsite\\rest\\loginPage\\folderToCookiesFile\\";
    private static final String COOKIE_FILENAME_LIGHTSHOT = "LightShot.Cookies.data";

    private WebDriver driver;
    private Login objLogin;
    private GetCookies objCookies;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objLogin = new Login(driver);
        objCookies = new GetCookies(driver, COOKIE_PATH_LIGHTSHOT + COOKIE_FILENAME_LIGHTSHOT);
        driver.get(URL_LIGHTSHOT_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_LoginTo_UseCookies_LightShot() throws IOException, ParseException {
        driver.get(URL_LIGHTSHOT_PAGE);
        driver.manage().deleteAllCookies();
        objCookies.addCookies();
        driver.get(URL_LIGHTSHOT_PAGE);
    }
}
