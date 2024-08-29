package ValidateHTTPResponsesCode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJSONBody {
	
	@Test
	
	public void ValidateJsonBody() {
		RequestSpecification request =given();
		request.baseUri("https://reqres.in");
		request.basePath("/api/users?page=2");
		
		Response response = request.get();	
		
		ResponseBody resBody = response.getBody();
		
		String responseString = resBody.asPrettyString();
		
		System.out.println("Response Body: "+responseString);
		
		Assert.assertEquals(responseString.contains("George"),true , "Check for presense of George");
		
		Assert.assertEquals(responseString.contains("https://reqres.in/img/faces/6-image.jpg"),true , "Check for presense of Tracey");
		
		Assert.assertEquals(responseString.contains("charles.morris@reqres.in"),true , "Check for presense of email");
		
		Assert.assertEquals(responseString.contains("6"),true , "Check for presense of Ramos");
		
		JsonPath jsonpathview = resBody.jsonPath();
		
		String firstName = jsonpathview.get("data[5].first_name");
		
		Assert.assertEquals(firstName,"Tracey", "Check for presense of firstname as Tracey");
		
		String email = jsonpathview.get("data[4].email");
		
		Assert.assertEquals(email,"charles.morris@reqres.in", "Check for presense of email as charles.morris@reqres.in");
		
		String avatar = jsonpathview.get("data[0].avatar");
		
		Assert.assertEquals(avatar,"https://reqres.in/img/faces/1-image.jpg", "Check for presense of avatar as https://reqres.in/img/faces/1-image.jpg");
		
		String lastName = jsonpathview.get("data[3].last_name");
		
		Assert.assertEquals(lastName,"Holt", "Check for presense of lastName as Holt");
		
		
	}

}
