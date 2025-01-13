package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutCompletePage;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class PurchaseAProductTest extends BaseTest{
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private YourCartPage yourCartPage;
	private CheckoutInfoPage checkoutInfoPage;
	private CheckoutOverviewPage checkoutOverviewPage;
	private CheckoutCompletePage checkoutCompletePage;

	@Test
	public void test_purchaseAProduct() throws InterruptedException {
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
		yourCartPage.clickOnCheckOutBtn();
		checkoutInfoPage = new CheckoutInfoPage();
		checkoutInfoPage.enterFisrtName("Hemant");
		checkoutInfoPage.enterLastName("Rajpurohit");
		checkoutInfoPage.enterZip("25541");
		checkoutInfoPage.clickOnContinueBtn();
		checkoutOverviewPage = new CheckoutOverviewPage();
		checkoutOverviewPage.clickOnFinishBtn();
		checkoutCompletePage = new CheckoutCompletePage();
		Assert.assertTrue(checkoutCompletePage.isOrderComplete());
		
//		Assert.assertEquals(prodDetail.get(0), yourCartPage.getProductName());
//		Assert.assertEquals(prodDetail.get(1), yourCartPage.getProductPrice());

	}
}
