package test;

public class SugFbSignup {

	public static void main(String[] args) {
		
		
		WebElement CreateAccount = driver.findElement(By.xpath("//a[contains(@data-testid,'open')]"));
        CreateAccount.click();
        
        WebElement firstName = driver.findElement(By.xpath("//input[@name ='firstname']"));
        firstName.sendKeys("Sugandha");
        
        WebElement lastName = driver.findElement(By.xpath("//input[@name ='firstname'] //following::input[1]"));
        lastName.sendKeys("Khandelwal");
        
        WebElement MobileNo = driver.findElement(By.xpath("//input[@name ='firstname'] //following::input[2]"));
        MobileNo.sendKeys("9823723823");
        
        WebElement password = driver.findElement(By.xpath("//input[@name ='reg_passwd__'] "));
        password.sendKeys("Password@123");
        
        //select DOB
        
        WebElement month = driver.findElement(By.xpath("//select[@id ='month' ] "));
        Select DOBmonth = new Select(month);
        
        DOBmonth.selectByVisibleText("Jul");
        
        WebElement birthday = driver.findElement(By.xpath("//select[@name='birthday_day' ] "));
        Select DOBbirthday = new Select(birthda

       DOBbirthday.selectByVisibleText("8");
        
        WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year' ] "));
        Select DOByear = new Select(year);
        DOByear.selectByValue("1992");
        
        WebElement Gender = driver.findElement(By.xpath("//input[@name='sex' ] "));
        Gender.click();
        
        WebElement SignUp= driver.findElement(By.xpath("//button[@name='websubmit' ] "));
        SignUp.click();

	}

}
