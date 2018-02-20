package unitTests.loginPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.CreateCustomerPage;
import pom.MySQLQueries_Testsite;


import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;

public class Unit_CreateCustomerPage {

    private static final String URL_CREATE_PAGE = "http://testsite.local/rest/postPage/create.php";
    private static final String URL_INDEX_PAGE = "http://testsite.local/rest/postPage/index.php";

    private static final List<String> TEXT_ERROR_EMPTY = Arrays.asList("Please enter Name", "Please enter Email Address", "Please enter Mobile Number");
    private static final List<String> TEXT_ERROR_VALIDATE_VALUE = Arrays.asList("Please enter a valid Email Address", "Please enter a valid Mobile Number");

    private static final String SQL_SELECT_FROM_WHERE = "SELECT * FROM testsite.customers WHERE name='John' AND email='john@example.com' AND mobile='+380991112233';";

    private WebDriver driver;
    private CreateCustomerPage objCreate;
    private MySQLQueries_Testsite objSQLQueries;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objCreate = new CreateCustomerPage(driver);
        objSQLQueries = new MySQLQueries_Testsite();
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

        objSQLQueries.getSQLQuery_executeQuery(SQL_SELECT_FROM_WHERE);

        assertTrue(driver.getCurrentUrl().equals(URL_INDEX_PAGE));
    }

    @Test
    public void test_CreateNullParams() {
        int i = 0;
        int eqCount = 0;

        objCreate.createSetNameEmailMobile("", "", "");

        new WebDriverWait(driver, 5).until(presenceOfAllElementsLocatedBy(objCreate.getTextError()));

        List<WebElement> elements = driver.findElements(objCreate.getTextError());

        for(WebElement element: elements) {
            if(TEXT_ERROR_EMPTY.get(i++).equals(element.getText())) {
                eqCount++;
            }
        }
        assertTrue(elements.size() == eqCount);
    }
}
