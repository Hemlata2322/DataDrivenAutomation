package org.automation.testingworld.pages;

import org.automation.testingworld.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToLoginTab()
	{
		driver.findElement(By.xpath("//input[@id='tab2' ]/parent::li")).click();
	}
	
	public void enterUsername(String userName)
	{
		driver.findElement(By.name(Utility.fetchElementValue("loginUsernameByname"))).sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(By.name("_txtPassword")).sendKeys(password);
	}
	public void clickLogin()
	{
		driver.findElement(By.xpath("//input[@type='submit' and @value ='Login']")).click();
	}

}
