package RestAssured;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;

import POJO_serialization.AddPlace;
import POJO_serialization.Location;
import io.restassured.RestAssured;


public class _05_SerializationGoogleMapsAPI {
	
	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		ArrayList<String> typesList = new ArrayList<String>(Arrays.asList("software house", "head office"));
		
		Location location = new Location();
		location.setLng(78.383494);
		location.setLat(33.427362);
		
		
		AddPlace body = new AddPlace();
		body.setLocation(location);
		body.setAccuracy(50);
		body.setName("RestAssured Company");
		body.setPhone_number("(+39) 697 678 7867");
		body.setAddress("32, via Roma, Brescia");
		body.setTypes(typesList);
		body.setWebsite("http://google.com");
		body.setLanguage("French-IN");
		
		
		
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json").body(body).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		

		 
	}
	
}
