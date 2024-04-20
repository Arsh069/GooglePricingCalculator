package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalculatorLegacyPage extends Page {



    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    WebElement firstFrame;

    @FindBy(xpath = "//*[@id=\"myFrame\"]")
    WebElement secondFrame;
    @FindBy(id="input_100")
    WebElement numberOfInstances;

    @FindBy(className = "md-select-value")
    WebElement operatingSystems;

    @FindBy(xpath = "//*[@id=\"select_option_102\"]")
    WebElement osType;

    @FindBy(id = "select_value_label_93")
    WebElement provisionalModel;

    @FindBy(id="select_option_115")
    WebElement provisionalModelChoice;


    @FindBy(id="select_125")
    WebElement series;

    @FindBy(id="select_option_224")
    WebElement seriesChoice;


    @FindBy(id="select_127")
    WebElement machineType;

    @FindBy(id = "select_option_474")
    WebElement machineTypeChoice;


    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[13]/div[1]/md-input-container/md-checkbox")
    WebElement addGPUsCheckbox;

    @FindBy(id = "select_510")
    WebElement gpuType;

    @FindBy(id="select_option_517")
    WebElement gpuTypeChoice;

    @FindBy(id="select_512")
    WebElement numberOfGPUs;

    @FindBy(id="select_option_520")
    WebElement numberOfGPUsChoice;

    @FindBy(id = "select_469")
    WebElement localSSD;

    @FindBy(id="select_option_495")
    WebElement localSSDChoice;


    @FindBy(id="select_133")
    WebElement dataCenterLocation;

    @FindBy(id="select_option_268")
    WebElement dataCenterLocationChoice;

    @FindBy(id="select_140")
    WebElement committedUsage;

    @FindBy(id="select_option_138")
    WebElement committedUsageChoice;


    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[20]/button")
    WebElement addToEstimateButton;


    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/div[1]/h2/b")
    WebElement estimatedValue;

    public CalculatorLegacyPage(WebDriver driver){
        super(driver);

        //wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public CalculatorLegacyPage launchCalculatorLegacyPage(){
        getDriver().get("https://cloud.google.com/products/calculator-legacy");
        return this;
    }
    public void switchFrames(){

        WebElement firstFrame=getDriver().findElement(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe"));
        getWait().until(ExpectedConditions.elementToBeClickable(firstFrame));
        getDriver().switchTo().frame(firstFrame);


        WebElement frameElement=getDriver().findElement(By.xpath("//*[@id=\"myFrame\"]"));
        getWait().until(ExpectedConditions.elementToBeClickable(frameElement));
        getDriver().switchTo().frame(frameElement);

    }



    public String addNumberOfInstances(){
        switchFrames();
        getWait().until(ExpectedConditions.elementToBeClickable(numberOfInstances));
        numberOfInstances.sendKeys("4");
        return numberOfInstances.getAttribute("value");
    }

    public String setOperatingSystems(){
        //addNumberOfInstances();
        operatingSystems.click();
        getWait().until(ExpectedConditions.elementToBeClickable(operatingSystems));
        osType.click();
        return osType.getText();
    }

    public String setProvisionalModel(){
       // setOperatingSystems();
        getWait().until(ExpectedConditions.elementToBeClickable(provisionalModel));
        provisionalModel.click();
        getWait().until(ExpectedConditions.elementToBeClickable(provisionalModelChoice));
        provisionalModelChoice.click();
        return provisionalModelChoice.getText();
    }

    public String setSeries(){
     //   setProvisionalModel();

        getWait().until(ExpectedConditions.elementToBeClickable(series));
        series.click();
        getWait().until(ExpectedConditions.elementToBeClickable(seriesChoice));
        String seriesChoiceText=seriesChoice.getText();
        seriesChoice.click();
        return seriesChoiceText;
    }

    public String setMachineType(){
      //  setSeries();
        getWait().until(ExpectedConditions.elementToBeClickable(machineType));
        machineType.click();

        getWait().until(ExpectedConditions.elementToBeClickable(machineTypeChoice));
        String machineTypeChoiceText=machineTypeChoice.getText();
        machineTypeChoice.click();

        return machineTypeChoiceText;
    }

    public boolean clickAddGPUsCheckbox(){
       // setMachineType();
        getWait().until(ExpectedConditions.elementToBeClickable(addGPUsCheckbox));
        addGPUsCheckbox.click();
        return addGPUsCheckbox.isEnabled();
    }


    public String setGpuType(){
      //  clickAddGPUsCheckbox();
        getWait().until(ExpectedConditions.elementToBeClickable(gpuType));
        gpuType.click();
        getWait().until(ExpectedConditions.elementToBeClickable(gpuTypeChoice));
        gpuTypeChoice.click();
        return gpuTypeChoice.getText();
    }

    public String setNumberOfGPUs(){
        //setGpuType();
        getWait().until(ExpectedConditions.elementToBeClickable(numberOfGPUs));
        numberOfGPUs.click();
        getWait().until(ExpectedConditions.elementToBeClickable(numberOfGPUsChoice));
        numberOfGPUsChoice.click();
        return numberOfGPUsChoice.getText();
    }

    public String setLocalSSD(){

        getWait().until(ExpectedConditions.elementToBeClickable(localSSD));
        localSSD.click();
        getWait().until(ExpectedConditions.elementToBeClickable(localSSDChoice));
        localSSDChoice.click();
        return localSSDChoice.getText();
    }

    public String setDataCenterLocation(){
        getWait().until(ExpectedConditions.elementToBeClickable(dataCenterLocation));
        dataCenterLocation.click();
        getWait().until(ExpectedConditions.elementToBeClickable(dataCenterLocationChoice));
        dataCenterLocationChoice.click();
        return dataCenterLocationChoice.getText();
    }

    public String  setCommitedUsage(){

        getWait().until(ExpectedConditions.elementToBeClickable(committedUsage));
        committedUsage.click();
        getWait().until(ExpectedConditions.elementToBeClickable(committedUsageChoice));
        String committedUsageChoiceText=committedUsageChoice.getText();
        committedUsageChoice.click();
        return committedUsageChoiceText;
    }

    public void calculateTheEstimate(){
    //    setCommitedUsage();
        getWait().until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        addToEstimateButton.click();
    }


    public String getEstimatedValue(){
        calculateTheEstimate();

        return estimatedValue.getText();
    }






}
