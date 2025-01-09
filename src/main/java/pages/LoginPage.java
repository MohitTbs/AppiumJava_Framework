package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class LoginPage extends BaseClass{

	
	 	private By userName = AppiumBy.accessibilityId("test-Username");
	    private By Password = AppiumBy.accessibilityId("test-Password");
	    private By btnLogin = AppiumBy.accessibilityId("test-LOGIN");
	    private By userNameErrorText;
	    private By passwordErrorText;
	    private By credentialsErrorText;

	    public LoginPage() {
	    	
	        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
	        	
	            
	            userNameErrorText = By.xpath("//android.view.ViewGroup[@content-desc='Username-error-message']/android.widget.TextView");
	            passwordErrorText = By.xpath("//android.view.ViewGroup[@content-desc='Password-error-message']/android.widget.TextView");
	            credentialsErrorText = By.xpath("//android.view.ViewGroup[@content-desc='generic-error-message']/android.widget.TextView");
	            
	        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
	        	
	            
	            userNameErrorText = By.xpath("//XCUIElementTypeOther[@name='Username-error-message']/XCUIElementTypeStaticText");
	            passwordErrorText = By.xpath("//XCUIElementTypeOther[@name='Password-error-message']/XCUIElementTypeStaticText");
	            credentialsErrorText = By.xpath("//XCUIElementTypeOther[@name='generic-error-message']/XCUIElementTypeStaticText");
	        }
	    }


	    public void login(String username, String password) {
	    	waitNclick(userName);
	        waitNtype(userName, username);
	        getEl(Password).click();
	        getEl(Password).clear();
	        getEl(Password).sendKeys(password);
	        getEl(btnLogin).click();
	    }

	    public String getUserNameErrorText() {
	       return getText(userNameErrorText);
	    }

	    public String getPasswordErrorText() {
	        return getText(passwordErrorText);
	    }

	    public String getCredentialsErrorText() {
	        return getText(credentialsErrorText);
	    }

}
