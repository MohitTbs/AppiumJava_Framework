package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import base.Util;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class CheckoutInfoPage extends BaseClass{
	
	By firstNameField;
	By lastNameField;
	By zipField;
	By continueBtn;

	
	public CheckoutInfoPage() {
		
		if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			
			firstNameField = By.xpath("//android.widget.EditText[@content-desc='test-First Name']");
			lastNameField = By.xpath("//android.widget.EditText[@content-desc='test-Last Name']");
			zipField = By.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']");
			continueBtn = By.xpath("//android.widget.TextView[@text='CONTINUE']");

		} else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {

		}
	}
	
	public void enterFisrtName(String fName) {
		waitNclick(firstNameField);
		getEl(firstNameField).sendKeys(fName);
		
	}
	
	public void enterLastName(String lName) {
		waitNclick(lastNameField);
		getEl(lastNameField).sendKeys(lName);
	}
	
	public void enterZip(String zip) {
		waitNclick(zipField);
		getEl(zipField).sendKeys(zip);
		Util.clickOnBackButton();
		
		
	}
	
	public void clickOnContinueBtn() {
		Util.scrollNclick(continueBtn);
	}
}
