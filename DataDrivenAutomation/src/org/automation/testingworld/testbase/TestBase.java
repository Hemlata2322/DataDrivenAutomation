package org.automation.testingworld.testbase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.testingworld.utility.ExtentReport;
import org.automation.testingworld.utility.PropertyFileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	protected WebDriver driver;
	protected static Logger log;
//	protected ExtentReport extentReport;
	
	// Set up Extent Reporting & Logs
	@BeforeSuite
     public void beforeSuite() {
        // Initialize Extent Report before the entire suite starts
   //     extentReport = new ExtentReport();
    //    extentReport.initializeExtentReport();
        log = LogManager.getLogger(TestBase.class);
        log.info("Initializing Test Suite...");
    }

	// Any test-wide setup can go here  
    @BeforeTest
    public void beforeTest() {
        log.info("Before Test Execution...");
    }
    
 //  WebDriver setup
	@BeforeClass
	public void setUp() {
		PageFactory.initElements(driver, this);
		
		if (PropertyFileReader.fetchPropertyValue("BrowserName").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (PropertyFileReader.fetchPropertyValue("BrowserName").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (PropertyFileReader.fetchPropertyValue("BrowserName").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./Driver/internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(PropertyFileReader.fetchPropertyValue("applicationURL"));
		log.info("Navigated to application.");
		driver.manage().window().maximize();
	}

	 // Any setup before each test method    
    @BeforeMethod
    public void beforeMethod() {
        log.info("Before Method Execution...");
        // Any setup needed for every test can go here
    }
    
    // Cleanup after each test method   
    @AfterMethod
    public void afterMethod() {
        log.info("After Method Execution...");
        // Cleanup after each test method execution can go here
    }
    
    //  - Cleanup WebDriver instance    
    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("Quitting the driver.");
    }
    
    // - Test-wide Cleanup
    
    @AfterTest
    public void afterTest() {
        log.info("After Test Execution...");
        // Any final cleanup for the test can go here
    }
    
    // - Generate Extent Report after suite execution   
    @AfterSuite
    public void afterSuite() {
    //    extentReport.generateExtentReport();
        log.info("Generating Extent Report...");
    }

}
