package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;

import base.BaseClass;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class YourCartPage extends BaseClass{

	By productName;
	By productPrice;
	
	public YourCartPage() {
		
		if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			 productName = By.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]");
			 productPrice = By.xpath("//android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView");

		} else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {

		}
	}
	
	public String getProductName() {
		return getEl(productName).getDomAttribute("text");
		
	}
	
	public String getProductPrice() {
		return getEl(productPrice).getDomAttribute("text");
	}
}
