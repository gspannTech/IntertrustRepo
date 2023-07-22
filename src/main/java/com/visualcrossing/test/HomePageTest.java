package com.visualcrossing.test;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.visualcrossing.pageobjects.HomePage;
import com.visualcrossing.pageobjects.WeatherDatePage;

public class HomePageTest  extends TestBase {
	
	String arr[]= {"Max temp", "Min temp","Total Precip", "Max daily precip","Rain days", "Max sustained wind"};


	
	@Test
    public void testSearchLocation() throws Exception {
		HomePage homepage = new HomePage(getDriver());
		WeatherDatePage weatherdataPage = new WeatherDatePage(getDriver());
		homepage.clickWeatherDataMenu();
		
		//Assertion of Page is opened after click on Weather Data menu
		 String expectedTitle = "Historical Weather Data & Weather Forecast Data | Visual Crossing";
	     String actualTitle = homepage.getHomePageTitle();
	     Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected title");
	     
	     
	     //Assertion Weather data page is opened after city is entered
	     weatherdataPage.enterLocation("New York");
	     weatherdataPage.clickSearchButton();
	     Assert.assertTrue(weatherdataPage.isWeatherHistoryPageVisible(), "WeatherData page is not opened");
	     Thread.sleep(3000);
	     
	     //validation of "Max temp", "Min temp","Total Precip", "Max daily precip","Rain days", "Max sustained wind" appeared after selecting the city
	     ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(arr));
	     Assert.assertEquals(weatherdataPage.getTopHeaderDataList().size(), arrList.size(), "All data is not prsent in top header list");
	     Assert.assertTrue(arrList.equals(weatherdataPage.getTopHeaderDataList()), "top header data is not matched");

	     //Similarly we can verify graphs, Location and station map, Past weather provided by the Visual Crossing Weather API
	     
	     
	}

	
	
}
