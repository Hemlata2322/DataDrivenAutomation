package org.automation.testingworld.commonLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageActions {
	
	public static void selectValueFromDropdown(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void selectDateFromDatePicker(String month, String year, String date)
	{
		String xpath = String.format("(//table[@class = 'ui-datepicker-calendar']//td[@data-month = '%s' and @data-year='%s']//a[contains(text(), '%s')])[1]", month, year, date);
	}

}
