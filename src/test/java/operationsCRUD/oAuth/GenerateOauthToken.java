package operationsCRUD.oAuth;

import POJO.courses.CoursesList;
import POJO.courses.WebAutomation;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GenerateOauthToken {

    static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParams("grant_type","client_credentials")
                .formParams("scope","trust")
                .when().post("oauthapi/oauth2/resourceOwner/token")
                .then().statusCode(200).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        String access_token = jsonPath.get("access_token");

        CoursesList coursesList = given().queryParam("access_token",access_token)
                .when().get("oauthapi/getCourseDetails")
                .then().statusCode(401).extract().response().as(CoursesList.class);

        System.out.println(coursesList.getUrl());
        System.out.println(coursesList.getCourses().getWebAutomation().get(1).getCourseTitle());

        List<WebAutomation> webAutomations = coursesList.getCourses().getWebAutomation();
        for (int i = 0; i < webAutomations.size(); i++) {
            String courseTitle = webAutomations.get(i).getCourseTitle();
            System.out.println(i +" : " +courseTitle);
        }
    }
}
