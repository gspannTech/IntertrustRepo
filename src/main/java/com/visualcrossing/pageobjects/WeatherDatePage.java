package com.visualcrossing.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeatherDatePage extends BasePage{

	
    private By searchInputLocator = By.xpath("//input[@id='wxlocation']");
    private By searchButtonLocator = By.xpath("//button[contains(text(),'Search')]");
    private By weatherHistoryText = By.xpath("//a[@id='locationDropdownMenuButton']");
    private By datalist = By.xpath("//div[@class='row justify-content-center mt-3 mb-3']/div/div[@class='text-muted fs-xs']");


    public WeatherDatePage(WebDriver driver) {
    	 super(driver);
    }

    public void enterLocation(String location) {
        WebElement searchInput = driver.findElement(searchInputLocator);
        searchInput.sendKeys(location);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
    }
    
    public boolean isWeatherHistoryPageVisible() {
        return driver.findElement(weatherHistoryText).isDisplayed();
    }
    
    
    public List<String> getTopHeaderDataList(){
    	List<String> li1 = new ArrayList<String>();
    	List<WebElement>li = driver.findElements(datalist);
    	for(WebElement ele : li) {
    		li1.add(ele.getText());
    	}
		return li1;
    }
    
   
}
