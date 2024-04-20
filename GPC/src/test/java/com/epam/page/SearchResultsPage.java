package com.epam.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;




public class SearchResultsPage extends Page {


    @FindBy(xpath = "//a[@class='K5hUy' and @track-metadata-eventdetail='cloud.google.com/products/calculator-legacy']")
    private WebElement pricingCalculatorAnchor;


    public SearchResultsPage(WebDriver driver){
        super(driver);

    }

    public SearchResultsPage launchSearchResults(){
        getDriver().get("https://cloud.google.com/search?hl=en&q=Google%20Cloud%20Pricing%20Calculator");
        return this;
    }


    public String searchCalculatorUrl(){

        getWait().until(ExpectedConditions.elementToBeClickable(pricingCalculatorAnchor));

        String pricingText=pricingCalculatorAnchor.getText();

        return pricingText;
    }

    public void selectPricingCalculatorURL(){
     //   searchCalculatorUrl();
        pricingCalculatorAnchor.click();
    }

    public CalculatorLegacyPage setCalculatorFields(){

        selectPricingCalculatorURL();
        return new CalculatorLegacyPage(getDriver());
    }


}
