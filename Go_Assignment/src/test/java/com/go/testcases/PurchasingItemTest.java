package com.go.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.go.common.BasePage;
import com.go.utils.Constants;


public class PurchasingItemTest extends BasePage{

	
	@BeforeMethod(description="Verify the common flow between the both testcase uptp card selection.")
	 public void commonPayementFlow( ){
		init(Constants.BROWSER_TYPE);
		verify(isElementPresent(Constants.BUYNOW), Constants.ASSERT_STATUS, "Homepage is not visible");
		click(Constants.BUYNOW);
		verify(CheckElementIfVisible(Constants.CHECKOUT), Constants.ASSERT_STATUS, "Not Visible" );
		click(Constants.CHECKOUT);
		waitForFrame(Constants.FRAMEID1,10);
		switchToFrame();
		verify(isElementPresent(Constants.CONTINUE_BUTTON),Constants.ASSERT_STATUS, "Payment method is not opening");
		click(Constants.CONTINUE_BUTTON);
		click(Constants.CHOOSE_CREDITCARD);
		verify(CheckElementIfVisible(Constants.PAYNOW_BUTTON), Constants.ASSERT_STATUS, "Credit card is not selected");		
	}
	
	
	@Test( priority =1,description = "Checkout flow for purchasing Pillow usingCredit Card as payment method.")
	public void purchasingPillowWithCorrectPaymentMethod() {

		writeText(Constants.ENTER_CARD_NUMBER, Constants.SUCCESS_CARD);
		writeText(Constants.ENTER_EXPIRYDATE, Constants.EXPIRY_DATE);
		writeText(Constants.ENTER_CCV, Constants.CVV_NUMBER);
		click(Constants.PAYNOW_BUTTON);
		waitForLoadingPop();
		waitForFrame(Constants.FRAMEID2,10);
		switchToFrame();
		writeText(Constants.ENTER_OTP, Constants.OTP);
		click(Constants.OK_BUTTON);
		waitForLoadingPop();
		switchTodafault();
		waitUntilelementVisible(Constants.THANKYOU);
		verify(isElementPresent(Constants.THANKYOU), Constants.ASSERT_STATUS, "Payment Succesfully Done");
		
		
		
	}
	
	@Test(priority=2,description = "Checkout flow for purchasing Pillow usingCredit Card as payment method.")
	public void purchasingPillowWithIncorrectPaymentMethod() throws InterruptedException {

		writeText(Constants.ENTER_CARD_NUMBER, Constants.FAILED_CARD);
		writeText(Constants.ENTER_EXPIRYDATE, Constants.EXPIRY_DATE);
		writeText(Constants.ENTER_CCV, Constants.CVV_NUMBER);
		click(Constants.PAYNOW_BUTTON);
		waitForLoadingPop();
		waitForFrame(Constants.FRAMEID2,10);
		switchToFrame();
		writeText(Constants.ENTER_OTP, Constants.OTP);
		click(Constants.OK_BUTTON);
		//verify(isElementPresent(Constants.RETRY), Constants.ASSERT_STATUS, "Payment decline");
	
	}
		
	@AfterMethod(description="Close the browser")
	public void closeBrowser()
	{
		quitBrowser();
	}
	}
	
	
	

