package com.epam.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver {
    private static WebDriver driver;

    private ChromeWebDriver() {
        // private constructor to prevent instantiation outside of this class
    }

    public static WebDriver getSingletonWebDriver() {
        if (driver == null) {
            synchronized (ChromeWebDriver.class) {
                if (driver == null) {
                    driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }

    public static WebDriver closeWebDriver(){
        if(driver!=null){
            synchronized(ChromeWebDriver.class){
                if(driver!=null) {
                    driver.quit();
                }
            }
        }
        return driver;
    }


}
