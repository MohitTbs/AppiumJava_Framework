package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class ProductsPage extends BaseClass {

	By pageHeading;

	public ProductsPage() {

		if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {

			pageHeading = By.xpath("//android.widget.TextView[@text='PRODUCTS']");

		} else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {

		}

	}

	public boolean isHeadingVisible() {
		WebElement ele = waitForEl(pageHeading);
		return ele.isDisplayed();
	}
}
