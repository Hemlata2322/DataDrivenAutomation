package org.automation.testingworld.utility;

import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	// Create an instance of ExtentReports
	public  ExtentReports extentReport;
	public  ExtentTest extentTest;

	// Initialize Extent Report
	public  void initializeExtentReport() {
		// Get the directory path where the reports will be stored
		String extentReportPath = Paths.get(System.getProperty("user.dir"), "extentreport.html").toString();

		// Create ExtentReports instance
		extentReport = new ExtentReports();

		// Create ExtentSparkReporter and attach it to the ExtentReports
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportPath);
		extentReport.attachReporter(spark);
	}

	public  void createExtentTest(String testName) {
		// Create a test in the ExtentReport
		extentReport.createTest(testName);
	}
	// Log information (can be used throughout the test execution)
    public  void logInfo(String message) {
        extentTest.info(message);
    }

    // Log an error message
    public  void logError(String message) {
      //  extentTest.errorr(message);
    }

    // Log a failure (used in case of test failure)
    public  void logFailure(String message) {
        extentTest.fail(message);
    }


	public  void createExtentNode(String node) {

		// Create a node under the test
		extentTest.createNode(node);
	}

	// Generate the final extent report
	public  void generateExtentReport() {
		// Write the content to the report file
		extentReport.flush();
	}
}
