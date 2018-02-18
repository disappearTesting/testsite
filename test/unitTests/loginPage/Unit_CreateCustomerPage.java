package unitTests.loginPage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.CreateCustomerPage;

import java.util.Arrays;
import java.util.List;

public class Unit_CreateCustomerPage {

    private static final String URL_CREATE_PAGE = "http://testsite.local/rest/postPage/create.php";
    private static final String URL_INDEX_PAGE = "http://testsite.local/rest/postPage/index.php";

    private static final List<String> TEXT_ERROR_EMPTY = Arrays.asList("Please enter Name", "Please enter Email Address", "Please enter Mobile Number");
    private static final List<String> TEXT_ERROR_VALIDATE_VALUE = Arrays.asList("Please enter a valid Email Address", "Please enter a valid Mobile Number");

    private WebDriver driver;
    private CreateCustomerPage objCreate;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objCreate = new CreateCustomerPage(driver);
        driver.get(URL_CREATE_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_CreateGetNameEmailMobile() {
        objCreate.createSetNameEmailMobile("John", "john@example.com", "+380991112233");

        new WebDriverWait(driver,5).until(ExpectedConditions.urlContains(URL_INDEX_PAGE));

        Assert.assertTrue(driver.getCurrentUrl().equals(URL_INDEX_PAGE));
    }
}
