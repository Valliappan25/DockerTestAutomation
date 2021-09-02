package com.testing.Tests;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.BaseTest.BaseTest;
import com.testing.Pages.FindFlightPage;
import com.testing.Pages.FlightConfirmationPage;
import com.testing.Pages.FlightDetailsPage;
import com.testing.Pages.RegistrationConfirmationPage;
import com.testing.Pages.RegistrationPage;

public class BookFlightTest extends BaseTest {
	String firstName;
	String lastName;
	String mobileNumber;
	String email;
	String address;
	String city;
	String state;
	String postalCode;
	String country;
	String password;
	//private String tripType;
	private String numberOfPassenger;
	private String departPlace;
	private String departMonth;
	private String departDate;
	private String arrivalPlace;
	private String arrivalMonth;
	private String arrivalDate;
	private String classType;
	private String airline;
	private String billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private String billingState;
	private String billingPostalCode;
	private String expectedPrice;
	
	
	@Test
	@Parameters({"firstName","lastName","mobileNumber","email","address",
		"city","state","postalCode","country","password","numberOfPassenger","departPlace",
		"departMonth","departDate","arrivalPlace","arrivalMonth","arrivalDate","classType","airline",
		"billingAddress1","billingAddress2","billingCity","billingState","billingPostalCode",
		"expectedPrice"})
	public void registrationPage(String firstName, String lastName, 
			String mobileNumber, String email, String address,String city,String state, 
			String postalCode, String country, String password,String numberOfPassenger, 
			String departPlace, String departMonth, String departDate, 
			String arrivalPlace,String arrivalMonth, String arrivalDate, String classType, 
			String airline, String billingAddress1, String billingAddress2, String billingCity, 
			String billingState,String billingPostalCode,String expectedPrice)
	{
		RegistrationPage register = new RegistrationPage(driver);
		
		this.expectedPrice = expectedPrice;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.password = password;
		//this.tripType = tripType;
		this.numberOfPassenger = numberOfPassenger;
		this.departPlace = departPlace;
		this.departMonth = departMonth;
		this.departDate = departDate;
		this.arrivalPlace = arrivalPlace;
		this.arrivalMonth = arrivalMonth;
		this.arrivalDate = arrivalDate;
		this.classType = classType;
		this.airline = airline;
		this.billingAddress1 = billingAddress1;
		this.billingAddress2 = billingAddress2;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingPostalCode = billingPostalCode;
		register.goTo();
		register.contactInformation(firstName,lastName,mobileNumber,email);
		register.mailingInformation(address,city,state,postalCode,country);
		register.userInformation(email,password);
		register.submit();
	}
	@Test(dependsOnMethods = "registrationPage")
	public void registrationConfirmationPage()
	{
		RegistrationConfirmationPage registerConfirmation = new RegistrationConfirmationPage(driver);
		
		registerConfirmation.goToFlightDetailsPage();
	}
	@Test(dependsOnMethods = "registrationConfirmationPage")
	public void flightDetailsPage()
	{
		FlightDetailsPage flightDetails = new FlightDetailsPage(driver);
		flightDetails.fillFlightDetails("oneway",numberOfPassenger,departPlace,departMonth,departDate,
				arrivalPlace,arrivalMonth,arrivalDate);
		flightDetails.airlinePreference(classType,airline);
		flightDetails.goFindFlightsPage();
	}
	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage()
	{
		FindFlightPage findFlight = new FindFlightPage(driver);
		findFlight.enterFlightAndClass();
		findFlight.submitFindFlight();
		findFlight.enterBillingDetails(billingAddress1,billingAddress2,billingCity,billingState
				,billingPostalCode);
		findFlight.goToFlightConfirmationPage();
	}
	@Test(dependsOnMethods = "findFlightPage")
	public void flightConfirmationPage()
	{
		FlightConfirmationPage flightConfirmation = new FlightConfirmationPage(driver);
		String actualPrice = flightConfirmation.printConfirmation();
		Assert.assertEquals(actualPrice, expectedPrice);
	}	
}
