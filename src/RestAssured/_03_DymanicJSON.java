package RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class _03_DymanicJSON {

	@Test(dataProvider = "BooksData")
	public static void addBook(String isbn, String aisle) {
	
		RestAssured.baseURI = "http://216.10.245.166";
		
		String respone = given().log().all()
							    .header("Content-Type", "application/json")
							    .body(Payload.dynamicJSON(isbn, aisle))
						 .when().post("Library/Addbook.php")
						 .then().log().all()
							    .assertThat().statusCode(200)
							    .extract().response().asString();
		
		JsonPath json = new JsonPath(respone);
		String id = json.get("ID");
		
		System.out.println("RESULT:" + id);
		
		
	}
	
	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		
		return new Object[][] {{"12ww3","gt23"}, {"fdg3","5vw2"}, {"ki87","uhdsaf"}};
		
	}

}
