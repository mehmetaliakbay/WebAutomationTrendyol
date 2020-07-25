	package com.trendyol.testbase;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Mehmet Ali Akbay
 * This class create browser for testing
 */

public class TestBase {

	protected static WebDriver driver;
	public static Properties prop;

	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/trendyol"
					+ "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	  @BeforeClass
	  public static void initialization() {
		  String browserName = prop.getProperty("browser");
		  
		  if(browserName.equals("firefox")) {
			  System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");	
			  driver = new FirefoxDriver(); 
		  }else if(browserName.equals("firefox")) {
			  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");	
			  driver = new ChromeDriver();
		  }

		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("https://www.trendyol.com/");
		  
	  }
	  


//		@AfterMethod
//		public void tearDown(){
//			driver.quit();
//		}
		

}
