import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class AddPlace {

    static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        given().log().all().header("Content-Type","application/json").queryParam("key","qaclick123")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Home one\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, chennai 13\",\n" +
                        "  \"types\": [\n" +
                        "    \"toe park\",\n" +
                        "    \"house\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n")
                .when().post("maps/api/place/add/json")
                .then().log().all().statusCode(200);
    }
}
