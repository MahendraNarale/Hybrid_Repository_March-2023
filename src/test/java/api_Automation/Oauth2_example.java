package api_Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Oauth2_example {
	@Test
	public static void test1()
	{
		
		Response resp=RestAssured
		.given()
		.formParam("api_key", "SpHPu0ps7dKjJEBY9jE9S6qoDw")
		.formParam("api_secret", "SWv-eRyWjHyzqpGT1a1YImcXtbaOhomoFwS6XXGqUYY")
		.get("https://api.axio.dev/servev3/usrmgmt/user_management/users/token");
		
		System.out.println("Status code"+resp.getStatusCode());
		//System.out.println(resp.asPrettyString());
		System.out.println(resp.getBody().jsonPath().get("access_token"));
	}

}
