/**
 * @author hookie
 * @version 1.0
 */
package unitTests.loginPage;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Test;
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

        RestAssured.baseURI = "http://testsite.local/rest";
        //  RestAssured.port = 80;
        RestAssured.basePath = "/loginPage";
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void test_loginNamePassword() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/login.php");
        objLogin.loginSetNamePassword("test1", "123456");

    }
}