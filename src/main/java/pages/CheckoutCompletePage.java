package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class CheckoutCompletePage extends BaseClass {
	
	By orderCompleteTitle;

	public CheckoutCompletePage() {

		if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			orderCompleteTitle = By.xpath("//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']");

		} else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {

		}
	}
	
	public boolean isOrderComplete() {
		waitForEl(orderCompleteTitle);
		return getEl(orderCompleteTitle).isDisplayed();
	}

}
