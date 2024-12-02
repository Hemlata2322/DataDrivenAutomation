package org.automation.testingworld.commonLibrary;

import org.openqa.selenium.WebDriver;

public class CommonAssertions {
	
	public static boolean validatePageURL(WebDriver driver, String expectedURL)
	{
		boolean flag = false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expectedURL))
		{
			flag = true;
		}
		return flag;
	}
	
	public static boolean validatePageTitle(WebDriver driver, String expectedTitle)
	{
		boolean flag = false;
		if(driver.getTitle().equalsIgnoreCase(expectedTitle))
		{
			flag = true;
		}
		return flag;
	}

}
