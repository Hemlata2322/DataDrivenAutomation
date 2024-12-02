package org.automation.testingworld.testcases;

import org.automation.testingworld.testbase.TestBase;
import org.automation.testingworld.webpages.RegistrationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTestCases extends TestBase {
	
	private RegistrationPage register;
	
	@BeforeClass
	public void initializePage()
	{
		register = PageFactory.initElements(driver, RegistrationPage.class);
	}

	@Test
	public void ValidateRegistrationFunctionality() throws InterruptedException
	{
		register.enterUsername("Hems");
		register.enterEmail("hemlata.sadhanani@gmail.com");
		register.enterPassword("hspwd");
		register.enterConfirmPassword("hspwd");
		Thread.sleep(2000);
	//	register.selectDate("9", "12", "2024");
		Thread.sleep(2000);
		register.enterPhone("9049822522");
		Thread.sleep(2000);
		register.enterAddress("Pimple Saudagar");
		Thread.sleep(2000);
	//	register.chooseAddressTypeRadio("home");
		Thread.sleep(2000);
		register.selectGender("Female");
		Thread.sleep(2000);
		register.selectCountry("India");
		Thread.sleep(2000);
	//	register.selectState("Maharashtra");
		Thread.sleep(2000);
		register.selectCity("Pune");
		Thread.sleep(2000);
		register.enterZip("411027");
		Thread.sleep(2000);
		register.clickTandCOption();
		Thread.sleep(2000);
		//register.clickSignUp();
	}
}
