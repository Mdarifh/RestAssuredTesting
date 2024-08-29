package Auth;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {

	@Test
	public void BearerTokens() {
		RequestSpecification RequestSpc = given();
		RequestSpc.baseUri("https://gorest.co.in");
		RequestSpc.basePath("/public/v2/users");
		
		JSONObject json = new JSONObject();
		json.put("Name","Hussain");
		json.put("Age","24");
		json.put("Email","mdarif00@gmail.com");
		json.put("Phone","7061100801");
		json.put("Job","QA Tester");
		
		String AuthTken = "Bearer 146f85f7d5702b4649aa5a759763912eec832c618e08c9ddc41d857183bf554e";
		RequestSpc.headers("Authorization",AuthTken)
		.contentType(ContentType.JSON)
		.body(AuthTken.toString());
		
		Response response = RequestSpc.post();
		Assert.assertEquals(response.statusCode(), 201, "Check for Status Code");
		System.out.println("Response Staus Line: "+response.statusLine());
		System.out.println("Response Body: "+response.body().asPrettyString());
	}
}
