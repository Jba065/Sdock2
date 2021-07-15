package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingAddressPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id="input_53_addr_line1")
	private WebElement addressLine1;
	
	@FindBy(id="input_53_addr_line2")
	private WebElement addressLine2;
	
	@FindBy(id="input_53_city")
	private WebElement city;
	
	@FindBy(id="input_53_postal")
	private WebElement postalCode;
	
	@FindBy(name="buyFlights")
	private WebElement buyFlights;
	
	
	
	
	public BillingAddressPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void fillAndSubmitBillingAddress() {
		addressLine1.sendKeys("addressLine1");
		addressLine2.sendKeys("line 2");
		city.sendKeys("city value");
		postalCode.sendKeys("1234235");
		buyFlights.click();
	}
	
	
}
