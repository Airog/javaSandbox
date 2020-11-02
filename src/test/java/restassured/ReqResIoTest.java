package restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    @Test
    public void getMapFromResp() {
        Response response = when().get("https://reqres.in/api/unknown").then().extract().response();
        //get the list of values from json
        var list = response.jsonPath().getMap("ad");
        //using printf :)
        list.forEach((x, y) -> System.out.printf("key: %s, val: %s%n", x, y));
//        list.forEach((x, y) -> System.out.println("key: " + x + ", val: " + y));
    }

    @Test
    public void jsonFromFileFully() throws IOException {
        URL url = getClass().getClassLoader().getResource("reqres_registr.json");
        assert url != null;

        // This is the way to read full file, it works since java 11
        String content = Files.readString(Paths.get(url.getPath()), StandardCharsets.UTF_8);

        // This is another way to read the file
//        List<String> lines = files.Files.readAllLines(Paths.get(url.getPath()), StandardCharsets.UTF_8);
//        lines.forEach(System.out::println);

        given()
                .contentType(ContentType.JSON)
                .body(content)
                .when().post("https://reqres.in/api/register")
                .then().statusCode(200)
                .body("id", equalTo(4));

    }

    @Test
    public void jsonFromFilePartially() throws IOException {
        URL url = getClass().getClassLoader().getResource("reqres_registr.json");
        assert url != null;

        // This is the way to read full file, it works since java 11
        String content = Files.readString(Paths.get(url.getPath()), StandardCharsets.UTF_8);

        // This is another way to read the file
//        List<String> lines = files.Files.readAllLines(Paths.get(url.getPath()), StandardCharsets.UTF_8);
//        lines.forEach(System.out::println);

        given()
                .contentType(ContentType.JSON)
                .body(content)
                .when().post("https://reqres.in/api/register")
                .then().statusCode(200)
                .body("id", equalTo(4));

    }
}
