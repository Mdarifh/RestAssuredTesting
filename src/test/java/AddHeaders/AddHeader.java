package AddHeaders;


import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeader {

	@Test
	
	public void testMethod() {
		// 1st Method
		
		Map<String, String> requestHeader = new HashMap<>();
		
		requestHeader.put("Header1", "Value1");
		requestHeader.put("Header2", "Value2");
		requestHeader.put("Header3", "Value3");
		
		
		// Add Multiple Headers
		Header header1 = new Header("Header4", "Value4");
		Header header2 = new Header("Header5", "Value5");
		Header header3 = new Header("Header6", "Value6");
		
		List<Header> HeaderList = new ArrayList<Header>();
		
		HeaderList.add(header1);
		HeaderList.add(header2);
		HeaderList.add(header3);
		
		Headers headerObj = new Headers(HeaderList);
		
		// 2nd Method
		Header header  = new Header("Header7","Value7");
		
		/*RequestSpecification requestspeci = given();
		
		// Add Single Header
		// 3rd Method
		
		requestspeci.header("Header8", "Value8");
		
		
		requestspeci.headers(headerObj);
		requestspeci.headers(requestHeader);
		requestspeci.header(header);
		requestspeci.log().headers();
		requestspeci.baseUri("https://reqres.in");
		requestspeci.basePath("/api/users?page=1");
		
		// Perform get request
		Response response = requestspeci.get();

		Assert.assertEquals(response.statusCode(), 200 );*/
		
		RestAssured.given()
			.headers(headerObj)
			.log().headers()
		
		.when()
			.get("https://reqres.in/api/users?page=1")
		
		.then()
			.log().body();

	}
}
