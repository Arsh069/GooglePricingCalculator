package com.epam.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWebDriver{


    private static WebDriver driver;
    private FirefoxWebDriver(){

    }
    public static WebDriver getSingeltonWebDriver(){
        if(driver==null){
            synchronized(FirefoxWebDriver.class){
                if(driver==null) {
                    driver = new FirefoxDriver();
                }
            }
        }
        return driver;
    }

    public static WebDriver closeWebDriver(){
        if(driver!=null){
            synchronized(FirefoxWebDriver.class){
                if(driver!=null) {
                    driver.quit();
                }
            }
        }
        return driver;
    }
}
