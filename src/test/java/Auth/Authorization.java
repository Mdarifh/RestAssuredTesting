package Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {

	@Test
	
	public void Author() {
		RequestSpecification RequestSpc = given();
		RequestSpc.baseUri("https://postman-echo.com");
		RequestSpc.basePath("/basic-auth");
		
		Response respone = RequestSpc.auth().preemptive().basic("postman", "password").get();
		Assert.assertEquals(respone.statusCode(), 200, "Check for Status Code");
		System.out.println("Response Staus: "+respone.statusLine());
		System.out.println("Response Body: "+respone.body().asPrettyString());
	}
	
	@Test
	public void DigestAuth() {
		RequestSpecification RequestSpc = given();
		RequestSpc.baseUri("https://httpbin.org");
		RequestSpc.basePath("/digest-auth/undefined/Arif123/arif123");
		
		Response response = RequestSpc.auth().digest("Arif123", "arif123").get();
		Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");
		System.out.println("Digest Auth Response Staus: "+response.statusLine());
		System.out.println("Digest Auth Response Body: "+response.body().asPrettyString());
	}
}
