package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Base.BaseProject;
import pages.SignUpPage;

public class RegistrrationTest extends BaseProject{
  @Test(priority=2)
  public void verifySignUpTest() throws Exception {
	 test = extent.createTest("SignUpTest");
	  SignUpPage spage = new SignUpPage();
	  boolean result = spage.verifySignUp();
	  assertEquals(result, true, "Failed to validate the SignUp Page");
	  System.out.println("Successfully validated SignUp Page");
	 // extent.removeTest(test);
  }
}
