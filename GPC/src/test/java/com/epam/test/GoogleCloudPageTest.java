package com.epam.test;

import com.epam.browserfactory.WebDriverFactory;
import com.epam.page.GoogleCloudPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class GoogleCloudPageTest {

    WebDriver driver;
    GoogleCloudPage googleCloudPage;



    @BeforeTest
    public void setWebDriver(){
        driver=new WebDriverFactory().createWebDriver("chrome");
        googleCloudPage=new GoogleCloudPage(driver);

    }


    @Step("Test the presence of Search Icon")
    @Test
    public void testSearchIcon(){
        Assert.assertTrue(googleCloudPage.clickSearch());
    }

    @Step("Test for correct input")
    @Test(dependsOnMethods = "testSearchIcon")
    public void testInputFeild(){
        Assert.assertEquals(googleCloudPage.giveSearchInput(),"Google Cloud Pricing Calculator");
    }


    @Step("Test if the desired link is Present")
    @Test(dependsOnMethods = "testInputFeild")
    public void testCalculatorUrl(){

        Assert.assertEquals(googleCloudPage.navigateToSearchResults().searchCalculatorUrl(),"Google Cloud Pricing Calculator");
    }




    /*@Test(dependsOnMethods = "testCalculatorUrl")
    public void testCalculatorSearch(){
        googleCloudPage.navigateToSearchResults().setCalculatorFields().calculateTheEstimate();
    }*/




}
