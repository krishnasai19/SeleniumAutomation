package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Base.BaseProject;
import Base.Common;
import utility.ExcelUtility;

public class SignUpPage extends Common{
	
	public By firstName = By.id("inputFirstName");
	public By lastName = By.id("inputLastName");
	public By email = By.id("inputEmail");
	public By countryCodeDropDown=By.xpath("//div[@class='selected-dial-code']");

	public By countryCode(String code) {
		return By.xpath("//li[@data-dial-code='"+code+"']");
	}
	public By phoneNo = By.id("inputPhone");
	public By companyName = By.id("inputCompanyName");
	public By address1 = By.id("inputAddress1");
	public By address2 = By.id("inputAddress2");
	public By city = By.id("inputCity");
	public By state = By.id("stateinput");
	public By postCode = By.id("inputPostcode");
	public By country = By.id("inputCountry");
	public By whatsApp = By.id("customfield2");
	public By password = By.id("inputNewPassword1");
	public By confirmPassword = By.id("inputNewPassword2");
	
	
	public boolean verifySignUp() throws Exception {
		ExcelUtility util = new ExcelUtility(System.getProperty("user.dir")+prop.getProperty("excelFilePath"), 0);
		List<HashMap<String, String>> data = util.readExcelSheetData();
		HomePage home = new HomePage();
		String mwind = driver.getWindowHandle();
		driver.findElement(home.signUpBtn).click();
		swithcToChildWindow(mwind);
		driver.findElement(firstName).sendKeys(data.get(0).get("FirstName"));
		driver.findElement(lastName).sendKeys(data.get(0).get("LastName"));
		driver.findElement(email).sendKeys(data.get(0).get("Email"));
		//driver.findElement(countryCodeDropDown).click();
		//driver.findElement(countryCode(data.get(0).get("CountryCode"))).click();
		driver.findElement(phoneNo).sendKeys(data.get(0).get("PhoneNo"));
		driver.findElement(companyName).sendKeys(data.get(0).get("CompanyName"));
		driver.findElement(address1).sendKeys(data.get(0).get("StreetAddress1"));
		driver.findElement(address2).sendKeys(data.get(0).get("StreetAddress2"));
		driver.findElement(city).sendKeys(data.get(0).get("City"));
		driver.findElement(state).sendKeys(data.get(0).get("State"));
		new Select(driver.findElement(country)).selectByVisibleText(data.get(0).get("Country"));
		driver.findElement(postCode).sendKeys(data.get(0).get("PostCode"));
		driver.findElement(whatsApp).sendKeys(data.get(0).get("WhatsAppNo"));
		driver.findElement(password).sendKeys(data.get(0).get("Password"));
		driver.findElement(confirmPassword).sendKeys(data.get(0).get("ConfirmPassword"));
		return true;
	}

}
