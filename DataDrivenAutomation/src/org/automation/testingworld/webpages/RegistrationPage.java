package org.automation.testingworld.webpages;

import org.automation.testingworld.commonLibrary.PageActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
	String xpath;
	
	@FindBy(name = "fld_username") WebElement userNameTxtBox;
	@FindBy(name = "fld_email") WebElement emailTxtBox;
	@FindBy(name = "fld_password") WebElement passwordTxtBox;
	@FindBy(name = "fld_cpassword") WebElement confirmPasswordTxtBox;
	@FindBy(xpath = "xpath") WebElement datePicker;
//	@FindBy(xpath = "(//table[@class = 'ui-datepicker-calendar']//td[@data-month = ' \" + month + \" ' and @data-year='\" + year + \" ']//a[contains(text(), '\" + date + \"')])[1]") WebElement datePicker;
	@FindBy(name = "phone") WebElement phoneTxtBox;
	@FindBy(name = "address") WebElement addressTxtBox;
	@FindBy(xpath = "//input[@type = 'radio' and @value='\" + type + \"']") WebElement homeRadio;
	@FindBy(name = "sex") WebElement genderDropdown;
	@FindBy(name = "country") WebElement countryDropdown;
	@FindBy(name = "state") WebElement stateDropdown;
	@FindBy(name = "city") WebElement cityDropdown;
	@FindBy(name = "zip") WebElement zipTxtBox;
	@FindBy(xpath = "//em[contains(text(), 'I agree with terms and conditions ')]//preceding-sibling::input") WebElement tAndcCheckBox;
	@FindBy(xpath = "//input[@type = 'submit' and @value = 'Sign up']") WebElement signUpBtn;
	
	public void enterUsername(String userName)
	{
		userNameTxtBox.sendKeys(userName);
	}
	public void enterEmail(String email)
	{
		emailTxtBox.sendKeys(email);
	}
	public void enterPassword(String password)
	{
		passwordTxtBox.sendKeys(password);
	}
	public void enterConfirmPassword(String confirmPassword)
	{
		confirmPasswordTxtBox.sendKeys(confirmPassword);
	}
	public void selectDate(String date, String month, String year)
	{		
		
		xpath = String.format("(//table[@class = 'ui-datepicker-calendar']//td[@data-month = '%s' and @data-year='%s']//a[contains(text(), '%s')])[1]", month, year, date);
		datePicker.click();		
	}
	public void enterPhone(String phone)
	{
		phoneTxtBox.sendKeys(phone);
	}
	public void enterAddress(String address)
	{
		addressTxtBox.sendKeys(address);
	}
	public void chooseAddressTypeRadio(String type)
	{
		homeRadio.click();
	}
	public void selectGender(String gender)
	{
		PageActions.selectValueFromDropdown(genderDropdown, gender);
		
	}
	public void selectCountry(String country)
	{
		PageActions.selectValueFromDropdown(countryDropdown, country);
		
	}
	public void selectState(String state)
	{
		PageActions.selectValueFromDropdown(stateDropdown, state);
		
	}
	public void selectCity(String city)
	{
		PageActions.selectValueFromDropdown(cityDropdown, city);
		
	}
	public void enterZip(String zip)
	{
		zipTxtBox.sendKeys(zip);	
	}
	public void clickTandCOption()
	{
		tAndcCheckBox.click();
	}
	public void clickSignUp()
	{
		signUpBtn.click();
	}

}
