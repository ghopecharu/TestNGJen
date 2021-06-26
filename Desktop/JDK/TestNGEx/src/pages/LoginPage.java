package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.LoginTest2;

public class LoginPage {
	
WebDriver driver;
ExtentReports  report;
ExtentTest test;

//WebElements========
@FindBy(linkText="Log in")
WebElement LoginLink;

@FindBy(name="user_login")
WebElement UserName;

@FindBy(name="user_pwd")
WebElement password;

@FindBy(className="rememberMe")
WebElement RememberMe;

@FindBy(name="btn_login")
WebElement Login;

@FindBy(id="error_box")
WebElement Error;

//=========Constructor===================

public LoginPage() {
	
	driver=LoginTest2.driver;
	report=LoginTest2.report;
	test=LoginTest2.test;
	PageFactory.initElements(driver,this);
	
}
//	===Methods================
public void Login(String uname, String upass) {


  test=report.startTest("Login Test Case");
	
 
 
  LoginLink.click();
  test.log(LogStatus.PASS, "Successfully clicked on the login button");
  
  WebDriverWait wait = new WebDriverWait(driver,30);
  wait.until(ExpectedConditions.elementToBeClickable(UserName));

  UserName.sendKeys(uname);
  test.log(LogStatus.PASS, "Successfully entered on the username");
  
  password.sendKeys(upass);
  test.log(LogStatus.PASS, "Successfully entered password");
  
 
  RememberMe.click();
  
  Login.click();
  test.log(LogStatus.PASS, "Successfully clicked on the login link");
  
  String ActMsg= Error.getText();
  String ExpMsg= "Please enter a valid email address";
  
//  WebElement Error =driver.findElement(By.id("msg_box"));
  

  
   System.out.println(ActMsg);
  
   Assert.assertTrue(Error.isDisplayed());
  
   Assert.assertEquals(ActMsg,ExpMsg);
 
  
}

}