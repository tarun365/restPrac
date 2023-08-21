package restResponseTest;

import java.io.IOException;

import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import restResponses.*;

public class test {
	
	deleteBooking d;
	getInfo g;
	patchChange p;
	postCreate pc;
	putUpdate u;
	
	
	
	@Test(priority=0)
	public void post() {
		pc=new postCreate();
		pc.postCreate();
		
	}
	
	
    @Test(priority=1)
    public void get() throws IOException {
    	g=new getInfo();
    	g.getInfo();
    }
    
	
    @Test(priority=2)
    public void put() throws IOException {
    	u=new putUpdate();
    	u.putUpdate();
    }
    
	
    @Test(priority=3)
    public void delete() throws IOException {
    	d=new deleteBooking();
    	d.deleteBooking();
    }
    
	

}
