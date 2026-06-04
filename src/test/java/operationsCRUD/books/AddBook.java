package operationsCRUD.books;

import io.restassured.RestAssured;
import jsonResources.Payloads;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddBook {

  @Test (dataProvider = "booksDataToAdd")
    public void addBookToDatabase(String isbn, String aisle){

      RestAssured.baseURI = "http://216.10.245.166";

      given().log().all().header("Content-Type","application/json").body(Payloads.addBookPayload(isbn,aisle))
              .when().post("Library/Addbook.php")
              .then().log().all().assertThat().statusCode(200).body("Msg",equalTo("successfully added"));
  }

  @DataProvider (name = "booksDataToAdd")
  public Object[][] addBookData(){

    return new Object[][] {{"qwqq","12311"},{"iwioo","09101"},{"llaoo","88921"}};
  }
}
