package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebDriverTest {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.simplilearn.com/");
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        
        WebElement LoginLink= driver.findElement(By.linkText("Log in"));
	    LoginLink.click();
	    
	    WebElement UserName= driver.findElement(By.name("user_login"));
	    UserName.sendKeys("abc@xyz.com");
	   
	    WebElement Password = driver.findElement(By.id("password"));
	    Password.sendKeys("test@123");
	    
	    WebElement RememberMe = driver.findElement(By.className("rememberMe"));
	    RememberMe.click();
	    
	    WebElement Login = driver.findElement(By.name("btn_login"));   //Login button
	    Login.click();
	    
	    WebElement Error =driver.findElement(By.id("msg_box"));
	    String ActMsg= Error.getText();
	    
	    String ClassName=Error.getAttribute("class");
	    String TagName=Error.getTagName();
	    
	    System.out.println("Class Name is: "+ClassName);
	    System.out.println("Tag Name is: " +TagName);
	    
	    List<WebElement> listOfInputs = driver.findElements(By.tagName("input"));
	    System.out.println("Total inputs Tags are:" +listOfInputs.size());
	    
	    List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
	    System.out.println("Total links present are:" +listOfLinks.size());
	    
	    for (int i=0;i<listOfLinks.size();i++) {
	    	System.out.println(i+" Link: "+listOfLinks.get(i).getText());
	    }
	    
	    String ExpMsg ="The email or password you have entered is invalid.";
	    
	    if(ActMsg.equals(ExpMsg)) {
	    	System.out.println("Test Passed");
	    }
	    else {
	    	System.out.println("Test Failed");
	    }
	    //driver.close();
	}

}
