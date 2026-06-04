package operationsCRUD.maps;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeletePlace {

    static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "    \"place_id\":\"09110a20bd14f6840511ce040ae984f1\"\n" +
                        "}")
                .when().delete("maps/api/place/delete/json")
                .then().log().all().assertThat().statusCode(200);
    }
}
