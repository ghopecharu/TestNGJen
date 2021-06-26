package test;

import org.testng.annotations.Test;

public class TestCase2 {

    @Test(priority=0, description ="Verify that HomePage Functionality is working fine.",groups="Regression")
    
    public void HomePage(){
    
    System.out.println("Inside HomePage");

	}
@Test(priority=1)
    
    public void HomePage1(){
    
    System.out.println("Inside HomePage1");
}
@Test(priority=2)
    
    public void HomePage2(){
    
    System.out.println("Inside HomePage2");
}
}
