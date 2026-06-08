package operationsCRUD.EComm;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class CreateAddDelete {

    String email;
    String password;

    //RequestSpecification requestSpecification = new RequestSpecBuilder().addHeader("Authorization",)

    public void getCredentials(){

        JsonPath jsonPath = new JsonPath(new File("/Users/suryav/eclipse-workspace/APIBurshUp2026/src/test/java/jsonResources/eCOmmCreds.json"));
        email = jsonPath.get("userEmail");
        password = jsonPath.get("password");

        System.out.println(email + " " + password);
    }

    public void postLogin(){

        RestAssured.baseURI = "";
    }
    static void main(String[] args) {

    }


}
