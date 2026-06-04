package jsonPharseExe;

import io.restassured.path.json.JsonPath;
import jsonResources.Payloads;
import org.testng.Assert;

public class coursesAPI {

    static void main(String[] args) {

        JsonPath jsonPath = new JsonPath(Payloads.coursesPrice());

        //1. Print No of courses returned by API
        System.out.println(jsonPath.get("courses.size()").toString());

        //2.Print Purchase Amount
        System.out.println(jsonPath.get("dashboard.purchaseAmount").toString());

        //3. Print Title of the first course
        System.out.println(jsonPath.get("courses[0].title").toString());

        //4. Print All course titles and their respective Prices
        for (int i = 0; i < jsonPath.getInt("courses.size()"); i++) {
            System.out.println(jsonPath.get("courses["+i+"].title").toString());
        }
        //5. Print no of copies sold by RPA Course
        for (int i = 0; i < jsonPath.getInt("courses.size()"); i++) {
            if(jsonPath.get("courses["+i+"].title").toString().equals("RPA")){
                System.out.println(jsonPath.get("courses["+i+"].copies").toString());
                break;
            }
        }

        //6. Verify if Sum of all Course prices matches with Purchase Amount
        int actualSum = 0;
        for (int i = 0; i < jsonPath.getInt("courses.size()"); i++) {

            int courseTotalPrice = jsonPath.getInt("courses[" + i + "].price") * jsonPath.getInt("courses[" + i + "].copies");
            actualSum = actualSum + courseTotalPrice;
        }

        int expectedSum = jsonPath.getInt("dashboard.purchaseAmount");

        Assert.assertEquals(actualSum,expectedSum);
    }
}
