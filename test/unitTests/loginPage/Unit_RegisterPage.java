package unitTests.loginPage;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.RegisterPage;

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

    public void test_RegisterSetNamePassword() {

    }
}
