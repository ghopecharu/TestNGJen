package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignup {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        
	        WebDriver driver = new ChromeDriver();
	        
	        driver.get("https://facebook.com/");
			
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	        driver.findElement(By.partialLinkText("English (UK)")).click();
	        
	        WebElement CreateNewAccount= driver.findElement(By.xpath("//*[text()='Create New Account']"));
	        CreateNewAccount.click();
	        
	        WebElement FirstName= driver.findElement(By.xpath("//input[@name='firstname']"));
	        FirstName.sendKeys("ABC");
	   	   
	  	    WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
	    	LastName.sendKeys("XYZ");
	    	
	    	WebElement Mobileno = driver.findElement(By.xpath("//input[@name='reg_email__']"));
	    	Mobileno.sendKeys("98608989");
	    	WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
	    	password.sendKeys("abc@123");
	    
	        WebElement Dob= driver.findElement(By.xpath("//select[@name='birthday_day']"));
	        Select dDob= new Select(Dob);
	        dDob.selectByVisibleText("10");
	     //   dDob.selectByIndex(9);
	    //    dDob.selectByValue("10");
	        WebElement month1 = driver.findElement(By.xpath("//select[@name='birthday_month']"));
	        Select month11= new Select(month1);
	        month11.selectByVisibleText("Aug");
	        WebElement year1= driver.findElement(By.xpath("//select[@name='birthday_year']"));
	        Select year11= new Select(year1);
	        year11.selectByVisibleText("1985");
	      
	    	//WebElement radio1 = driver.findElement(By.xpath("//input[@name='sex']"));
	    	//WebElement radio2 = driver.findElement(By.xpath("(//*[@data-name='gender_wrapper']/span/input)[2]"));
	       // radio2.click();
	        //WebElement SignUp= driver.findElement(By.xpath("//button[@name='websubmit' ] "));
	        //SignUp.click();
	          WebElement radio2 = driver.findElement(By.xpath("//input[@name='sex' and @value='-1']"));
		      radio2.click();
	}

}
