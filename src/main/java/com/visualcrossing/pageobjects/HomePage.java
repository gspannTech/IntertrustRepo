package com.visualcrossing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {   
    private By weatherDataMenuLocator = By.xpath("//a[text()='Weather Data']");
    private By acceptAllCookiesLocator = By.xpath("//button[@class='btn btn-sm btn-primary col-lg-3']");


    public HomePage(WebDriver driver) {
    	 super(driver);
    }

    public void acceptAllCookies() {
        WebElement acceptCookies = driver.findElement(acceptAllCookiesLocator);
        acceptCookies.click();
    }
  
    public void clickWeatherDataMenu() {
        WebElement weatherDataMenu = driver.findElement(weatherDataMenuLocator);
        weatherDataMenu.click();
    }
    
    public String getHomePageTitle() {
        String title = driver.getTitle();
        return title;
    }

}
