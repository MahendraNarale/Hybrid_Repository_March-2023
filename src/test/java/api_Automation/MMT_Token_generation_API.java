package api_Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MMT_Token_generation_API {
	@Test
	public static void MMT_Token()
	{
		
		Response res=RestAssured.get("https://api.axio.dev/servev3/usrmgmt/user_management/users/token"+
		                "?api_key=6RNFlp1aMIudVcMXrOABpm1E_w"+
				        "&api_secret=6wmcw_VZQijBB0AFZQQ0g3BbPcSE_kWYSAjlyooaEts");
		int code=res.getStatusCode();
		
		String str=res.toString();
		System.out.println("Response is "+code);
		
		
		
	}

}
 