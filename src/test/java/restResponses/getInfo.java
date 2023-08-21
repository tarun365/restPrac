package restResponses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getInfo {
	
	
	@When("^get the created API$")
	@Test
	public void getInfo() throws IOException {
		FileInputStream inputStream=new FileInputStream("C:\\Users\\2130177\\eclipse-workspace\\restPrac\\target\\idinfo.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=book.getSheet("Sheet0");
		
		
		XSSFRow cellData=sheet.getRow(0);
		
		int bookingId=(int) cellData.getCell(0).getNumericCellValue();
		
		
		Response response=RestAssured.get("https://restful-booker.herokuapp.com/booking/"+bookingId);
		response.print();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		}
	}


