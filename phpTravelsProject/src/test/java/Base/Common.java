package Base;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.HomePage;

public class Common extends BaseProject{
	
	public boolean waitForVisible(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Failed to find the visibility of element: "+locator);
		}
		return driver.findElement(locator).isDisplayed();
	}
	
	public void swithcToChildWindow(String mwindID) {
		Set<String> winds = driver.getWindowHandles();
		String childWindID = null;
		for (String wind : winds) {
			if(!wind.equals(mwindID)) {
				childWindID = wind;
			}
		}
		
		driver.switchTo().window(childWindID);
	}

}
