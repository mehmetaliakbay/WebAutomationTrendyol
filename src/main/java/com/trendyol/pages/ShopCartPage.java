package com.trendyol.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * @author Mehmet Ali Akbay
 * This class will store all the locator and methods of Shop Cart Page
 */
public class ShopCartPage extends PageObject {
	
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div[2]/div[2]/section/section[1]/div[2]/div/div/div[2]/div[2]/div[3]/button")
	private WebElement trashBtn;
	
	@FindBy(how=How.CLASS_NAME, using="btn-remove")
	private WebElement removeBtn;
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div[2]/div[2]/section/section[2]/div[2]/div/div[1]/p/span")
	private WebElement emptyCart;
	
	public ShopCartPage(WebDriver driver) {
	        super(driver);
	    }
	
	
	public void deleteProductInCart() {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", trashBtn);
    	
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();", removeBtn);
	}
	
	public String getEmptyCartTxt() {
		return emptyCart.getAttribute("innerHTML");
	}

}
