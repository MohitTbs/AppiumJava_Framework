package testcases;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class ProductListTest extends BaseTest{

	private LoginPage loginPage;
	private ProductsPage productsPage;
	private ProductDetailPage productDetailPage;
	
	@Test
	public void test_getCountOfAllProducts() throws InterruptedException {
		loginPage = new LoginPage();
		productsPage = new ProductsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		Set<WebElement> elements_list = productsPage.scrollToCountAllTheProducts();
		System.out.println(elements_list.size());
		Assert.assertTrue(elements_list.size() > 0);
	}
	
	@Test
	public void test_selectAProduct() throws InterruptedException {
		loginPage = new LoginPage();
		productsPage = new ProductsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		productsPage.selectAnItem("Sauce Labs Onesie");
		Thread.sleep(2000);
		productDetailPage = new ProductDetailPage();
		productDetailPage.clickOnAddToCartBtn();
		Thread.sleep(1000);
		Assert.assertTrue(productDetailPage.isRemoveBtnPresent()); 
		
	}
}
