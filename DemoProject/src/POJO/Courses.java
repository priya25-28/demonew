package POJO;

import java.util.List;

public class Courses {
	

	private List<WebAutomation> webAutomation;// as webautomation has nested jsons inside this we created three 
	//separate classes for all three and injected the getters and setters and called it in main class
	//list because its a array of elements
	private List<Api> api;
	private List<Mobile> mobile;
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}


	}
