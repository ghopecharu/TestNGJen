package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtableExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://w3schools.com/html/html_tables.asp");
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
       
         List<WebElement> Rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        
        System.out.println("Total Rows are: " + Rows.size());
        
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id = 'customers'] /tbody/tr/th"));
        
        System.out.println("Total columns are :" + columns.size());  
        
        WebElement data=driver.findElement(By.xpath("//table[@id = 'customers'] /tbody/tr[4]/td[1]"));
       
        System.out.println("Data:" + data.getText());
        
        WebElement ScrollElem = driver.findElement(By.xpath("//h2[text()='HTML Table - Add Cell Padding']"));
         JavascriptExecutor obj=(JavascriptExecutor) driver;
         obj.executeScript("arguments[0].scrollIntoView();", ScrollElem);
        // ScrollElem.click();
	}

}
