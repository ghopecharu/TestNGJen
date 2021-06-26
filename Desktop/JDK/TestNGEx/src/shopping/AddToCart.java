package shopping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddToCart {
WebDriver driver;
	
	ExtentReports report;
	ExtentTest test;
	SoftAssert soft =new SoftAssert();
	
	@BeforeTest	
	
	 public void Setup() {
		
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 
		   driver= new ChromeDriver();
		   driver.get("https://www.saucedemo.com/");
		   
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	       
	       report= new ExtentReports("ExtentReport.html");
	}
	
@Parameters({"username","password"})
	
@Test	

 public void Login(String uname, String pass) {

   test=report.startTest("login Test Case");
   
   WebElement UserName= driver.findElement(By.name("user-name"));
   UserName.sendKeys(uname);
   
   test.log(LogStatus.PASS, "Successfully entered on the username");
   
   WebElement Password = driver.findElement(By.id("password"));
   Password.sendKeys(pass);
   
   test.log(LogStatus.PASS, "Successfully entered password");

   
   WebElement Login = driver.findElement(By.name("login-button"));   //Login button
   Login.click();
  
   test.log(LogStatus.PASS, "Successfully clicked on the login link");
	}
  
   @Test(dependsOnMethods="Login")
   
   public void AddToCarts() {
   
   WebElement AddToCart = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
   AddToCart.click();
   
   WebElement CartContainer = driver.findElement(By.id("shopping_cart_container"));
   CartContainer.click();
 
  String cartitem1 = driver.findElement(By.className("cart_quantity")).getText();
   System.out.println("No of items added in cart:  " +cartitem1);
   
   String cartitem2 = driver.findElement(By.className("inventory_item_name")).getText();
   System.out.println("Item name:  " +cartitem2);
   String cartitem3 = driver.findElement(By.className("inventory_item_desc")).getText();
   System.out.println("Item Description:  "+cartitem3);
   
  // String Cartbadge = driver.findElement(By.className("shopping_cart_badge")).getText();
 
 // WebElement AddToCartCheck = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));
 // AddToCartCheck.click()
   }
 


 @AfterTest
public void teardown() {
	 
	// soft.assertAll(); if we add here , it does not close browser.
	 
	 report.endTest(test);
	 report.flush();
	 
	driver.quit();
	
	soft.assertAll();
}
 
}

