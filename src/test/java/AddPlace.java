import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonResources.Payloads;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPlace {

    static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().header("Content-Type","application/json").queryParam("key","qaclick123")
                .body(Payloads.addPlace())
                .when().post("maps/api/place/add/json")
                .then().log().all().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        String placeId = jsonPath.get("place_id");
        System.out.println("Extracted place ID: " + placeId);

    }
}
