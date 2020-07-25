package com.trendyol.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Mehmet Ali Akbay
 * This class will store all the locator and methods of home page
 */

public class HomePage extends PageObject{

	@FindBy(id = "logo")
	@CacheLookup
	private WebElement logo;
    
	@FindBy(how=How.XPATH, using="//*[@id=\"accountBtn\"]")
	@CacheLookup
	private WebElement outerLoginButton;
	
	@FindBy(how=How.CLASS_NAME, using="login")
	@CacheLookup
	private WebElement innerLoginButton;
	
    @FindBy(how=How.XPATH, using="//*[text()='Hesabım']")
    private WebElement myAccountEmailText;
    
    @FindBy(how=How.ID, using="accountBtn")
    private WebElement myAccountButton;
	
	

    
    public HomePage(WebDriver driver){
    	
        super(driver);
    }

    public String verifyHomePageTitle() {
    	return logo.getAttribute("title");
    }
    
    public LoginPage login() throws InterruptedException{
    	Thread.sleep(2000);
    	new Actions(driver).moveToElement(outerLoginButton).click().build().perform();
    	  
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", innerLoginButton);
        return new LoginPage(driver);
    }

    /**
     * @return if user logged in return email text
     */
    public Boolean confirmationAccount() {
    	 new Actions(driver).moveToElement(myAccountButton).build().perform();
    	
    	return myAccountEmailText.isDisplayed();
    }
}
