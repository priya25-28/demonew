import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import POJO.Api;
import POJO.GetCourse;
import POJO.WebAutomation;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
public class demoOauthAPItest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	String response=	given()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

        .formParams("grant_type", "client_credentials")

        .formParams("scope", "trust")

        .when().log().all()
        
        .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		System.out.println(response);
		
	JsonPath js = new JsonPath(response);
		String accesstoken=js.getString("access_token");
		System.out.println(accesstoken);
		
//	String response2=	given()
//		.queryParams("access_token", accesstoken)
//		.when()
//
//        .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
//		
//		System.out.println(response2);
		
		// implementing pojo class :desrialization
		
		GetCourse gc=	given()
				.queryParams("access_token", accesstoken)
				.when()

		        .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);//
		//it will hit the api and will take the convert the response body into java object)
				
			
			System.out.println	(gc.getLinkedIn());
			System.out.println(gc.getInstructor());
	System.out.println(	gc.getCourses().getApi().get(1).getCourseTitle());// get the course title of index 1
	
	// index may change in future so trying to access dynamically
	//get price for saopUI
	
	 List<Api> apiCourses=       gc.getCourses().getApi();
	 for(int i=0;i<apiCourses.size();i++) {
		 if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
			 System.out.println(apiCourses.get(i).getPrice());
		 }
		 
		 // print the course title of web automation
		 
	List<WebAutomation> w=	 gc.getCourses().getWebAutomation();
	for(int j=0;j<w.size();j++)
	{
	System.out.println(   w.get(j).getCourseTitle());
	}
	 }
	 
	 // storing the course title in array and then comapring it with expected
	 String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
	 
	 ArrayList<String> a = new  ArrayList<String>();
	 
	 List<WebAutomation> w=	 gc.getCourses().getWebAutomation();
		for(int j=0;j<w.size();j++)
		{
			a.add(w.get(j).getCourseTitle());
			
		}
		List<String> expectedList= Arrays.asList(courseTitles);
		
		Assert.assertTrue(a.equals(expectedList));
	}

}
