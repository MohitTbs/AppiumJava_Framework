package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MenuPage extends BaseClass {

	By drawingBtn;

	public MenuPage() {

		if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {

			drawingBtn = By.xpath("//*[@text='DRAWING']");

		} else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {

		}

	}
	
	public void clickOnDrawingBtn() {
		waitNclick(drawingBtn);
		
	}
}
