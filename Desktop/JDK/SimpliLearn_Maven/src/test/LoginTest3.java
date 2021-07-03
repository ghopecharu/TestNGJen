package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage1;
@Listeners(TestNGListenerEx.class)
public class LoginTest3 extends BaseClass1 {

@Test(enabled=false)
@Parameters({"username","password"})

 public void LoginTestcase(String uname, String pass) {
	
 LoginPage1 Loginobj= new LoginPage1();
 Loginobj.Login(uname,pass);
}

@Test	

 public void LoginTestcase2() {
	
 LoginPage1 Loginobj= new LoginPage1();
 String uname=sheet.getRow(1).getCell(0).getStringCellValue();
 String pass=sheet.getRow(1).getCell(1).getStringCellValue();
 Loginobj.Login(uname,pass);
}
}
