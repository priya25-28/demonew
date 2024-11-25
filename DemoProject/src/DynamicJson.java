import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethods;

public class DynamicJson {
	
	@Test(dataProvider="BooksData") // creating test without public static void main
	
	public void addBook(String isbn, String aisle)//connection for data provider because each array has two elements
	// and we need to pass these elements here also
	{
		
		// Add book
		
		RestAssured.baseURI="http://216.10.245.166";
	String response = 	given().log().all().header("Content-Type","application/json")
//			.body(Payload.Addbook("fghgh","hvvh")) // passing only one data passing the data from here , rather then coding in payload.java
			// building json dynamically with external inputs
		.body(Payload.Addbook(isbn,aisle)) // passing n number of input using data provider
		.when()
		.post("Library/Addbook.php")
		.then().log().all()
		.assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js=ReusableMethods.rawTojson(response);
	String id =js.get("ID");
	System.out.println(id);
	}
	
	
	
	@DataProvider(name="BooksData")
	
	public Object[][] getData() {
		//array=collection of elemets
		//multi dimensional array=collection of arrays
	return new Object[][] {{"aa","12"},{"bb","13"},{"cc","145"}};
		//array 1, 2,3 , it will run three times with 3 values that why we used multi dim array
	}
}
