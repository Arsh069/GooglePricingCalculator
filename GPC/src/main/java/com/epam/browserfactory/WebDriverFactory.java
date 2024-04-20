package com.epam.browserfactory;
import com.epam.exception.NoSuchBrowserException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {

    public WebDriver createWebDriver(String webDriverName) {
        switch (webDriverName.toLowerCase()){
            case "chrome":
                return ChromeWebDriver.getSingletonWebDriver();

            case "firefox":
                return FirefoxWebDriver.getSingeltonWebDriver();

            case "edge":
                return EdgeWebDriver.getSingeltonWebDriver();

            default:
                throw new NoSuchBrowserException("This browser does not exist in your System , Browser:"+webDriverName);
        }

    }

    public WebDriver closeWebDriver(String webDriverName) {
        switch (webDriverName.toLowerCase()){
            case "chrome":
                return ChromeWebDriver.closeWebDriver();

            case "firefox":
                return FirefoxWebDriver.closeWebDriver();

            case "edge":
                return EdgeWebDriver.closeWebDriver();

            default:
                throw new NoSuchBrowserException("This browser does not exist in your System , Browser:"+webDriverName);
        }

    }

}

