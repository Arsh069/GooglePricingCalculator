package com.epam.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeWebDriver{
    private static WebDriver driver;
    private EdgeWebDriver(){

    }
    public static WebDriver getSingeltonWebDriver(){
        if(driver==null){
            synchronized(EdgeWebDriver.class){
                if(driver==null) {
                    driver = new EdgeDriver();
                }
            }
        }
        return driver;
    }

    public static WebDriver closeWebDriver(){
        if(driver!=null){
            synchronized(EdgeWebDriver.class){
                if(driver!=null) {
                    driver.quit();
                }
            }
        }
        return driver;
    }

}
