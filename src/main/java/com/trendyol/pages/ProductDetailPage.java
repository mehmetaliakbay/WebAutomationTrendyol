package com.trendyol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Mehmet Ali Akbay
 * This class will store all the locator and methods of product detail page
 */

public class ProductDetailPage extends PageObject{
	
	
	@FindBy(how=How.CLASS_NAME,using="add-to-bs-tx")
	private WebElement addToCartBtn;

	@FindBy(how=How.CLASS_NAME,using="prc-slg" )
	private WebElement productPriceTxt;
	
	@FindBy(how=How.CLASS_NAME, using="salePrice")
	private WebElement shopCartPriceTxt;
	
	@FindBy(how=How.CSS , using=".productInfoBox > p:nth-child(1) > span:nth-child(4)")
	private WebElement cartProductNumber;
	
	@FindBy(how=How.CLASS_NAME, using="goBasket")
	private WebElement goBasketBtn;
	
	
	
	   public ProductDetailPage(WebDriver driver) {
	        super(driver);
	    }
	   
	   private void hoverIconBasket() {
			WebDriverWait wait = new WebDriverWait(driver,30);
			   WebElement shopCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("basketPreviewcontent")));
			   new Actions(driver).moveToElement(shopCartBtn).build().perform();
		}
	   
	   
	   public void addToCartProduct() throws InterruptedException {
		   Thread.sleep(3000);
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", addToCartBtn);
	   }
	   
	   
	   public Boolean comparePrices() {
		   String productPrice = productPriceTxt.getText();
		   hoverIconBasket();
	
		   String cartPrice = shopCartPriceTxt.getText();
		   
		   return productPrice.equals(cartPrice);
	   }
	   
	  
	   public Boolean checkNumber() throws InterruptedException {
		   addToCartProduct();
		   hoverIconBasket();
		   return cartProductNumber.getText().equals("Adet: 2");
	   }

	   
	   public ShopCartPage redirectShopCartPage() {
		   hoverIconBasket();
		   goBasketBtn.click();
		   return new ShopCartPage(driver);
		   
	   }
	   
	
	   

}
