package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {
    String baseURL = "https://petstore.swagger.io/v2/pet";
    @Test(priority=1)
    public void postRequest(){
        String reqBody = "{"
                + "\"id\": 77232,"
                + "\"name\": \"Riley\","
                + " \"status\": \"alive\""
                + "}";
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody) // Add request body
                        .when().post(baseURL); // Send POST request

        // Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }
    @Test(priority=2)
    public void getRequest(){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .get(baseURL + "/{petId}"); // Send GET request

        // Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }
    @Test(priority=3)
    public void deleteRequest(){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .delete(baseURL + "/{petId}"); // Send DELETE request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77232"));
    }
}
