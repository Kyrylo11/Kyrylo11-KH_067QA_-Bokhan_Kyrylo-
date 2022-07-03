package Task6;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


public class ApiTest {

    @Test
    public void testGetNotExistUser(){
        Response response = given().baseUri("https://reqres.in/api/")
                .when().get("users/-1");
        response.then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testGetListOfUsers(){
        String validationSchemePath = "src/test/resources/Scheme/validationSchemeForTestGetListOfUsers.json";
        Response response = given().baseUri("https://reqres.in/api/")
                .when().get("users?page=1");
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat().body(matchesJsonSchema(new File(validationSchemePath)));
    }

    @Test
    public void testGetListOfResources(){
        String validationSchemePath = "src/test/resources/Scheme/validationSchemeForTestGetListOfResources.json";
        Response response = given().baseUri("https://reqres.in/api/")
                .when().get("unknown");
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat().body(matchesJsonSchema(new File(validationSchemePath)));
    }

    @Test
    public void testPostRegister(){
        String validationSchemePath = "src/test/resources/Scheme/validationScheme.json";
        String baseUri = "https://reqres.in/api/";
        String registerBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        Response response = given()
                .baseUri(baseUri)
                .body(registerBody)
                .header("Content-type", "application/json")
                .log().all()
                .post("register");

        response.then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .assertThat().body(matchesJsonSchema(new File(validationSchemePath)));
    }
}
