package RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class _01_Basics {

	public static String placeID = "";
	
	public static void main(String[] args) throws IOException {
		
		addPlace();
		
		//addPlaceFromFileJSON();

		updatePlace();
		
		getPlace();
		
		
	}
	
	public static void addPlace() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given().log().all()
							    .queryParam("key", "qaclick123")
							    .header("Content-Type", "application/json")
							    .body(Payload.addPlace())
						 .when().post("maps/api/place/add/json")
						 .then().log().all()
							    .assertThat().statusCode(200)
										     .body("scope", equalTo("APP"))
										     .header("server", "Apache/2.4.41 (Ubuntu)")
							    .extract().response().asString();
						
		System.out.println(response);
		
		JsonPath json = new JsonPath(response);
		placeID = json.getString("place_id");
		
		System.out.println(placeID);
		
	}
	
	public static void addPlaceFromFileJSON() throws IOException {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given().log().all()
							    .queryParam("key", "qaclick123")
							    .header("Content-Type", "application/json")
							    .body(new String(Files.readAllBytes(Paths.get("E:\\SeleniumProjects\\addPlace.json"))))
						 .when().post("maps/api/place/add/json")
						 .then().log().all()
							    .assertThat().statusCode(200)
										     .body("scope", equalTo("APP"))
										     .header("server", "Apache/2.4.41 (Ubuntu)")
							    .extract().response().asString();
						
		System.out.println(response);
		
		JsonPath json = new JsonPath(response);
		placeID = json.getString("place_id");
		
		System.out.println("RESULT:" + placeID);
		
	}
	
	public static void updatePlace() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all()
			   .queryParam("key", "qaclick123")
			   .header("Content-Type", "application/json")
			   .body("{\r\n"
						+ "		\"place_id\":\"" + placeID + "\",\r\n"
						+ "		\"address\":\"70 winter walk, USA\",\r\n"
						+ "		\"key\":\"qaclick123\"\r\n"
						+ "		}")
		.when().put("maps/api/place/update/json")
		.then().log().all()
			   .assertThat().statusCode(200)
			   				.body("msg", equalTo("Address successfully updated"));
		
	}
	
	public static void getPlace() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all()
			   .queryParam("key", "qaclick123").queryParam("place_id", placeID)
			   .header("Content-Type", "application/json")
		.when().get("maps/api/place/get/json")
		.then().log().all()
			   .assertThat().statusCode(200)
			   				.body("address", equalTo("70 winter walk, USA"));
		
	}
	

}
