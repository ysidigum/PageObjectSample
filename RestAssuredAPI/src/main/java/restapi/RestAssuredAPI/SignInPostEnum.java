package restapi.RestAssuredAPI;

public enum SignInPostEnum {
	
	BASE_URI("https://app.kabbage.com/");

	private String url;
	
	SignInPostEnum(String url) {
		this.url = url;
	}
	
	public String url() {
		return this.url;
	}
	
}
