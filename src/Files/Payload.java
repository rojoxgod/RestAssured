package Files;

public class Payload {
	
	public static String addPlace(){
		
		return "{\r\n"
		   		+ "  \"location\": {\r\n"
		   		+ "    \"lat\": -38.383494,\r\n"
		   		+ "    \"lng\": 33.427362\r\n"
		   		+ "  },\r\n"
		   		+ "  \"accuracy\": 50,\r\n"
		   		+ "  \"name\": \"ABC Company\",\r\n"
		   		+ "  \"phone_number\": \"(+91) 322 322 3222\",\r\n"
		   		+ "  \"address\": \"32, side layout, cohen 32\",\r\n"
		   		+ "  \"types\": [\r\n"
		   		+ "    \"software house\",\r\n"
		   		+ "    \"head office\"\r\n"
		   		+ "  ],\r\n"
		   		+ "  \"website\": \"http://google.com\",\r\n"
		   		+ "  \"language\": \"French-IN\"\r\n"
		   		+ "}";
		
	}
	
	public static String complexJSON(){
			
			return "{\r\n"
					+ "  \"dashboard\": {\r\n"
					+ "    \"purchaseAmount\": 910,\r\n"
					+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
					+ "  },\r\n"
					+ "  \"courses\": [\r\n"
					+ "    {\r\n"
					+ "      \"title\": \"Selenium Python\",\r\n"
					+ "      \"price\": 50,\r\n"
					+ "      \"copies\": 6\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"title\": \"Cypress\",\r\n"
					+ "      \"price\": 40,\r\n"
					+ "      \"copies\": 4\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"title\": \"RPA\",\r\n"
					+ "      \"price\": 45,\r\n"
					+ "      \"copies\": 10\r\n"
					+ "    }\r\n"
					+ "  ]\r\n"
					+ "}";
		
	}

}
