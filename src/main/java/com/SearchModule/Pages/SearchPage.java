package com.SearchModule.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "q")
	private WebElement searchText;
	
	@FindBy(id = "search_button_homepage")
	private WebElement searchButton;
	
	@FindBy(xpath = "//*[@id=\"duckbar_static\"]/li[3]/a")
	private WebElement videoLink;
	
	@FindBy(className = "tile--vid")
	private List<WebElement> allVideoCount;
	
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);
	}
	
	public void goTo()
	{
		this.driver.get("https://duckduckgo.com/");
	}
	
	public void doSearch(String keyword) {
		this.wait.until(ExpectedConditions.visibilityOf(searchText));
		this.searchText.sendKeys(keyword);
		this.searchButton.click();
	}
	public void goToVideos() {
	this.wait.until(ExpectedConditions.visibilityOf(videoLink));
	this.videoLink.click();
	}
	
	public int countOfVideos()
	{
		By by = By.className("tile--vid");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		System.out.println(this.allVideoCount.size());
		int count = this.allVideoCount.size();
		
		return count;
	}
}
