import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

import files.Payload;
import io.restassured.RestAssured;

public class HandleStaticJsonFile {
	

public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
	
	
	// content of file to string as body accepts string
	// method to convert file to byte
	// then from byte to string
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body(new String( Files.readAllBytes(Paths.get("C:\\Users\\Priya Bhatnagar\\add.json"))))
	.when().post("maps/api/place/add/json")
	.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
	.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

	System.out.println(response);


}
}
