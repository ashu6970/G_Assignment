package com.go.utils;

import org.openqa.selenium.By;




public class Constants {
	
	/*
	 * @Card Credentials
	 */
	public static final String SUCCESS_CARD="4811111111111114";
	public static final String FAILED_CARD="4911111111111113";
	public static final String EXPIRY_DATE="02/20";
	public static final String CVV_NUMBER="123";
	public static final String OTP="112233";
	
	/*
	 * @ All the xpaths of the UI elements on the webpage
	 */
	public static final String HOME_URL="https://demo.midtrans.com/";
	public static final String BROWSER_TYPE="Chrome";
	public static final boolean ASSERT_STATUS=true;
//	public static final String BUYNOW ="//a[@class='btn buy']"; 
	public static final By CHECKOUT=By.xpath("//div[@class='cart-checkout']");
	public static final By CLOSE_BUTTON=By.xpath("//nav[@id='header']/a/span");
	public static final By BUYNOW =By.xpath("//a[@class='btn buy']");
	public static final By CONTINUE_BUTTON =By.xpath("//a[@href='#/select-payment']"); 
	public static final By CHOOSE_CREDITCARD=By.xpath("//a[@href='#/credit-card']");
	public static final String ENTER_CARD_NUMBER="//input[@name='cardnumber']";
	public static final String ENTER_EXPIRYDATE="//div[@class='input-group col-xs-7']/input";
	public static final String ENTER_CCV="//div[@class='input-group col-xs-5']/input";
	public static final By PAYNOW_BUTTON=By.xpath("//a[@href='#/']");
	public static final String ENTER_OTP="//input[@id='PaRes']";
	public static final By OK_BUTTON=By.xpath("//button[@name='ok']");
	public static final String TRANSACTION_FAILED="//div[@class='text-failed text-bold']/span";
	public static final String FRAME1 = "snap-midtrans";
	public static final By FRAMEID1 = By.xpath("//iframe[@id='snap-midtrans']");
	public static final By FRAMEID2 = By.xpath("//*[@id='application']/div[3]/div/div/div/iframe");
	public static final By THANKYOU=By.xpath("//div[@class='trans-status trans-success']/span[1]");
	public static final String THANKYOU_TEXT="Thank you for your purchase";
	public static final By RETRY=By.xpath("//a[@href='#/']");


}
