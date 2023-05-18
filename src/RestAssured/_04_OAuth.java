package RestAssured;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class _04_OAuth {

	static WebDriver driver = new ChromeDriver();
	

	
	
	@Test
	public static void OAuth() throws InterruptedException {
		//obsolete method must be performed manually because of google new policy, only the code request.
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		String url1 = url.split("code=")[1];
		String code = url1.split("&scope")[0];
		
		
		
		String access_token = given().urlEncodingEnabled(false).queryParams("code", code).queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			   .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
			   .queryParams("grant_type", "authorization_code").when().post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		System.out.println(access_token);
		
		JsonPath json = new JsonPath(access_token);
		String access_token_string = json.getString("access_token");
		
		
		
		String response = given().queryParam("access_token", access_token_string).when().get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
		
	}
	
}
