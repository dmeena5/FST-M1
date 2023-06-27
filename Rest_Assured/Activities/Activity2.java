package activities;

import au.com.dius.pact.core.support.Json;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
    String baseURL = "https://petstore.swagger.io/v2/user";
    @Test(priority = 1)
    public void postRequest() throws IOException {
        FileInputStream inputJSON = new FileInputStream("src/test/java/activities/userinfo.json");
        // Read JSON file as String
        String reqBody = new String(inputJSON.readAllBytes());
        Response response = given().contentType(ContentType.JSON).when().body(reqBody).post(baseURL);
        inputJSON.close();
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("1991"));
    }
    @Test(priority = 2)
    public void getRequest(){
        File outputJSON = new File("src/test/java/activities/userGETResponse.json");
        Response response = given().contentType(ContentType.JSON).pathParam("username", "justinc_05")
                .when().get(baseURL + "/{username}");

        String resBody = response.getBody().asPrettyString();

        try {
            // Create JSON file
            outputJSON.createNewFile();
            // Write response body to external file
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
        response.then().body("id", equalTo(1991));
        response.then().body("username", equalTo("justinc_05"));
        response.then().body("firstName", equalTo("Justin"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));
    }
    @Test(priority = 3)
    public void deleteRequest() throws IOException {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .pathParam("username", "justinc_05") // Add path parameter
                        .when().delete(baseURL + "/{username}"); // Send POST request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("justinc_05"));
    }

}
