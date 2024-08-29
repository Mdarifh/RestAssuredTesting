package ValidateHTTPResponsesCode;

import org.testng.Assert;
import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

import java.util.Iterator;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	
	@Test
	
	public void GetSingleUser() {
		
		RequestSpecification req = given();
		 req.baseUri("https://reqres.in");
		 req.basePath("/api/users/2");
		
		Response response = req.get();
		
		String ContentType = response.getHeader("Content-Type");
		System.out.println("Content-Type: "+ContentType);
		
		String con = response.getHeader("Connection");
		System.out.println("Connection: "+con);
		
		String endpoint = response.getHeader("Reporting-Endpoints");
		System.out.println("Reporting-Endpoints: "+endpoint);
		
		String via = response.getHeader("Via");
		System.out.println("Via: "+via);
		
		
		Headers headerList = response.getHeaders();
		for (Header header:headerList) {
			System.out.println( header.getName() + " : "+ header.getValue());
		}
		
		Assert.assertEquals(ContentType, "application/json; charset=utf-8", "Header Content type mix matched");
		
		Assert.assertEquals(con,"keep-alive", "Header connection is mix matched");
		
		
		Assert.assertEquals(via,"1.1 vegur", "Header Via is mix matched");
		
	}

}
