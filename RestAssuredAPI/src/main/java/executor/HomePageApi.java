package executor;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import restapi.RestAssuredAPI.SignInEnum;

public class HomePageApi {

	public HomePageApi() {
		RestAssured.baseURI = SignInEnum.BASE_URI.url();
	}

	public Response configJson() {
		
		Response res = null;
		try {
			res = given().contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.when()
					.get("config.json")
					.then().extract().response();

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return res;
	}
	
	public Response siteConfigJson() {
		Response res = null;
		try {
			res = given().contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.when()
					.get("siteConfig.json")
					.then().extract().response();

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return res;
	}

}
