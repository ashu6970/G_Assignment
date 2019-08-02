package com.go.common;


import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.go.utils.Constants;




public class BasePage {
	
	public  WebDriver driver;
	public WebElement webElement;
	public WebDriverWait wait;
	
	public WebDriver getDriver() {
        return driver;
    }
	
	/*
	 * Perform to launch the browser
	 */
	public void  init(String browserType)
	{
		if(browserType.equals("Chrome") || driver==null)
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		this.getUrl(Constants.HOME_URL);
	}
	
	/*
	 * To get the website URL
	 */
	   public void getUrl(String url)
	   {
		  driver.get(url);
	   }
	
	 /*
	  * Perform the click operation on the any element
	  */
	 public void click (By elementLocation) {
	       
		 driver.findElement(elementLocation).click();
	    }
	
	 /*
	  * Perform click using javaScript method
	  */
	 public void javaScriptClick(By locator ) {
		
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", locator);
				
		}
	 
	 /*
	  * This method is used Enter the Credential in the text file.
	  */
	 public void writeText (String elementLocation, String text) {
	        driver.findElement(By.xpath(elementLocation)).sendKeys(text);
	    }
  
	 /*
	  * Read the text on the web page
	  */
	    public String textRead (By loc) {
	        return driver.findElement(loc).getText();
	    }
	    
	   /*
	    *  It returns true/ false if element is present or not
	   */
		public boolean isElementPresent(By locator)
			{
				try
				{
			        driver.findElement(locator);
			        return true;
			        
			    }
				catch (NoSuchElementException e) {
			        return false;
			    }
			}
		
		/*
		 * It perform to close the browser
		 */
		public void quitBrowser()
		{
			driver.quit();
		}
		
		/*
		 * Implicit wait method for specific amount of wait to check the visiblity of the element
		 */
		public void waitForElement(String item) {
		    WebDriverWait wait = new WebDriverWait(driver,30);
		   WebElement w= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(item))); 
		   if(w.isDisplayed())
		   {
			   System.out.println("Display");
		   }
		   else
		   {
			   System.out.println("Not displayed");
		   }
		}
		
		/*
		 * Implicit wait method for check element to be clickable or not
		 */
		public void waitAndClick(String item) {
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id(item))).click();;   
		}
		
		/*
		 * Implicit wait method for  check the visiblity of the element
		 */
		public void waitUntilelementVisible(By item) {
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(item));   
		}
		
		/*
		 * Wait for check the visiblity of the iframe.
		 */
		public void waitForFrame(By item, int seconds) {
		    WebDriverWait wait = new WebDriverWait(driver,seconds);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(item));
		    
		}
		
		/**
		 * Gets the element if visible using xpath.
		 *
		 * @param locator       the xpath
		 * @param waitSupplied the wait supplied
		 * @return the element if visible using xpath
		 */
		
		public boolean CheckElementIfVisible(By locator) {
			try {
				
				//waitUntilelementVisible(locator);
				WebElement el = driver.findElement(locator);
				return el.isDisplayed();
			} catch (Exception e) {
				return false;
			}
			// return true;
		}
		
		/**
		 * Verify.
		 *
		 * @param actual     the actual
		 * @param expected   the expected
		 * @param descripton the descripton
		 */
		public void verify(boolean actual, boolean expected, String descripton) {
			Assert.assertEquals(actual, expected, descripton);

		}
		
		/**
		 * Switch to frame.
		 *
		 * @param frameIdorName the frame idor name
		 */
		public  void switchToFrame() {
			
			int size1= driver.findElements(By.tagName("iframe")).size();
			waitForLoadingPop();
			for(int i=0; i<size1;i++)
			{
				if(i==0)
				{
					driver.switchTo().frame(i);
				}
				
			}
			//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='snap-midtrans']")));
				
			}			
		
		/*
		 * This method perform certain amount of wait.
		 */
		public void waitForLoadingPop()
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public void switchTodafault()
		{
			driver.switchTo().defaultContent();
		}
		
}	    



