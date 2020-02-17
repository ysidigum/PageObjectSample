package executor;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import restapi.RestAssuredAPI.SignInPostEnum;

public class SignInPageAPI {

	 public SignInPageAPI() {
		 
		 RestAssured.baseURI = SignInPostEnum.BASE_URI.url();
	 }
	
	 public Response signInToken() {
		 
		 Response res = null;
		 try {
			 res = given().contentType(ContentType.URLENC.withCharset("UTF-8"))
					 .formParam("grant_type", "client_credentials")
					 .when()
					 .post("data/auth/token")
					 .then()
					 .contentType(ContentType.JSON)
					 .extract()
					 .response();
			
		 }catch (Exception e) {
			 System.out.println(e.getMessage());
		}
		  
		 return res;
				 
	 }
}
