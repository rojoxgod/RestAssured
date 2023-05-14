package RestAssured;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class _02_ComplexJSON {

	public static void main(String[] args) {
		
		
		JsonPath json = new JsonPath(Payload.complexJSON());
		
		int size = json.getInt("courses.size()");
		System.out.println(size);
		
		int totalValue = json.getInt("dashboard.purchaseAmount");
		System.out.println(totalValue);

		String firstTitle = json.getString("courses.title[0]");
		System.out.println(firstTitle);
		
		
		String[] titles = new String[size];
		for(int i = 0; i < size; i++) {
			
			titles[i] = json.getString("courses.title["+ i +"]");
			
			System.out.println(titles[i]);
			
			System.out.println("Price is: " + json.getInt("courses.price["+ i +"]"));
			
		}
		
		
		int count = 0;
		for(int i = 0; i < size; i++) {

			if(json.getString("courses.title["+ i +"]").contains("RPA")) {
				count++;
			}
		}
		System.out.println(count);
		
		int total = 0;
		for(int i = 0; i < size; i++) {
					
			total += json.getInt("courses.price["+ i +"]") * json.getInt("courses.copies["+ i +"]");
			
		}
		System.out.println(total);
		
	}

}
	