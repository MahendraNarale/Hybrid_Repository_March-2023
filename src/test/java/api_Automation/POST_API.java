package api_Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_API {
	@Test
	public static void Post_call()
	{
		
		RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json= new JSONObject();
		json.put("id","30");
		json.put("auther","Mahendra");
		json.put("title", "Selenium Webdriver");
		
		request.body(json.toJSONString());
		
		Response response=request.post("http://localhost:3000/posts");
		
		int code=response.getStatusCode();
		System.out.println("response code"+code);
		
		Assert.assertEquals(code, 201);	
		
	}
	
}
