package com.trendyol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * @author Mehmet Ali Akbay
 * This class will store all the locator and methods of login page
 */

public class LoginPage extends PageObject{
	
    @FindBy(how=How.XPATH,using="//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(how=How.XPATH,using="//*[@id=\"loginSubmit\"]")
    private WebElement loginButton;
    

    
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public HomePage enterEmailAndPassword(String myEmail, String myPassword){
    	
    	WebElement email;
    	try {
	    email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	    email.clear();
	    email.sendKeys(myEmail);
	
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		    email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		    email.clear();
		    email.sendKeys(myEmail);
		}


        this.password.clear();
        this.password.sendKeys(myPassword);

        
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginButton);
       
        return new HomePage(driver);
    }
    


}
