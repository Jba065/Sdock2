package com.newtours.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightItineryPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(xpath = "//font[contains(text(),\"Flight Itinerary Page\")]")
	private WebElement flightItineryPageTitle;
	
	@FindBy(xpath = "//font[contains(text(),\"USD\")]")
	private List<WebElement> prices;
	
	public FlightItineryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		
	}
	
	public String printConfirmation() {
		this.wait.until(ExpectedConditions.visibilityOf(flightItineryPageTitle));
		System.out.println(prices.get(1).getText());
		return prices.get(1).getText();
	}
	
}
