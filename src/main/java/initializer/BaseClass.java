package initializer;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataSources.PropertiesReader;
import utility_Class_Package.BrowserFactory;
import utility_Class_Package.WebCommonPath;
import utility_Class_Package.WebScreenshot;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports report = null;
	public static ExtentTest logger;

	@BeforeSuite
	public static void beforeSuite() {
		report = new ExtentReports(WebCommonPath.extentReportPath, true);
		report.addSystemInfo("User Name", "Sagar Lingot");
		report.addSystemInfo("Enviorment", "QA");
	}

	@BeforeMethod
	public static void beforeEachMethod(Method testMethod) throws IOException {

		driver = BrowserFactory.setBrowser(); // Set the browser name which you want
		driver.get(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "url"));// Pass Url from Propeties
		driver.manage().window().setSize(new Dimension(1920, 1080));
		logger = report.startTest(testMethod.getName());
		logger.log(LogStatus.INFO, "Browser Launched with :- " + driver.getCurrentUrl());

	}

	@AfterMethod
	public void afterEachMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			// to add name in extent report
			logger.log(LogStatus.FAIL, result.getName() + " Test Case Failed.");
			// to add error/exception in extent report
			logger.log(LogStatus.FAIL, "Test Case Failed:- " + result.getThrowable());

			// String screenshotPath = BaseClass.getScreenshot(driver, result.getName());
			String screenshotPath = WebScreenshot.getScreenshot(driver, result.getName());
			// to add Screenshot in extent report
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, result.getName() + " Test Case Skipped.");
			String screenshotPath = WebScreenshot.getScreenshot(driver, result.getName());
			// to add Screenshot in extent report
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, result.getName() + " Test Case Passed.");
			// logger.log(LogStatus.PASS, "Test Case Passed:- " + result.getThrowable());
			String screenshotPath = WebScreenshot.getScreenshot(driver, result.getName());
			// to add Screenshot in extent report
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));

		}
		driver.quit();
		report.endTest(logger);
		report.flush();

	}

}
