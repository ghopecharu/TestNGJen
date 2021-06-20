package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
	
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest test;
	SoftAssert soft =new SoftAssert();
	
	@BeforeMethod	
	
	 public void Setup() {
		
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 
		   driver= new ChromeDriver();
		   driver.get("https://www.simplilearn.com/");
		   
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	       
	       report= new ExtentReports("ExtentReport.html");
	}
	
	@Parameters({"username","password"})
	
@Test	

 public void Login(String uname, String pass) {

   test=report.startTest("login Test Case");
	
   WebElement LoginLink= driver.findElement(By.linkText("Log in"));
   LoginLink.click();
   
   test.log(LogStatus.PASS, "Successfully clicked on the login button");
   
   WebElement UserName= driver.findElement(By.name("user_login"));
   UserName.sendKeys(uname);
   
   test.log(LogStatus.PASS, "Successfully entered on the username");
   
   WebElement Password = driver.findElement(By.id("password"));
   Password.sendKeys(pass);
   
   test.log(LogStatus.PASS, "Successfully entered password");
   
   WebElement RememberMe = driver.findElement(By.className("rememberMe"));
   RememberMe.click();
   
   WebElement Login = driver.findElement(By.name("btn_login"));   //Login button
   Login.click();
   test.log(LogStatus.PASS, "Successfully clicked on the login link");
   
   
   String ExpMsg= "The email or password you have entered is invalid";
   
   WebElement Error =driver.findElement(By.id("msg_box"));
   
   String ActMsg= Error.getText();
   
   System.out.println(ActMsg);
   
   Assert.assertTrue(Error.isDisplayed());
   
   soft.assertEquals(ActMsg,ExpMsg);
   System.out.println("After soft Assert");
   
   /*
   try {
	   
   Assert.assertEquals(ActMsg,ExpMsg);
   
   test.log(LogStatus.PASS, "Expected and Actual Message matches");
   
   }catch(Throwable e) {

   test.log(LogStatus.FAIL, "Expected and Actual Message does not match");
   }*/
	}

 @AfterMethod
public void teardown() {
	 
	// soft.assertAll(); if we add here , it does not close browser.
	 
	 report.endTest(test);
	 report.flush();
	 
	//driver.quit();
	
	//soft.assertAll();
}
 
}


