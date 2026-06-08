package operationsCRUD.maps;

import POJO.maps.Location;
import POJO.maps.Place;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonResources.Payloads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPlace {

    static String placeId;
    static void main(String[] args) throws IOException {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        Place place = getPlace();

        String response = given().log().all().header("Content-Type","application/json").queryParam("key","qaclick123")
                //.body(new String(Files.readAllBytes(Paths.get("/Users/suryav/eclipse-workspace/APIBurshUp2026/src/test/java/jsonResources/AddPlaceRequest.json"))))
                .body(place)
                .when().post("maps/api/place/add/json")
                .then().log().all().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();

        //new String(Files.readAllBytes(Paths.get("/Users/suryav/eclipse-workspace/APIBurshUp2026/src/test/java/jsonResources/AddPlaceRequest.json")))
    }

    private static Place getPlace() {
        Location location = new Location();
        location.setLat(-48.383494);
        location.setLng(43.427362);
        
        Place place = new Place();
        place.setLocation(location);
        place.setAccuracy(90);
        place.setName("My Home");
        place.setPhone_number("9890909890");
        place.setAddress("11, Main street, Chennai 01");
        List<String> type = new ArrayList<>();
        type.add("abc");
        type.add("def");
        place.setTypes(type);
        place.setWebsite("www.mysite.com");
        place.setLanguage("Tamil");
        return place;
    }
}
