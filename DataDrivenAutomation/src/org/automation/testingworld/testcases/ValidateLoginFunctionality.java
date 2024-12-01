package org.automation.testingworld.testcases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.testingworld.base.DriverInstance;
import org.automation.testingworld.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateLoginFunctionality extends DriverInstance {
//(dataProvider = "Excel", dataProviderClass=DataGenerator.class)
	//String uName, String Pwd
	
	@Test
	public void VerifyLoginFunctionality() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.switchToLoginTab();
		loginPage.enterUsername("test");
		loginPage.enterPassword("test");
		loginPage.clickLogin();
	}
	
	//This method is read excel data from onedrive which is not working as of now
	@DataProvider(name = "Excel")
    public Object[][] testDataGenerator() {

        Object[][] testData = null;
        try {
            // File URL for download
            String fileUrl = "https://onedrive.live.com/download?cid=88B1DB08AC86AB8E&resid=88B1DB08AC86AB8E%211123&authkey=AAGYP9JKhvvGxxg";
            
            // Open a connection to the URL
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");

            // Read the input stream and save the file locally
            try (InputStream inputStream = connection.getInputStream()) {
                FileOutputStream fileOut = new FileOutputStream("LoginTestData.xlsx");  // Save to local file
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOut.write(buffer, 0, bytesRead);
                }
                fileOut.close();
            }

            // Load the Excel file
            FileInputStream file = new FileInputStream("LoginTestData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get the sheet from the workbook
            XSSFSheet loginSheet = workbook.getSheet("Login");

            // Get the number of rows in the sheet
            int numberOfData = loginSheet.getPhysicalNumberOfRows();
            
            // Initialize the testData array to match the number of rows and columns
            testData = new Object[numberOfData][2];  // Assuming two columns: Username and Password

            // Loop through rows and populate testData
            for (int i = 0; i < numberOfData; i++) {
                XSSFRow row = loginSheet.getRow(i);
                
                // Check if the row is null to avoid NullPointerException
                if (row != null) {
                    XSSFCell userNameCell = row.getCell(0);  // Column 0 for Username
                    XSSFCell passwordCell = row.getCell(1);  // Column 1 for Password

                    // Store the values in the testData array
                    if (userNameCell != null && passwordCell != null) {
                        testData[i][0] = userNameCell.getStringCellValue();
                        testData[i][1] = passwordCell.getStringCellValue();
                    }
                }
            }
            workbook.close();  // Close the workbook after usage
            file.close();  // Close the file stream

        } catch (Exception e) {
            e.printStackTrace();  // Print exception stack trace for debugging
        }

        return testData;
    }

}
