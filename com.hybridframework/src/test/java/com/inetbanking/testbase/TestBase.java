package com.inetbanking.testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbanking.utility.ConfigDataProvider;
import com.inetbanking.utility.ExcelDataProvider;
import com.inetbanking.utility.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public WebDriver driver;
	public static String configdatapath = "./Config/config.properties";
	public static String excelDataProviderpath = "./TestData/Data1.xlsx";
	
	public ConfigDataProvider configDataProvider;
	public ExcelDataProvider excelDataProvider;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	@BeforeSuite
	public void init()
	{
		configDataProvider = new ConfigDataProvider(configdatapath);
		excelDataProvider = new ExcelDataProvider(excelDataProviderpath);
		
		String extentReporterPath = System.getProperty("user.dir")+ "//Reports//inetbankin_report_" + Helper.getCurrentDatetime()+ ".html";
		htmlReporter= new ExtentHtmlReporter(extentReporterPath);
		
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("Host Name","Local Host");
		extentReport.setSystemInfo("OS","Window10");
		extentReport.setSystemInfo("Browser","Chrome");
		extentReport.setSystemInfo("Environment","Regression");
		extentReport.setSystemInfo("Tester Name","Punam");
	}
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(@Optional("Chrome")String brName)
	{
		if(brName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(brName.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("browser not matches");
		}
		driver.manage().window().maximize();
		driver.get(configDataProvider.getURL());
		
	}
	@AfterMethod
	public void teardown(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.fail("Test case Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP,"Test case Skipped");
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.log(Status.PASS,"Test case pass");
		}
		driver.quit();
	}
	@AfterTest
	public void flushReport()
	{
		extentReport.flush();
		driver.quit();
	}

}
