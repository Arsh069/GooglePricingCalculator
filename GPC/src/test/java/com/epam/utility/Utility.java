package com.epam.utility;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Utility {

    private final String SCREENSHOT_PATH="C:\\Users\\mohammad_arsh\\Pictures\\TestScreenShots\\checkbox.png";
    public void takeScreenshot(WebDriver driver) throws IOException {
        File screenShotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile,new File(SCREENSHOT_PATH));
        Allure.addAttachment("Driver Screenshot",FileUtils.openInputStream(screenShotFile));
    }

    public void takeElementScreenshot(WebElement element) throws IOException {
        File screenShotFile=element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile,new File(SCREENSHOT_PATH));
        Allure.addAttachment("Element Screenshot",FileUtils.openInputStream(screenShotFile));
    }
}
