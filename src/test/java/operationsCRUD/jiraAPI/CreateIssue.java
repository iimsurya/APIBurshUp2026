package operationsCRUD.jiraAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonResources.Payloads;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateIssue {

    static void main(String[] args) {

        RestAssured.baseURI = "https://projectsurya-june26.atlassian.net";

        //Create JIRA Issue
        String response = given().header("Content-Type","application/json").header("Authorization", "Basic c3VyeWF2azQyQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBDdnlNUGJXUFA1Q0pYVjNGUk93ckJKY1QzNS1XRFJ4Y2RlNll1ckd6T2M2aTZJUEZWZHNETjRybW5rWTR4U3lZX3lFYmtfTVJYTDM3RTEzWmdUVHJYTlU0TzgzSGh4QjIyckp5WDF1VXlnSkZ5ZWNuczJNcXNhMmllN0UxU0hrdVZxTzJjSjFnQ3d0VWJuUmg2V2dVOEJxbjQ3Rm1uRzN0bWxKVjVFSy1EZEU9MjZCNTg1NkY")
                .body(Payloads.createIssue())
                .when().post("rest/api/3/issue")
                .then().assertThat().statusCode(201).extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        String jiraID = jsonPath.get("id");

        //Add Attachment to Defect
        given().header("X-Atlassian-Token","no-check").header("Authorization","Basic c3VyeWF2azQyQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBDdnlNUGJXUFA1Q0pYVjNGUk93ckJKY1QzNS1XRFJ4Y2RlNll1ckd6T2M2aTZJUEZWZHNETjRybW5rWTR4U3lZX3lFYmtfTVJYTDM3RTEzWmdUVHJYTlU0TzgzSGh4QjIyckp5WDF1VXlnSkZ5ZWNuczJNcXNhMmllN0UxU0hrdVZxTzJjSjFnQ3d0VWJuUmg2V2dVOEJxbjQ3Rm1uRzN0bWxKVjVFSy1EZEU9MjZCNTg1NkY")
                .pathParam("issueKey",jiraID)
                .multiPart("file", new File("/Users/suryav/eclipse-workspace/APIBurshUp2026/src/test/java/operationsCRUD/jiraAPI/Screenshot 2026-06-04 at 6.17.04 PM.png"))
                .when().post("rest/api/3/issue/{issueKey}/attachments")
                .then().assertThat().statusCode(200);
    }
}
