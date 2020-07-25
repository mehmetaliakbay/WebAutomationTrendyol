package com.trendyol.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Mehmet Ali Akbay
 * This class will store all the locator and methods of search detail page
 */

public class SearchDetailPage extends PageObject{
	
	@FindBy(how=How.XPATH,using="//*[@id=\"search-app\"]/div/div/div[2]//img")
	private WebElement product;
	
    public SearchDetailPage(WebDriver driver) {
        super(driver);
    }
    
    public void clickRandomProduct() {
    	product.click();
    }

}
