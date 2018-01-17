package restAssured; /**
 * @author hookie
 * @version 1.0
 */
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Test;

public class Test_SimpleRestAssured {

    private static final String URL = "http://testsite.local/loginPage  ";

    @Test
    public void simpleRestAssured() {

        //the base URL to the RESTful web service
        RestAssured.baseURI = URL;

        // Get the RequestSpecification of the request to sent to the server.
        // The server is specified by the BaseURI
        RequestSpecification myRequest = RestAssured.given();

        Response myResponse = myRequest.request().get("/login.php");

        // Print the body of the response
        String responseBody = myResponse.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
    }
}
