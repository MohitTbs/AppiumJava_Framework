package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import base.Util;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class ProductDetailPage extends BaseClass {

	By addToCartButton;
	By removeButton;

	public ProductDetailPage() {

		if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {

			addToCartButton = By.xpath("//android.widget.TextView[@text='ADD TO CART']");
			removeButton = By.xpath("//android.widget.TextView[@text='REMOVE']");

		} else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {

		}
	}

	public void clickOnAddToCartBtn() {

//		getEl(addToCartButton).click();
		Util.scrollNclick(addToCartButton);
	}
	
	public boolean isRemoveBtnPresent() throws InterruptedException {
		Util.scrollTo(AppDriver.getCurrentDriver().findElement(removeButton));
		return AppDriver.getCurrentDriver().findElement(removeButton).isDisplayed();
	}

}
