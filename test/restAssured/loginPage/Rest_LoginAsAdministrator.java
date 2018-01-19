/**
 * @author hookie
 * @version 1.0
 */
package restAssured.loginPage;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.FormAuthConfig;
import org.junit.Before;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;

public class Rest_LoginAsAdministrator {

    @Before
    public void before() {
        RestAssured.baseURI = "http://testsite.local/rest";
        //  RestAssured.port = 80;
        RestAssured.basePath = "/loginPage";
        //  RestAssured.authentication = basic("username", "password");
    }

    @Test
    public void test_LoginAsAdministrator() throws Exception {

        given().log().all().
                auth().
                form("test1", "123456", new FormAuthConfig("/rest/loginPage/login.php", "username", "password")).
        when().
                get("/login.php").
        then().
                statusCode(200);
    }
}
