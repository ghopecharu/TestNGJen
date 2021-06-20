package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	@BeforeGroups("Regression")
	public void BeforeGroupsMethod() {
		System.out.println("Inside Before Group");
	}
	
	@BeforeTest
	public void BeforeTestMethod() {
		System.out.println("Inside Before Test");
	}
	
	@BeforeMethod
	public void Setup() {
		System.out.println("Inside before method");
	}
	
	
    @Test(groups= {"Sanity"})
	public void LoginTest() {
	System.out.println("Inside the Login Test");	

	}
  //@Test(enabled=false)
    
    @Test (groups= {"Regression"})
   public void SignUpTest() {
	   System.out.println("Inside the SignUp Test"); 
   }
    @Test(groups= {"Regression"})
    public void Random() {
 	   System.out.println("Inside the Random"); 
    }
     
    @AfterMethod
    public void AfterMeth() {
    	System.out.println("Inside the After Method "); 
    }
    @AfterTest
    public void AftreTestMethod() {
    	System.out.println("Inside the After Test "); 
    }
}
