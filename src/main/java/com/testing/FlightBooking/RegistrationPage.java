package com.testing.FlightBooking;

import java.time.Clock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "firstName")
	private WebElement firstNameElement;
	
	@FindBy(name = "lastName")
	private WebElement lastNameElement;
	
	@FindBy(name = "phone")
	private WebElement phoneElement;
	
	@FindBy(id = "userName")
	private WebElement emailElement;
	
	@FindBy(name = "address1")
	private WebElement addressElement;
	
	@FindBy(name = "city")
	private WebElement cityElement;
	
	@FindBy(name = "state")
	private WebElement stateElement;
	
	@FindBy(name = "postalCode")
	private WebElement postalCodeElement;
	
	@FindBy(name = "country")
	private WebElement countryElement;
	
	@FindBy(name = "email")
	private WebElement userNameElement;
	
	@FindBy(name = "password")
	private WebElement passwordElement;
	
	@FindBy(name = "confirmPassoword")
	private WebElement confirmPasswordElement;
	
	@FindBy(name = "register")
	private WebElement submitButtonElement;
	
	public void goTo()
	{
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		this.wait.until(ExpectedConditions.visibilityOfAllElements(this.firstNameElement));
		
	}
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);
	}
	
	public void contactInformation(String firstName,String lastName,String phoneNumber,String userEmail)
	{
		this.firstNameElement.sendKeys(firstName);
		this.lastNameElement.sendKeys(lastName);
		this.phoneElement.sendKeys(phoneNumber);
		this.emailElement.sendKeys(userEmail);
	}
	
	public void mailingInformation(String address, String city,String state, String postalCode, String country)
	{
		this.addressElement.sendKeys(address);
		this.cityElement.sendKeys(city);
		this.stateElement.sendKeys(state);
		this.postalCodeElement.sendKeys(postalCode);
		this.countryElement.sendKeys(country);
	}
	
	public void userInformation(String userName, String password)
	{
		this.userNameElement.sendKeys(userName);
		this.passwordElement.sendKeys(password);
		this.confirmPasswordElement.sendKeys(password);
	}
	
	public void submit()
	{
		this.submitButtonElement.click();
	}
}





