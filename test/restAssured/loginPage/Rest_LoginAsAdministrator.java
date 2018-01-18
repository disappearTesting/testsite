/**
 * @author hookie
 * @version 1.0
 */
package restAssured.loginPage;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.FormAuthConfig;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static com.jayway.restassured.RestAssured.given;

public class Rest_LoginAsAdministrator {

    @Before
    public void setup() {
        RestAssured.baseURI = "http://testsite.local/rest";
        //  RestAssured.port = 80;
        RestAssured.basePath = "/loginPage";
        //  RestAssured.authentication = basic("username", "password");
    }

    @Test
    public void test_LoginAsAdministrator() throws Exception {
        given().
                auth().form("test1", "123456", FormAuthConfig.springSecurity()).
        expect().
                statusCode(200).
                //  body(equalTo("OK")).
        when().
                get("welcome.php");
    }
}
