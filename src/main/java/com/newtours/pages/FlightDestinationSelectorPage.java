package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDestinationSelectorPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id="input_50_0_0")
	private WebElement firstRadioBtn;
	
	@FindBy(name="reserveFlights")
	private WebElement continueBtn;
	
	public FlightDestinationSelectorPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void clickDesiredFlightLocation() {
		this.wait.until(ExpectedConditions.visibilityOf(firstRadioBtn));
		firstRadioBtn.click();
	}
	
	public void continueToNextPage() {
		this.wait.until(ExpectedConditions.visibilityOf(continueBtn));
		continueBtn.click();
	}
	
}
