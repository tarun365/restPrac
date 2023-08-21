package restResponses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

public class putUpdate {
	
	
	@Then("^update the API$")
	@Test
	public void putUpdate() throws IOException {
		FileInputStream inputStream=new FileInputStream("C:\\Users\\2130177\\eclipse-workspace\\restPrac\\target\\idinfo.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=book.getSheet("Sheet0");
		
		
		XSSFRow cellData=sheet.getRow(0);
		
		int bookingId=(int) cellData.getCell(0).getNumericCellValue();


		
JSONObject matter1=new JSONObject();
		
		matter1.put("firstname", "guru");
		matter1.put("lastname","trun");
		matter1.put("totalprice", 7312);
		matter1.put("depositpaid", false);
		
		JSONObject date1=new JSONObject();
		
		date1.put("checkin", "2013-01-01");
		date1.put("checkout","2018-09-09");
		
		matter1.put("bookingdates", date1);
		matter1.put("additionalneeds","bsjduk");
		
		Response responseNew=RestAssured.given()
				.auth().preemptive().basic("admin", "password123")
				.contentType(ContentType.JSON).body(matter1.toString()).
				put("https://restful-booker.herokuapp.com/booking/"+bookingId);
		responseNew.print();
		
Assert.assertEquals(responseNew.getStatusCode(), 200,"Status is not 200");
		
		
		
		
		
		
	}

}
