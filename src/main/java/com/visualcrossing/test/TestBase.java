package com.visualcrossing.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.visualcrossing.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestBase {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
    	System.setProperty("headless", "false"); // You can set this property elsewhere
        String headless = System.getProperty("headless");

        if("true".equals(headless)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
    }

    @BeforeTest
    public void launchApp() {
    	  HomePage homepage = new HomePage(getDriver());
          driver.get("https://www.visualcrossing.com/");
          homepage.acceptAllCookies();
    }
    
	 @AfterSuite
	    public void afterSuite() {
	        if(null != driver) {
	            driver.close();
	            driver.quit();
	        }
	 }
	 
	 public WebDriver getDriver() {
	        return driver;
	 }
	    
}

