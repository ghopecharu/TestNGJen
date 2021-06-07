package test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazonproj {

	public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://amazon.in");
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
      try {
          
          //Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce1","root","root");
          Statement stmt = con.createStatement();  
          ResultSet rs = stmt.executeQuery("select * from amazon"); 
         
          WebElement AllCategoryDropdown=driver.findElement(By.xpath("//select[@title='Search in']"));
          WebElement searchField=driver.findElement(By.xpath("//input[@name='field-keywords']"));
          
          Select category= new Select(AllCategoryDropdown);
        
        		  while(rs.next()) {
              String cat =rs.getString(2);
              category.selectByVisibleText(cat);
              
              System.out.println(rs.getString(2)+ "    "+rs.getString(3)); 
             // String Category = rs.getString(1);
              String searchValue = rs.getString(3);
              searchField.sendKeys(searchValue);
           
              }
        		  
              WebElement submitValue=driver.findElement(By.xpath("//input[@type='submit']"));
              submitValue.click();
              
              List<WebElement> resultList=driver.findElements(By.xpath("//*[@data-component-type='s-search-result']"));
              System.out.println("Total Search count:" +resultList.size());
         
              TakesScreenshot TsObj=(TakesScreenshot) driver;
              File myFile = TsObj.getScreenshotAs(OutputType.FILE);
          
              try {
               FileUtils.copyFile(myFile, new File("amazonscreen.png"));
                }catch (IOException e) {
   	             // TODO Auto-generated catch block
   	             e.printStackTrace();
   	         }
   	        	
   	    	
   	    	
   		 } catch (SQLException e) {
   	            
   	           System.out.println("SQL Exception");
   	        } 
   		
   	}

   }

