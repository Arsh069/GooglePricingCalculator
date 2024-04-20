package com.epam.test;

import com.epam.browserfactory.WebDriverFactory;
import com.epam.page.CalculatorLegacyPage;
import com.epam.page.GoogleCloudPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CalculatorLegacyPageTest {
    WebDriver driver;
    CalculatorLegacyPage calculatorLegacyPage;



    @BeforeTest
    public void setWebDriver(){
        driver=new WebDriverFactory().createWebDriver("chrome");
        calculatorLegacyPage=new CalculatorLegacyPage(driver);

    }

    @Test
    public void testNumberOfInstances(){
        Assert.assertEquals(calculatorLegacyPage.launchCalculatorLegacyPage().addNumberOfInstances(),"4");
    }

    @Test(dependsOnMethods = "testNumberOfInstances")
    public void testOperatingSystemChoice(){
        Assert.assertEquals(calculatorLegacyPage.setOperatingSystems(),"Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");
    }



    @Test(dependsOnMethods = "testOperatingSystemChoice")
    public void testProvisionalModelChoice(){
        Assert.assertEquals(calculatorLegacyPage.setProvisionalModel(),"Regular");
    }



    @Test(dependsOnMethods = "testProvisionalModelChoice")
    public void testSeries(){
        Assert.assertEquals(calculatorLegacyPage.setSeries(),"N1");
    }

    @Test(dependsOnMethods = "testSeries")
    public void testMachineType(){
        Assert.assertEquals(calculatorLegacyPage.setMachineType(),"n1-standard-8 (vCPUs: 8, RAM: 30GB)");

    }


    @Test(dependsOnMethods = "testMachineType")
    public void testGpuCheckBox(){
        Assert.assertTrue(calculatorLegacyPage.clickAddGPUsCheckbox());

    }

    @Test(dependsOnMethods = "testGpuCheckBox")
    public void testGpuType(){
        Assert.assertEquals(calculatorLegacyPage.setGpuType(),"NVIDIA Tesla V100");

    }


    @Test(dependsOnMethods = "testGpuType")
    public void testNumberOfGPU(){
        Assert.assertEquals(calculatorLegacyPage.setNumberOfGPUs(),"1");

    }

    @Test(dependsOnMethods = "testNumberOfGPU")
    public void testLocalSSD(){
        Assert.assertEquals(calculatorLegacyPage.setLocalSSD(),"2x375 GB");

    }

    @Test(dependsOnMethods = "testLocalSSD")
    public void testDataCenterLocation(){
        Assert.assertEquals(calculatorLegacyPage.setDataCenterLocation(),"Frankfurt (europe-west3)");

    }

    @Test(dependsOnMethods = "testDataCenterLocation")
    public void testCommitedUsage(){
        Assert.assertEquals(calculatorLegacyPage.setCommitedUsage(),"1 Year");
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Estimated value of calculator")
    @Test(dependsOnMethods = "testCommitedUsage")
    public void testEstimatedValue(){
        Assert.assertEquals(calculatorLegacyPage.getEstimatedValue(),"Total Estimated Cost: USD 1,081.20 per 1 month");
    }

    @AfterMethod()
    public void verifyEstimate(ITestResult result) throws IOException {
        if(ITestResult.FAILURE== result.getStatus()){
           File screenShotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(screenShotFile,new File("C:\\Users\\mohammad_arsh\\Pictures\\TestScreenShots\\estimate.png"));

        }
    }



    /*@AfterTest
    public void closeWebDriver(){
        driver.quit();
        calculatorLegacyPage=null;
    }*/


}
