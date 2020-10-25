package restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqResIoTest {

    /*
    * TODO:
    *  Add authentication
    *  Add cookie getter
    *  */

    @Test
    public void getSingleUser() {
        given()
                .when().get("https://reqres.in/api/users/2")
                .then().assertThat()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

    @Test
    public void postNewUserCreate() {
        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post("https://reqres.in/api/users")
                .then().statusCode(201)
                .body("name", equalTo("morpheus"));
    }

    @Test
    public void getListWithResources() {
        Response response = when().get("https://reqres.in/api/unknown").then().extract().response();
        List<String> list = Arrays.asList(response.jsonPath().getString("data.id").split(","));
        list.stream().forEach(System.out::println);
        //get the list of values from json
        list = response.jsonPath().getList("data.name");
        list.forEach(System.out::println);
    }
}
