package org.automation.testinworld.datagenerators;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {

	@DataProvider(name = "Excel")
	public static Object[][] testDataGenerator() {

		Object[][] testData = null;
		try {

			FileInputStream file = new FileInputStream("./TestData/LoginTestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet loginSheet = workbook.getSheet("Login");
			int numberOfData = loginSheet.getPhysicalNumberOfRows();
			testData = new Object[numberOfData][2];
			for (int i = 0; i < numberOfData; i++) {
				XSSFRow row = loginSheet.getRow(i);
				XSSFCell userName = row.getCell(0);
				XSSFCell password = row.getCell(1);
				testData[i][0] = userName.getStringCellValue();
				testData[i][1] = password.getStringCellValue();
			}
		}
		catch (Exception e) {

		}
		return testData;
	}
}
