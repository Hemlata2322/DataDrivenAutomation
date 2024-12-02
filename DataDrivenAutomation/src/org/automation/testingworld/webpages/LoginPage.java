package org.automation.testingworld.webpages;

import org.automation.testingworld.testbase.TestBase;
import org.automation.testingworld.utility.ExtentReport;
import org.automation.testingworld.utility.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends TestBase{

//	public WebDriver driver;
//
//	public LoginPage(WebDriver driver) {
//		this.driver = driver;
//	}

	    
	@FindBy(xpath = "//em[text() = 'Keep me logged in ']//preceding-sibling::input")
	WebElement loggedInChkBox;
	@FindBy(xpath = "//input[@id='tab2' ]/parent::li")
	WebElement loginTab;
	@FindBy(name = "_txtPassword")
	WebElement passwordTxtBox;
	@FindBy(xpath = "//input[@type='submit' and @value ='Login']")
	WebElement loginBtn;
	@FindBy(name = "_txtUserName")
	WebElement userNameTxtBox;

// Example of fetching the element value from prop file
//	public void enterUsername(String userName) {
//		driver.findElement(By.name(Utility.fetchElementValue("loginUsernameByname"))).sendKeys(userName);
//	}
	
	public void switchToLoginTab() {
		log.info("Switching to the Login tab");
	//	extentReport.logInfo("Starting the login test...");
		try
		{
		loginTab.click();
		log.info("Login tab is clicked");
		}
		catch(Exception e)
		{
			log.error("Exception occured", new Exception("LoginTab element is not found") );
		}
		
		//extentReport.createExtentNode("Switch to login tab is clicked");
	}
	public void enterUsername(String userName) {
		userNameTxtBox.sendKeys(userName);
		//extentReport.createExtentNode("Entered username as: " +userName);
	}
	public void enterPassword(String password) {
		passwordTxtBox.sendKeys(password);
		//extentReport.createExtentNode("Entered password as: "+password);
	}

	public void clickKeepMeLoggedInBtn() {
		loggedInChkBox.click();
		//extentReport.createExtentNode("Clicked on Keep Me Logged In CheckBox");
	}

	public void clickLogin() {
		loginBtn.click();
		//extentReport.createExtentNode("Clicked on Login Button");
	}

}
