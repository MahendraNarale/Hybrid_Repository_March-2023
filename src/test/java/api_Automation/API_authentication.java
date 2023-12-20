package api_Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_authentication {
	@Test
	public static void test1()
	{
		
		Response resp=RestAssured.given().auth().oauth2("pass token here").post("pass the URL here");
		System.out.println("Status code"+resp.getStatusCode());
		String str=resp.getBody().asString();
		System.out.println("Response body"+str);
	}

}
