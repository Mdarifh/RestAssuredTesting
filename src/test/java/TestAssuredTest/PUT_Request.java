package TestAssuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class PUT_Request {

	public static HashMap map = new HashMap();
	
	String empName = RestUtils.empName();
	String empSalary  = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	int emp_id = 1;
	
	
	
	@BeforeClass
	
	public void putData() {
		map.put("name","empName");
		map.put("salary","empSalary");
		map.put("age","emmAge");
		
		RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/update/"+emp_id;
	}
	
	@Test
	public void testPut() {
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
	}
}
