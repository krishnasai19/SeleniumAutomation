package pages;

import org.openqa.selenium.By;

import Base.BaseProject;

public class HomePage extends BaseProject{
	
	public By loginBtn = By.xpath("//strong[text()='Login']");
	public By signUpBtn = By.xpath("//strong[text()='Signup']");
	public By demoBtn = By.xpath("//li/a[text()='Demo']");

}
