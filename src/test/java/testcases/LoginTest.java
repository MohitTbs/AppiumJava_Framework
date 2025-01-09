package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {
	
	private LoginPage loginPage;
	private ProductsPage productsPage;

	@Test
	public void validLoginTest() throws InterruptedException {
		loginPage = new LoginPage();
		productsPage = new ProductsPage();
		loginPage.login("standard_user", "secret_sauce");
		// Assert.assertTrue(prodPage.waitForProductText());
		Thread.sleep(5000);
		Assert.assertTrue(productsPage.isHeadingVisible());
		
	}

}
