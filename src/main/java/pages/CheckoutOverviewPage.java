package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import base.Util;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class CheckoutOverviewPage extends BaseClass {

	By finishBtn;
	By itemTotal;
	By tax;
	By total;

	public CheckoutOverviewPage() {

		if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			finishBtn = By.xpath("//android.widget.TextView[@text='FINISH']");
			itemTotal = By.xpath("//android.widget.TextView[contains(@text,'Item total:')]");
			tax = By.xpath("//android.widget.TextView[contains(@text,'Tax:')]");
			total = By.xpath("//android.widget.TextView[contains(@text,'Total:')]");

		} else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {

		}
	}

	public void clickOnFinishBtn() {
		Util.scrollNclick(finishBtn);
	}

	public String[] getTotalAmount() throws InterruptedException {
		
		String[] amountedString = new String[3];
		
		Util.scrollNclickWithRatio(itemTotal, 0.2);
		String totalAmountString = getEl(itemTotal).getDomAttribute("text");
		System.out.println(totalAmountString);
		amountedString[0] = retrieveAmountFromString(totalAmountString);
		Util.scrollNclickWithRatio(tax, 0.2);
		
		String taxString = getEl(tax).getDomAttribute("text");
		System.out.println(taxString);
		amountedString[1] = retrieveAmountFromString(taxString);
		Util.scrollNclickWithRatio(total, 0.2);
		
		String totalString = getEl(total).getDomAttribute("text");
		Util.captureScreenShotOf(getEl(total), "webelement");
		System.out.println(totalString);
		amountedString[2] = retrieveAmountFromString(totalString);
		
		return amountedString;

	}

	private String retrieveAmountFromString(String st) {
		return st.substring(st.indexOf("$") + 1);
	}

}
