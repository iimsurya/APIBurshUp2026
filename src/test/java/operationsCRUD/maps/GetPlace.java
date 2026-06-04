package operationsCRUD.maps;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetPlace {

    static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        given().log().all().queryParam("key", "qaclick123").queryParam("place_id", AddPlace.placeId)
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200);
    }
}
