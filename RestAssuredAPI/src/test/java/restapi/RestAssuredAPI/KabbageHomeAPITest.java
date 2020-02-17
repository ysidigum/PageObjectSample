package restapi.RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import executor.HomePageApi;

public class KabbageHomeAPITest {

	HomePageApi hpa = null;
	
	@BeforeTest
	public void initialize() {
		hpa = new HomePageApi();
	}
	
	
	@Test
	public void signInApi() {

		hpa = new HomePageApi();
		Response res = hpa.configJson();
		
		Assert.assertTrue(res.jsonPath().get("app_domain").equals("app.kabbage.com"), 
				"The Value For the Config Json Is Missing app.kabbage.com");
		
		Assert.assertTrue(res.statusCode()==200);
	}
	
	@Test
	public void siteConfig() {

		hpa = new HomePageApi();
		Response res = hpa.siteConfigJson();
		
		Assert.assertTrue(res.jsonPath().get("emailAddress").equals("support@kabbage.com"), 
				"The Value For the Site Json Is Missing support@kabbage.com");
		
		Assert.assertTrue(res.statusCode()==200);
	}
	
}

