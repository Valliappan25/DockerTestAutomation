package com.testing.FlightBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "/html/body/form/div[1]/ul/li[6]/div/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/b/font/input[1]")
	private WebElement rountTripElement;
	
	@FindBy(xpath = "/html/body/form/div[1]/ul/li[6]/div/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/b/font/input[2]")
	private WebElement oneWayElement;
	
	@FindBy(id = "passCount")
	private WebElement passengerCountElement;
	
	@FindBy(name = "fromPort")
	private WebElement departingFromElement;
	
	@FindBy(name = "fromMonth")
	private WebElement departingMonthElement;
	
	@FindBy(name = "fromDay")
	private WebElement departingDateElement;
	
	@FindBy(name = "toPort")
	private WebElement arrivingInElement;
	
	@FindBy(name = "toMonth")
	private WebElement returningMonthElement;
	
	@FindBy(name = "toDay")
	private WebElement returningDateElement;
	
	@FindBy(xpath = "/html/body/form/div[1]/ul/li[6]/div/table/tbody/tr[4]/td/table/tbody/tr[9]/td[2]/font/input")
	private WebElement economyClassElement;
	
	@FindBy(xpath = "/html/body/form/div[1]/ul/li[6]/div/table/tbody/tr[4]/td/table/tbody/tr[9]/td[2]/font/font/input[1]")
	private WebElement businessClassElement;
	
	@FindBy(xpath = "/html/body/form/div[1]/ul/li[6]/div/table/tbody/tr[4]/td/table/tbody/tr[9]/td[2]/font/font/input[2]")
	private WebElement firstClassElement;
	
	@FindBy(name = "ariline")
	private WebElement airlineElement;
	
	@FindBy(id = "findFlights")
	private WebElement continueButtonElement;
	
	public FlightDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		this .wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);
	}
	
	public void fillFlightDetails(String tripType, String passengerCount, String departingPlace,
			String departingMonth, String departingDay, String arrivingPlace, String arrivingMonth,
			String arrivingDate) {
		this.wait.until(ExpectedConditions.visibilityOf(passengerCountElement));
		
		if(tripType.equalsIgnoreCase("roundtrip"))
			this.rountTripElement.sendKeys(tripType);
		else
			this.oneWayElement.sendKeys(tripType);
		Select passCount = new Select(passengerCountElement);
		passCount.selectByVisibleText(passengerCount);
		Select selectDeparture = new Select(departingFromElement);
		selectDeparture.deselectByVisibleText(departingPlace);
		Select departMonth = new Select(departingMonthElement);
		departMonth.selectByVisibleText(departingMonth);
		Select departDate = new Select(departingDateElement);
		departDate.selectByVisibleText(departingDay);
		Select arrivalPlace = new Select(arrivingInElement);
		arrivalPlace.selectByVisibleText(arrivingPlace);
		Select arriveMonth = new Select(returningMonthElement);
		arriveMonth.selectByVisibleText(arrivingMonth);
		Select arriveDate = new Select(returningDateElement);
		arriveDate.deselectByVisibleText(arrivingDate);
		
	}
	public void airlinePreference(String classType, String airline)
	{
		if(classType.equalsIgnoreCase("business"))
			this.businessClassElement.sendKeys(classType);
		else if (classType.equalsIgnoreCase("first"))
			this.firstClassElement.sendKeys(classType);
		else
			this.economyClassElement.sendKeys(classType);
		
		Select airlineSelect = new Select(airlineElement);
		airlineSelect.selectByVisibleText(airline);
	}
	
	public void continueButton()
	{
		this.continueButtonElement.click();
	}
	
}
