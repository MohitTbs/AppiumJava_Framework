package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class YourCartTest extends BaseTest {

	private LoginPage loginPage;
	private ProductsPage productsPage;
	private YourCartPage yourCartPage;

	@Test
	public void test_verifyProductDetailInCart() throws InterruptedException {
		loginPage = new LoginPage();
		productsPage = new ProductsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		productsPage = new ProductsPage();
		List<String> prodDetail = productsPage.getDetailsOfSelectedProduct();
		Thread.sleep(2000);
		productsPage.clickOnTrolleyIcon();
		System.out.println(prodDetail);
		yourCartPage = new YourCartPage();
		Thread.sleep(2000);
		Assert.assertEquals(prodDetail.get(0), yourCartPage.getProductName());
		Assert.assertEquals(prodDetail.get(1), yourCartPage.getProductPrice());

	}
}
