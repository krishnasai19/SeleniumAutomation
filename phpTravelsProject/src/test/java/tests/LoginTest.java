package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Base.BaseProject;
import pages.LoginPage;

public class LoginTest extends BaseProject{
  @Test(priority=1)
  public void verifyLogin() throws Exception {
	  //test=extent.createTest("loginTest");
	  LoginPage login = new LoginPage();
	  boolean result = login.verifyLogin();
	  assertEquals(result, false, "Failed to validate the Login Page");
	  System.out.println("Successfully validated Login Page");
	 // extent.removeTest(test);
  }
  
  
}
