package org.automation.testingworld.utility;

import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {

    // Create an instance of ExtentReports
    private static ExtentReports extentReport;

    // Initialize Extent Report
    public static void initializeExtentReport() {
        // Get the directory path where the reports will be stored
        String extentReportPath = Paths.get(System.getProperty("user.dir"), "extentreport.html").toString();
        
        // Create ExtentReports instance
        extentReport = new ExtentReports();

        // Create ExtentSparkReporter and attach it to the ExtentReports
        ExtentSparkReporter spark = new ExtentSparkReporter(extentReportPath);
        extentReport.attachReporter(spark);
    }

    // Create a test and a node under the test
    public static void createExtentNode(String testName, String node) {
        // Create a test in the ExtentReport
        ExtentTest extentTest = extentReport.createTest(testName);

        // Create a node under the test
        extentTest.createNode(node);
    }

    // Generate the final extent report
    public static void generateExtentReport() {
        // Write the content to the report file
        extentReport.flush();
    }
}
