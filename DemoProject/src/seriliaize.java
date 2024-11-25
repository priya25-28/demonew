import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.Location;
public class seriliaize {
	
	public static void main(String[] args) {
	
	RestAssured.baseURI= "https://rahulshettyacademy.com";
	
	AddPlace p = new AddPlace();
	p.setAccuracy(50);
	p.setAddress("\"29, side layout, cohen 09");
	p.setLanguage("French-IN");
	p.setName("Priya");
	p.setPhone_number("(+91) 983 893 3937");
	List<String> myList= new ArrayList<String>();
	myList.add("shoe");
	myList.add("cobo");
	
	p.setTypes(myList);
	Location l = new Location();
	l.setLat(12);
	l.setLng(12);
	
	p.setLocation(l);
String res=	given().log().all().queryParam("key", "qaclick123")
	.body(p)
	.when().post("maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response().asString();

System.out.println(res);

}
}