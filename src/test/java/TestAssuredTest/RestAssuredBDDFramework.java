package TestAssuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class RestAssuredBDDFramework {

	@Test
	public void getweatherdetails() {
		
		given()
			
			.when()
				.get("http://demoqa.com/utilities/weather/city/Hyderabad")
				
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("City", equalTo("Hyderabad"))
				.header("X-Powered-By", "Express")
				.header("Connection", "keep-alive");
	}
}
