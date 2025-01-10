package pages;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import base.Util;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class ProductsPage extends BaseClass {

	By pageHeading;
	By productsList;
	By productTitles;
	By productDetails;
	By productName;
	By productPrice;
	By addToCartButton;
	By trolleyIcon;
	

	public ProductsPage() {

		if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {

			pageHeading = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
			productsList = By.xpath("//android.view.ViewGroup[@content-desc='test-Item']");
			productTitles = By.xpath("//android.widget.TextView[@content-desc='test-Item title']");
			productDetails = By.xpath("//android.view.ViewGroup[@content-desc='test-Item']");
			productName = By.xpath("//android.widget.TextView[@content-desc='test-Item title']");
			productPrice = By.xpath("//android.widget.TextView[@content-desc='test-Price']");
			addToCartButton = By.xpath("//android.widget.TextView[@text='ADD TO CART']");
			trolleyIcon = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']");

		} else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {

		}

	}

	public boolean isHeadingVisible() {
		WebElement ele = waitForEl(pageHeading);
		return ele.isDisplayed();
	}

	public Set<WebElement> scrollToCountAllTheProducts() throws InterruptedException {

		Set<WebElement> count = Util.getItems(productsList);
		return count;
	}

	public void selectAnItem(String productName) throws InterruptedException {
		Util.scrollNclick(productTitles, "text", productName);
	}

	public List<String> getDetailsOfSelectedProduct() throws InterruptedException {
		
		String pName = getEl(productName).getDomAttribute("text");
		String pPrice = getEl(productPrice).getDomAttribute("text");
		getEl(addToCartButton).click();
		return Arrays.asList(pName, pPrice);
		
	}
	
	public void clickOnTrolleyIcon() {
		
		getEl(trolleyIcon).click();
	}

}
