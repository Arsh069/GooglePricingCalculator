package com.epam.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleCloudPage extends Page{

    @FindBy(className = "YSM5S")
    private WebElement searchIcon;

    @FindBy(id = "i4")
    private WebElement inputField;



    public GoogleCloudPage(WebDriver driver){
        super(driver);
    }

    public void launchGoogleCloudPage(){
       getDriver().get("https://cloud.google.com/");
    }


    public boolean clickSearch(){
        launchGoogleCloudPage();
        searchIcon.click();
        return searchIcon.isEnabled();
    }


    public String giveSearchInput(){
       // clickSearch();
        inputField.sendKeys("Google Cloud Pricing Calculator");
        inputField.sendKeys(Keys.RETURN);
        return inputField.getAttribute("value");
    }

    public SearchResultsPage navigateToSearchResults(){
        //giveSearchInput();
        return new SearchResultsPage(getDriver());
    }


}
