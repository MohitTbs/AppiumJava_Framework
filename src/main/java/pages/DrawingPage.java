package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.google.common.collect.ImmutableList;

import base.BaseClass;
import base.Util;
import driver.AppDriver;
import io.appium.java_client.AppiumDriver;
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
		waitForEl(signaturePad);
		return getEl(signaturePad);
	}
	
	public void Drawing(WebElement drawPanel) {

		Point location = drawPanel.getLocation();
		Dimension size = drawPanel.getSize();

		// The same way, try to identify the Points for horigental drawing
		swipe(new Point(location.x+10,location.y + size.getHeight()/2), new Point(location.x + size.getWidth(),location.y + size.getHeight()/2), Duration.ofMillis(500) );
	}
	
	protected static void swipe(Point start, Point end, Duration duration) {

		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(input, 0);
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		/*
		 * if (isAndroid) { duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR); }
		 * else { swipe.addAction(new Pause(input, duration)); duration = Duration.ZERO;
		 * }
		 */
		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		((AppiumDriver) AppDriver.getCurrentDriver()).perform(ImmutableList.of(swipe));
	}
}
