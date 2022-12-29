package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Search Functionality")
@Feature("Verify Search Functionality")
public class SearchTest extends BaseTest {

    @Test
    @Description("Test Case #1, verify Search Feature")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, verify Search Feature")
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();

        Assert.assertTrue(size > 0);
    }

}
