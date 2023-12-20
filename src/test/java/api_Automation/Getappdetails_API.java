package api_Automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getappdetails_API {
    @Test
	public static void test1()
	{
	RequestSpecification spec=RestAssured.given();
	
	spec.headers("X-RequestId", "261455c2-3561-4edf-944b-753a31acce3d");
	spec.header("x-initiator", "317588");
	spec.header("Content-Type","application/json");
	
	JSONObject json= new JSONObject();
	json.put("phoneNumber", "6071031001");
	json.put("summaryLevel", "3");
		
	spec.body(json.toJSONString());
	
	Response res=spec.post("https://checkout.axio.dev/v2/cf/checkout/user/appdetails");
	
	System.out.println("status code"+res.getStatusCode());
	System.out.println(res.getBody().jsonPath().prettify());
}

}
