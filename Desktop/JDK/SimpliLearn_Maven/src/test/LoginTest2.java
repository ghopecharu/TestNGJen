package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest2 extends BaseClass {

@Test(enabled=false)
@Parameters({"username","password"})

 public void LoginTestcase(String uname, String pass) {
	
 LoginPage Loginobj= new LoginPage();
 Loginobj.Login(uname,pass);
}

@Test	

 public void LoginTestcase2() {
	
 LoginPage Loginobj= new LoginPage();
 String uname=sheet.getRow(1).getCell(0).getStringCellValue();
 String pass=sheet.getRow(1).getCell(1).getStringCellValue();
 Loginobj.Login(uname,pass);
}
}
