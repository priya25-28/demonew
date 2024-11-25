import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;
import files.ReusableMethods;


public class BasicsJava {

public static void main(String[] args) {
// TODO Auto-generated method stub
// validate if Add Place API is workimg as expected


//given - all input details
//when - Submit the API -resource,http method
//Then - validate the response
RestAssured.baseURI= "https://rahulshettyacademy.com";
String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
.body(Payload.AddPlace())
.when().post("maps/api/place/add/json")
.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();//extracted the string

System.out.println(response);

// Extract the place id to use it in UPDATE API
JsonPath js=new JsonPath(response); //for parsing Json
// jsonpath will parse the json and js will store them
String placeId=js.getString("place_id");//location of placeid(starts from parent so here no parent , so directly placeid)
System.out.println(placeId);

//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
String newAddress = "70, america";

given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
.body("{\r\n" +
"\"place_id\":\""+placeId+"\",\r\n" +
"\"address\":\""+newAddress+"\",\r\n" + //adding with operator as it will take it as a variable not string
"\"key\":\"qaclick123\"\r\n" +
"}").
when().put("maps/api/place/update/json")
.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

// Get http: to check if address is updated



String getPlaceResponse= given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeId)
.when().get("maps/api/place/get/json")
.then().assertThat().log().all().statusCode(200).extract().response().asString();

JsonPath js1=ReusableMethods.rawTojson(getPlaceResponse);// optimizing code just
String actualAddress =js1.getString("address");
System.out.println(actualAddress);

//Cucumber Junit, testng

Assert.assertEquals(actualAddress, newAddress);

}
}
