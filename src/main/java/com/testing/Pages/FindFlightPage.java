package com.testing.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "/html/body/form/div[1]/ul/li[7]/div/table[1]/tbody/tr[2]/td[1]/input")
	private WebElement depatureFlight;
	
	@FindBy(xpath = "/html/body/form/div[1]/ul/li[7]/div/table[2]/tbody/tr[2]/td[1]/input")
	private WebElement arrivalFlight;
	
	@FindBy(id = "reserveFlights")
	private WebElement submitFlight;
	
	@FindBy(name = "q53_address[addr_line1]")
	private WebElement addressLine1;
	
	@FindBy(name = "q53_address[addr_line2]")
	private WebElement addressLine2;
	
	@FindBy(name = "q53_address[city]")
	private WebElement billingCity;
	
	@FindBy(name = "q53_address[state]")
	private WebElement billingState;
	
	@FindBy(name = "q53_address[postal]")
	private WebElement billingPostalCode;
	
	@FindBy(name = "buyFlights")
	private WebElement billingSubmit;
	
	public FindFlightPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);
	}
	
	public void enterFlightAndClass()
	{
		this.depatureFlight.click();
		this.arrivalFlight.click();
	}
	
	public void submitFindFlight()
	{
		this.wait.until(ExpectedConditions.elementToBeClickable(submitFlight));
		this.submitFlight.click();
	}
	
	public void enterBillingDetails(String address1, String address2, String city, String state, String postelCode)
	{
		this.addressLine1.sendKeys(address1);
		this.addressLine2.sendKeys(address2);
		this.billingCity.sendKeys(city);
		this.billingState.sendKeys(state);
		this.billingPostalCode.sendKeys(postelCode);
	}
	
	public void goToFlightConfirmationPage()
	{
		this.wait.until(ExpectedConditions.elementToBeClickable(billingSubmit));
		this.billingSubmit.click();
	}
}
