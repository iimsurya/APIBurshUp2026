package operationsCRUD.maps;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jsonResources.Payloads;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EndToEnd {

    static String placeId;
    static void main(String[] args) {



        RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key","qaclick123").addHeader("Content-Type","application/json").build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();


        String response = given().spec(requestSpecification)
                .body(Payloads.addPlace())
                .when().post("maps/api/place/add/json")
                .then().log().all().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        placeId = jsonPath.get("place_id");
        System.out.println("Extracted place ID: " + placeId);

        given().log().all().queryParam("key", "qaclick123").queryParam("place_id",AddPlace.placeId)
                .when().get("maps/api/place/get/json")
                .then().log().all().spec(responseSpecification);

        String newAddress = "70 Summer walk, Blr";

        given().spec(requestSpecification)
                .body("{\n" +
                        "    \"place_id\": \""+ placeId + "\",\n" +
                        "    \"address\": \""+ newAddress +"\",\n" +
                        "    \"key\": \"qaclick123\"\n" +
                        "}")
                .when().put("maps/api/place/update/json")
                .then().log().all().spec(responseSpecification);

        given().log().all().queryParam("key", "qaclick123").queryParam("place_id",AddPlace.placeId)
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).body("address",equalTo(newAddress));

    }
}
