package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import base.Util;
import pages.DrawingPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class DrawingTest extends BaseTest{

	private LoginPage loginPage;
	private ProductsPage productsPage;
	private MenuPage menuPage;
	private DrawingPage drawingPage;

	
	@Test
	public void test_Drawing() throws InterruptedException {
		loginPage = new LoginPage();
		productsPage = new ProductsPage();
		loginPage.login("standard_user", "secret_sauce");
		productsPage.clickOnMenuBtn();
//		Thread.sleep(2000);
		menuPage = new MenuPage();
		menuPage.clickOnDrawingBtn();
		Thread.sleep(2000);
		drawingPage = new DrawingPage();
		Util.Drawing(drawingPage.getSignaturePadElement());
		Thread.sleep(5000);
		
	}
}
