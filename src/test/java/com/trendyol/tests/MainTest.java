package com.trendyol.tests;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.trendyol.pages.HomePage;
import com.trendyol.pages.LoginPage;
import com.trendyol.pages.ProductDetailPage;
import com.trendyol.pages.SearchDetailPage;
import com.trendyol.pages.SearchPage;
import com.trendyol.pages.ShopCartPage;
import com.trendyol.testbase.TestBase;

/**
 * @author Mehmet Ali Akbay
 * Main test class
 */

public class MainTest extends TestBase{
	private HomePage homePage;
	private LoginPage loginPage;
	private SearchPage searchPage;
	private SearchDetailPage searchDetailPage;
	private ProductDetailPage productDetailPage;
	private ShopCartPage shopCartPage;
	
	
	/**
	 * Check home page open
	 * @throws InterruptedException
	 */
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		driver.get("https://www.trendyol.com/");
		 homePage = new HomePage(driver);
		 
		// Check if homepage open or not
		String homePageTitle = homePage.verifyHomePageTitle();
		 assertEquals("trendyol", homePageTitle);
		 
		
	
	}
	
	/**
	 * Check User if login or not
	 * @throws InterruptedException 
	 */
	@Test(priority=2)
	public void verifyUserLoginTest() throws InterruptedException {
		 loginPage = homePage.login();
		 homePage = loginPage.enterEmailAndPassword(prop.getProperty("username"), prop.getProperty("password"));
		 Thread.sleep(7000);
		 
		 Assert.assertTrue(homePage.confirmationAccount());
		
	}
	
	/**
	 * Check User if login or not
	 * @throws InterruptedException 
	 */
	@Test(priority=3)
	public void searchTest() throws InterruptedException {
		searchPage = new SearchPage(driver);
		searchPage.enterSearchText("bilgisayar");
		
	}

	/**
	 * Click random product in Search Detail Page
	 */
	@Test(priority=4)
	public void clickRandomProductTest() {
		 searchDetailPage = new SearchDetailPage(driver);
		searchDetailPage.clickRandomProduct();
		
	}
	
	/**
	 * Add to cart the product which selected
	 * @throws InterruptedException 
	 */
	@Test(priority=5)
	public void addToCartProductTest() throws InterruptedException {
		 productDetailPage = new ProductDetailPage(driver);
		 productDetailPage.addToCartProduct();
		
	}	
	
	/**
	 * Compare product price in product detail page and 
	 * product price in cart
	 */
	@Test(priority=6)
	public void checkProductPriceAndCartPrice() {
		Assert.assertTrue(productDetailPage.comparePrices());
		 
		
	}
	
	
	/**
	 * again add the cart the product and check if number of 
	 * product 2 or not
	 * @throws InterruptedException 
	 */
	@Test(priority=7)
	public void addToCartNumberTest() throws InterruptedException {
		 Assert.assertTrue(productDetailPage.checkNumber());
		
	}
	
	
	/**
	 * product in cart delete and check if delete or not
	 * @throws InterruptedException 
	 */
	@Test(priority=8)
	public void deleteProductInCartTest() throws InterruptedException {
		shopCartPage = productDetailPage.redirectShopCartPage();
		shopCartPage.deleteProductInCart();
		Assert.assertTrue(shopCartPage.getEmptyCartTxt().equals("Sepetinizde ürün bulunmamaktadýr."));
	}


}
