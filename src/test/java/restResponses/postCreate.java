package restResponses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import io.restassured.http.ContentType;

public class postCreate {
	
	
	
	@Given("^an API to post$")
	@Test
	public void postCreate(){
		
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
	
		
		

		
		Assert.assertEquals(response.getStatusCode(), 200,"Status is not 200");
		
		SoftAssert softAssert=new SoftAssert();
		
		String actualFirstName    =response.jsonPath().getString("booking.firstname");
		softAssert.assertEquals(actualFirstName,"gurupalli","wrong firstname" );
		
		
		String actualLastName=response.jsonPath().getString("booking.lastname");
		softAssert.assertEquals(actualLastName,"tarun","unexpected lastname" );
		
		int price=response.jsonPath().getInt("booking.totalprice");
		softAssert.assertEquals(price,312,"wrong price");
		boolean deppaid=response.jsonPath().getBoolean("booking.depositpaid");
		softAssert.assertFalse(deppaid,"deposit is not alse");
		
		String checkInDate=response.jsonPath().getString("booking.bookingdates.checkin");
		softAssert.assertEquals(checkInDate, "2018-01-01");
		
		String checkOutDate=response.jsonPath().getString("booking.bookingdates.checkout");
		softAssert.assertEquals(checkOutDate, "2019-09-09");
		
		softAssert.assertAll();
		/*try {
			PrintStream result=new PrintStream(new File("C:\\Users\\2130177\\eclipse-workspace\\restPrac\\target\\files\\post.json"));
			result.print(response.prettyPrint());
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}*/
		int bookingId=response.jsonPath().getInt("bookingid");
		
	
		
		
		File id=new File("C:\\Users\\2130177\\eclipse-workspace\\restPrac\\target\\idinfo.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sh=wb.createSheet();
		sh.createRow(0).createCell(0).setCellValue(bookingId);
		
		try {
			FileOutputStream fs=new FileOutputStream(id);
			wb.write(fs);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
