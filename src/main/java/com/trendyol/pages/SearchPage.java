package com.trendyol.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Mehmet Ali Akbay
 * This class will store all the locator and methods of search page
 */

public class SearchPage extends PageObject{
	
	@FindBy(how=How.CLASS_NAME,using="search-box")
	private WebElement searchBox;
	
	
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    
    public void enterSearchText(String searchText) {
    	searchBox.clear();
    	searchBox.sendKeys(searchText);
    	
    	searchBox.sendKeys(Keys.RETURN);
    	  	
    }

}
