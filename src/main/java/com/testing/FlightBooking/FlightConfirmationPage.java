package com.testing.FlightBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "/html/body/form/div[1]/ul/li[9]/div/table/tbody/tr[4]/td/form/table/tbody/tr[1]/td[1]/font")
	private WebElement confirmationPageHeader;
	
	@FindBy(xpath = "/html/body/form/div[1]/ul/li[9]/div/table/tbody/tr[4]/td/form/table/tbody/tr[3]/td[2]/font")
	private WebElement totalPrice;
	
	public FlightConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);
	}
	
	public void printConfirmation()
	{
		this.wait.until(ExpectedConditions.visibilityOfAllElements(confirmationPageHeader));
		System.out.println(this.confirmationPageHeader.getText());
		System.out.println(this.totalPrice.getText());
	}
}
