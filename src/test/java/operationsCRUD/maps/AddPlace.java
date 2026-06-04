package operationsCRUD.maps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonResources.Payloads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPlace {

    static String placeId;
    static void main(String[] args) throws IOException {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().header("Content-Type","application/json").queryParam("key","qaclick123")
                .body(new String(Files.readAllBytes(Paths.get("/Users/suryav/eclipse-workspace/APIBurshUp2026/src/test/java/jsonResources/AddPlaceRequest.json"))))
                .when().post("maps/api/place/add/json")
                .then().log().all().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();

        //new String(Files.readAllBytes(Paths.get("/Users/suryav/eclipse-workspace/APIBurshUp2026/src/test/java/jsonResources/AddPlaceRequest.json")))
    }
}
