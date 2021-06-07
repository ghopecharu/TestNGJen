package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExamole {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://demo.guru99.com/test/drag_drop.html");
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        TakesScreenshot TsObj=(TakesScreenshot) driver;
        File myFile = TsObj.getScreenshotAs(OutputType.FILE);
        try {
        FileUtils.copyFile(myFile, new File("tests.png"));
        
        }catch(IOException e) {
        	//TODO Auto-generated catch block.
        	 e.printStackTrace();
        }
	}

}
