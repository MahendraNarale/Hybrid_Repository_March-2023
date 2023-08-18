package api_Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API {
    @Test
	public static void testgetAPI()
	{
		Response resp=RestAssured.get("https://vpic.nhtsa.dot.gov/api/");
		int code=resp.getStatusCode();
		System.out.println("Response code is"+ code);
		Assert.assertEquals(code, 200);
	}
    @Test
    public static void testresponse()
    {
    	Response resp=RestAssured.get("https://vpic.nhtsa.dot.gov/api/");
    	String str=resp.asString();
    	System.out.println("Response id"+ str);
    	
    }
}
