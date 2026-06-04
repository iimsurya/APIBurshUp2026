package operationsCRUD.maps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonResources.Payloads;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EndToEnd {

    static String placeId;
    static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().header("Content-Type","application/json").queryParam("key","qaclick123")
                .body(Payloads.addPlace())
                .when().post("maps/api/place/add/json")
                .then().log().all().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        placeId = jsonPath.get("place_id");
        System.out.println("Extracted place ID: " + placeId);

        given().log().all().queryParam("key", "qaclick123").queryParam("place_id",AddPlace.placeId)
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200);

        String newAddress = "70 Summer walk, Blr";

        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "    \"place_id\": \""+ placeId + "\",\n" +
                        "    \"address\": \""+ newAddress +"\",\n" +
                        "    \"key\": \"qaclick123\"\n" +
                        "}")
                .when().put("maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200);

        given().log().all().queryParam("key", "qaclick123").queryParam("place_id",AddPlace.placeId)
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).body("address",equalTo(newAddress));

    }
}
