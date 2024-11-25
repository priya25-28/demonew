import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateBuginJira {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
RestAssured.baseURI="https://bhatnagarpriya007.atlassian.net/";
String createIssueResponse	=given().header("Content-Type","application/json").header("Authorization","Basic YmhhdG5hZ2FycHJpeWEwMDdAZ21haWwuY29tOkFUQVRUM3hGZkdGMERBc3hhbTlpVW9aZ1NkejRXX1FpejFTaDk3YW1OTTdBSUdFUl8tQUtNQnpYREplZWczNjNGSVd5SWgzenJqQl9CLXRublA3VW9RdHRQdWpfdF9fRWJ4cURrclAyUy0xaDFDV0NEbFFfTmo0N2VYR3VMWlpxQmt3VHRtNWliMUVxaVlHWE5PSWdfRGo3ZGdfQmRvMzF6VzJHUVhVWkl4bEEwSzZZcUdkZW1Saz0zNzRCRDQ2OQ==")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"applicationpriya are  NOT WORKING with attachment\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}")
		.log().all()
		.post("/rest/api/3/issue").then().log()
.all().assertThat().statusCode(201).extract().response().asString();
		
		
		JsonPath js = new JsonPath(createIssueResponse);
		String issueid=js.getString("id");
		System.out.println(issueid);
		
		// Add Attachment
		given()
		.pathParam("key", issueid)
		.header("Authorization","Basic YmhhdG5hZ2FycHJpeWEwMDdAZ21haWwuY29tOkFUQVRUM3hGZkdGMERBc3hhbTlpVW9aZ1NkejRXX1FpejFTaDk3YW1OTTdBSUdFUl8tQUtNQnpYREplZWczNjNGSVd5SWgzenJqQl9CLXRublA3VW9RdHRQdWpfdF9fRWJ4cURrclAyUy0xaDFDV0NEbFFfTmo0N2VYR3VMWlpxQmt3VHRtNWliMUVxaVlHWE5PSWdfRGo3ZGdfQmRvMzF6VzJHUVhVWkl4bEEwSzZZcUdkZW1Saz0zNzRCRDQ2OQ==")
		.header("X-Atlassian-Token","no-check")
		.multiPart("file",new File("C:\\Users\\Priya Bhatnagar\\Pictures\\Saved Pictures\\image.jpg"))
		.post("rest/api/3/issue/{key}/attachments").then()
		.log().all().assertThat().statusCode(200);
	}

}
