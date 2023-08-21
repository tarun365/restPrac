package restResponses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import cucumber.api.java.en.And;
import io.restassured.http.ContentType;


public class deleteBooking {
	
	
	@And("^delete the API$")
	@Test
	public void deleteBooking() throws IOException {
		FileInputStream inputStream=new FileInputStream("C:\\Users\\2130177\\eclipse-workspace\\restPrac\\target\\idinfo.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=book.getSheet("Sheet0");
		
		
		XSSFRow cellData=sheet.getRow(0);
		
		int bookingId=(int) cellData.getCell(0).getNumericCellValue();

		
		Response responseNew=RestAssured.given()
				.auth().preemptive().basic("admin", "password123")
				.
				delete("https://restful-booker.herokuapp.com/booking/"+bookingId);
		responseNew.print();
		
Assert.assertEquals(responseNew.getStatusCode(), 201,"Status is not 200");


	}

}
