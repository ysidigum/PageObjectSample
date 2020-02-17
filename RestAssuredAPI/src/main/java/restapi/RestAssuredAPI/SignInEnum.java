package restapi.RestAssuredAPI;

public enum SignInEnum {

	BASE_URI("https://www.kabbage.com/");

	
	private String url;
	
	SignInEnum(String url) {
		this.url = url;
	}
	
	public String url() {
		return url;
	}
}
