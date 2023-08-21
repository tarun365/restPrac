package restResponses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Files;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import io.restassured.http.ContentType;

public class patchChange {
	
	@Test
	public void patchChange() {
JSONObject matter=new JSONObject();
		
		matter.put("firstname", "gurupalli");
		matter.put("lastname","tarun");
		matter.put("totalprice", 312);
		matter.put("depositpaid", false);
		
		JSONObject date=new JSONObject();
		
		date.put("checkin", "2018-01-01");
		date.put("checkout","2019-09-09");
		
		matter.put("bookingdates", date);
		matter.put("additionalneeds","bsjduk");
		
		Response response=RestAssured.given().contentType(ContentType.JSON).body(matter.toString()).
				post("https://restful-booker.herokuapp.com/booking ");
		response.print();
		
		int bookingId=response.jsonPath().getInt("bookingid");
		
JSONObject matter1=new JSONObject();
		
		
		matter1.put("lastname","trun");
		matter1.put("totalprice", 7312);
		
		
		JSONObject date1=new JSONObject();
		
		date1.put("checkin", "2013-01-01");
		date1.put("checkout","2018-09-09");
		
		matter1.put("bookingdates", date);
		
		
		Response responseNew=RestAssured.given()
				.auth().preemptive().basic("admin", "password123")
				.contentType(ContentType.JSON).body(matter1.toString()).
				patch("https://restful-booker.herokuapp.com/booking/"+bookingId);
		responseNew.print();
		
Assert.assertEquals(responseNew.getStatusCode(), 200,"Status is not 200");
		
		
		try {
			PrintStream result=new PrintStream(new File("C:\\Users\\2130177\\eclipse-workspace\\restPrac\\target\\files\\patch.json"));
			result.print(responseNew.prettyPrint());
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
