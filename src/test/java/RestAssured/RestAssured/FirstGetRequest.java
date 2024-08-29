package RestAssured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

  

public class FirstGetRequest {
	
	@Test
	public void testcase01(){
	Response res = get("https://reqres.in/api/users?page=2");
	
	System.out.println("Status code: "+ res.getStatusCode());
	System.err.println("Response Body: "+ res.getBody().asPrettyString());
	System.out.println("Response Time: "+ res.getTime());
	System.out.println("Response Header: "+ res.header("Content-Type"));
	
	// Validate Status Code
	int ExpectedStatusCode = 200;
	int ActaulStatusCode = res.getStatusCode();
	Assert.assertEquals(ExpectedStatusCode, ActaulStatusCode);
	
	}
	
	@Test
	public void Gettestcase02() {
		
		baseURI = "https://reqres.in/api/users";
		given()
		.queryParam("page", "2")
		.when().get()
		.then().statusCode(200);	
	}
	
	@Test
	public void Posttestcase03() {
		
		JSONObject json = new JSONObject();
		json.put("Name", "Md Arif Hussain");
		json.put("Age", "25");
		json.put("Email", "mdarifhussain887@gmail.com");
		json.put("Phone", "7061457677");
		json.put("Job", "QA Tester");
		
		baseURI = "https://reqres.in/api/users";
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(json.toJSONString())
		.when().post()
		.then().statusCode(201)
		.log().all();
	}
	
	@Test
	public void Puttestcase04() {
		JSONObject json = new JSONObject();
		json.put("Name", "Zoya arif Hussain");
		json.put("Age", "20");
		json.put("Email", "zoyahussain007@gmail.com");
		json.put("Phone", "9061457600");
		json.put("Job", " Backend Developer");
		
		baseURI = "https://reqres.in/api/users/519";
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(json.toJSONString())
		.when().put()
		.then().statusCode(200)
		.log().all();
	}
	
	
	@Test
	public void Patchtestcase05() {
		JSONObject json = new JSONObject();
		json.put("Name", "Zoya arif Hussain");
		json.put("Age", "21");
		json.put("Email", "zoyahussain007@gmail.com");
		json.put("Phone", "9061457600");
		json.put("Job", " Automation Tester");
		
		baseURI = "https://reqres.in/api/users/519";
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(json.toJSONString())
		.when().patch()
		.then().statusCode(200)
		.log().all();
	}
	
	@Test
	public void Deletetestcase06() {
		
		baseURI = "https://reqres.in/api/users/519";
		given()
		.when().delete()
		.then().statusCode(204)
		.log().all();
	}
	
}
