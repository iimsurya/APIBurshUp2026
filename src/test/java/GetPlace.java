import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetPlace {

    static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        given().log().all().queryParam("key", "qaclick123").queryParam("place_id","11fd8951a03b5badec3e3f35e9a4148c")
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200);
    }
}
