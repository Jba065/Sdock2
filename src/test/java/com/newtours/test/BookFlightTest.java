package com.newtours.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.pages.BillingAddressPage;
import com.newtours.pages.FindFlightsPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDestinationSelectorPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.FlightItineryPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;

import tests.BaseTest;

public class BookFlightTest extends BaseTest{
	
	//private WebDriver driver;
	private String noOfPassengers;
	private String expectedPrice;
	
	
	@BeforeTest
	@Parameters({"noOfPassengers","expectedPrice"})
	public void setupParameters(String noOfPassengers, String expectedPrice) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jebaraj Isaac J\\eclipse-workspace\\sdock2\\src\\test\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.noOfPassengers = noOfPassengers; 
		this.expectedPrice = expectedPrice;
		 
	}
	
	@Test
	public void registrationPage() {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTo();
		registrationPage.enterUserDetails("selenium", "docker");
		registrationPage.enterUserCredentials("selenium", "docker");
		registrationPage.submit();
	}
	
	@Test(dependsOnMethods = "registrationPage")
	public void registrationConfirmationPage() {
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.gotoFlightDetailsPage();
	}
	
	@Test(dependsOnMethods = "registrationConfirmationPage")
	public void flightDetailsPage() {
		FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
		System.out.println(noOfPassengers);
		flightDetailsPage.selectPassengers(noOfPassengers);		
	}
	
	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage() {
		FindFlightsPage findFlightPage = new FindFlightsPage(driver);
		findFlightPage.submitFindFlightsPage();
		findFlightPage.goToFlightConfirmationPage();
	}
	
	@Test(dependsOnMethods = "findFlightPage")
	public void flightConfirmationPage() {
		/*
		 * FlightConfirmationPage flightConfirmationPage = new
		 * FlightConfirmationPage(driver); flightConfirmationPage.printConfirmation();
		 */
	}
	
	@Test(dependsOnMethods = "flightConfirmationPage")
	public void flightDestnSelectorPage() {
		FlightDestinationSelectorPage flightDestinationSelectorPage = new FlightDestinationSelectorPage(driver);
		flightDestinationSelectorPage.clickDesiredFlightLocation();
		flightDestinationSelectorPage.continueToNextPage();
	}
	
	@Test(dependsOnMethods = "flightDestnSelectorPage")
	public void billingAddressPage() {
		BillingAddressPage billingAddressPage = new BillingAddressPage(driver);
		billingAddressPage.fillAndSubmitBillingAddress();
		
	}
	
	@Test(dependsOnMethods = "billingAddressPage")
	public void validatePrice() {
		FlightItineryPage flightItineryPage = new FlightItineryPage(driver);
		String actualPrice = flightItineryPage.printConfirmation();
		Assert.assertEquals(actualPrice, expectedPrice);
	}
}
