package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DrawingPage extends BaseClass {

	By signaturePad;

	public DrawingPage() {

		if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {

			signaturePad = By.xpath("//android.view.View[@resource-id='signature-pad']/android.view.View");

		} else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {

		}

	}
	
	public WebElement getSignaturePadElement() {
		return getEl(signaturePad);
	}
}
