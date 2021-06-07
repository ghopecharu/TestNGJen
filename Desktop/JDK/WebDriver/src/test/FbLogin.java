package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class FbLogin {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://facebook.com/");
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.partialLinkText("English (UK)")).click();
        WebElement UserName= driver.findElement(By.xpath("//input[@name='jazoest']/following-sibling::input"));
        String name=UserName.getAttribute("value");
        System.out.println(name);
        WebElement CreateNewAccount= driver.findElement(By.xpath("//a[text()='Create New Account']"));
        CreateNewAccount.click();
        WebElement Dob= driver.findElement(By.xpath("//select@name='birthday_day']"));
        Select dDob= new Select(Dob);
        dDob.selectByVisibleText("Feb");
        dDob.selectByIndex(0);
        dDob.selectByValue("10");
      //  WebElement Heading = driver.findElement(By.xpath("//h2[text()='Facebook helps you connect and share with the people in your life.']"));
       // WebElement Heading = driver.findElement(By.xpath("//*[text()='Facebook helps you connect and share with the people in your life.']"));
       // System.out.println(Heading.getAttribute());
        // WebElement CreateNewAccount= driver.findElement(By.xpath("//a[contains(@data-testid,'open')]"));
       //  CreateNewAccount.click();
        
        
     //   WebElement CreateNewAccount= driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
      //  CreateNewAccount.click();
        
      //  WebElement UserName= driver.findElement(By.xpath("//input[@name='email']"));
      //  UserName.sendKeys("abc@xyz.com");
 	   
	  //  WebElement Password = driver.findElement(By.xpath("//input[@id='pass']"));
	 //   Password.sendKeys("test@123");
	    
	  //  WebElement Login = driver.findElement(By.xpath("//button[@name='login']"));   //Login button
	   // Login.click();

	}

}
