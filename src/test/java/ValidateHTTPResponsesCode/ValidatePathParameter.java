package ValidateHTTPResponsesCode;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import  io.restassured.response.Response;


import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ValidatePathParameter {
	
	@Test
	
	public void PathPharaeter() {
		
		RequestSpecification request =  given();
		request.baseUri("https://reqres.in");
		request.basePath("/api/users");
		request.queryParam("page", "2").queryParam("id", "12");
		
		Response response  = request.get();
		
		String responseBodyString = response.getBody().asPrettyString();
		System.out.println("Response Body Request: "+responseBodyString);
		
		JsonPath jsonpathview =  response.jsonPath();
		
		String firstName = jsonpathview.get("data.first_name");
		String lastName = jsonpathview.get("data.last_name");
		
		Assert.assertEquals(firstName, "Rachel", "Check for presense  firstName of Rachel");
		
		Assert.assertEquals(lastName, "Howell", "Check for presense  firstName of Howell");
		
	}

}
