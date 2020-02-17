package restapi.RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import executor.SignInPageAPI;

public class KabbageSignInAPITest {

	SignInPageAPI signInApi = null;
	Response res = null;

	@BeforeMethod
	public void initialize() {
		signInApi = new SignInPageAPI();
	}


	@Test
	public void tokenGen() {
		res = signInApi.signInToken();

		Assert.assertTrue(res.jsonPath().get("type").equals("clientAuth"), 
				"Client Auth Failed");

		Assert.assertTrue(res.statusCode()==200);
	}
}
