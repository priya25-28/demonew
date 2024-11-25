



import files.Payload;
import io.restassured.path.json.JsonPath;



public class ComplexjsonParse {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		

		

		JsonPath js=new JsonPath(Payload.CoursePrice());

		

		//Print number of course returned by API

		

		int count=	js.getInt("courses.size()");//size is a method to get the count only on array.

		System.out.println(count);

		

		//Print Purchase Amount

		int totalAmount= js.getInt("dashboard.purchaseAmount");

		System.out.println(totalAmount);

		

		//Print Title of the first course

          String titleFirstCourse=js.get("courses[0].title");// get first index title

		  System.out.println(titleFirstCourse);

		  
   //Print All course titles and their respective Prices

		  for(int i=0;i<count;i++)

		  {  String courseTitles=js.get("courses["+i+"].title");

			  System.out.println(js.get("courses["+i+"].price").toString());
			  // converting it to  string as sopln accepts only string

			   System.out.println(courseTitles);

			   }
		  
		  //Print no of copies sold by RPA Course
		  
		  System.out.println("Print no of copies sold by RPA Course");
		  
		  for(int i=0;i<count;i++)
		  {
		 	  String courseTitles=js.get("courses["+i+"].title");
		 	  if(courseTitles.equalsIgnoreCase("RPA"))
		 	  {
		 		  int copies=js.get("courses["+i+"].copies");
		 		  System.out.println(copies);
		 		  break;
		 	  }
}

}

}