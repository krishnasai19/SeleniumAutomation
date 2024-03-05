package pages;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BaseProject;
import Base.Common;

public class LoginPage extends Common{
	
	public By email = By.id("inputEmail");
	public By pwd = By.id("inputPassword");
	public By alertMsg = By.xpath("//div[@class='alert alert-danger']");
	public By captchaFrame = By.xpath("//iframe[@title='reCAPTCHA']");
	public By captchaCheckbox = By.xpath("//div[@class='recaptcha-checkbox-border']");
	public By signInBtn = By.id("login");
	
	public boolean verifyLogin() throws Exception {
		HomePage home = new HomePage();
		String mainWindID = driver.getWindowHandle();
		driver.findElement(home.loginBtn).click();
		swithcToChildWindow(mainWindID);
		driver.findElement(email).sendKeys(prop.getProperty("username"));
		driver.findElement(pwd).sendKeys(prop.getProperty("password"));
		driver.switchTo().frame(driver.findElement(captchaFrame));
		driver.findElement(captchaCheckbox).click();
		driver.switchTo().defaultContent();
		driver.findElement(signInBtn).click();
		waitForVisible(alertMsg);
		String text = driver.findElement(alertMsg).getText();
		return text.contains("Please complete the captcha");
		
	}

}
