package com.epam.test;

import com.epam.browserfactory.WebDriverFactory;
import com.epam.page.Page;
import com.epam.page.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchResultsPageTest  {

    SearchResultsPage searchResultsPage;
    WebDriver driver;
    @BeforeClass
    public void setSearchResultsPage() {
        driver=new WebDriverFactory().createWebDriver("chrome");
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void testCalculatorUrl() {
        Assert.assertEquals(searchResultsPage.launchSearchResults().searchCalculatorUrl(), "Google Cloud Pricing Calculator");
    }
}
