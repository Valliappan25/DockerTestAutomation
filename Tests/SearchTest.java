package com.SearchModule.Tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SerachModule.Pages.SearchPage;
import com.testing.BaseTest.BaseTest;

public class SearchTest extends BaseTest {

	String keyword;
	
	@Test
	@Parameters({"keyword"})
	public void searchKeyword(String keyword){
		SearchPage search = new SearchPage(driver);
		this.keyword = keyword;
		search.goTo();
		search.doSearch(keyword);
		search.goToVideos();
		int count = search.countOfVideos();
		Assert.assertTrue(count>0);
	}	
}
