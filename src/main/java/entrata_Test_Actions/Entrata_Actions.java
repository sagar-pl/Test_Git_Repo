package entrata_Test_Actions;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import dataSources.PropertiesReader;
import entrata_Test_Locators.Entrat_Locators;
import utility_Class_Package.WebButton;
import utility_Class_Package.WebCommonPath;
import utility_Class_Package.WebDropDown;
import utility_Class_Package.WebScrollView;
import utility_Class_Package.WebTextBox;
import utility_Class_Package.WebWait;

public class Entrata_Actions {

	public WebDriver driver;
	Entrat_Locators entrat_Locators = null;
	public ExtentTest logger;
	public Method result;

	public Entrata_Actions(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		entrat_Locators = new Entrat_Locators(driver);

	}

	// Click on Schedule Demo Link
	public void click_on_schedule_demo() throws InterruptedException {
		// driver.findElement(By.xpath("//a[@id='cookie-accept']")).click();
		WebWait.elementToBeClickable(driver, entrat_Locators.get_Schedule_Demo(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_Schedule_Demo(), driver);
		logger.log(LogStatus.PASS, "Clicked on Schedule Demo link Successfully");
		String originalWindow = driver.getWindowHandle();
		// Switch to the new window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break; // Exit loop after switching
			}
		}
	}

	public void Verify_broken_link_dashboard() {

		WebWait.elementToBeClickable(driver, entrat_Locators.get_Schedule_Demo(), Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@id='cookie-accept']")).click();
		// Find all links on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links found: " + links.size());

		// Counters for broken and valid links
		int brokenLinkCount = 0;
		int validLinkCount = 0;

		List<String> brokenLinks = new ArrayList<>();

		// Loop through each link and verify if it's broken
		for (WebElement link : links) {
			String url = link.getAttribute("href");

			// Check if URL is not null or empty
			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured or it is empty");
				continue;
			}

			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
				int responseCode = connection.getResponseCode();

				// Print the link status
				if (responseCode >= 400) {
					System.out.println(url + " is a broken link");
					brokenLinkCount++;
					brokenLinks.add(url);
				} else {

					// System.out.println(url + " is a valid link");
					validLinkCount++;
				}
			} catch (IOException e) {
				System.out.println(url + " could not be verified due to an exception: " + e.getMessage());
			}
		}
		// Print the counts
		System.out.println("Total valid links: " + validLinkCount);
		System.out.println("Total broken links: " + brokenLinkCount);

		// Print broken links list
		System.out.println("List of broken links:");
		for (String brokenLink : brokenLinks) {
			System.out.println(brokenLink);
		}
		logger.log(LogStatus.PASS, "Total Valid Link is :" + validLinkCount);
		logger.log(LogStatus.PASS, "Total Broken Link is :" + brokenLinkCount);
	}

	// Enter First Name
	public void enter_First_Name() throws IOException {

		WebWait.explicitWaitSec(driver, entrat_Locators.get_first_Name());
		WebTextBox.sendInput(entrat_Locators.get_first_Name(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "First_Name"));
		logger.log(LogStatus.PASS, "First Name Entered Successfully");
	}

	// Enter Last Name
	public void enter_Last_Name() throws IOException {
		WebWait.explicitWaitSec(driver, entrat_Locators.get_last_Name());
		WebTextBox.sendInput(entrat_Locators.get_last_Name(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Last_Name"));
		logger.log(LogStatus.PASS, "Last Name Entered Successfully");
	}

	// Enter Email Name
	public void enter_emailId() throws IOException {
		WebWait.explicitWaitSec(driver, entrat_Locators.get_email_Id());
		WebTextBox.sendInput(entrat_Locators.get_email_Id(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Email"));
		logger.log(LogStatus.PASS, "Email Entered Successfully");
	}

	// Enter Company Name
	public void enter_Company_Name() throws IOException {
		WebWait.explicitWaitSec(driver, entrat_Locators.get_Company_Name());
		WebTextBox.sendInput(entrat_Locators.get_Company_Name(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Company_Name"));
		logger.log(LogStatus.PASS, "Company Name Entered Successfully");
	}

	// Enter Phone Number
	public void enter_PhoneNo() throws IOException {
		WebWait.elementToBeClickable(driver, entrat_Locators.phoneno(), Duration.ofSeconds(30));
		WebTextBox.sendInput(entrat_Locators.phoneno(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Phone_No"));
		logger.log(LogStatus.PASS, "Phone Number Entered Successfully");
	}

	// Select unit Count
	public void select_Unit_Count() throws IOException {
		WebWait.explicitWaitSec(driver, entrat_Locators.get_unitCount());
		WebDropDown.selectByIndex(entrat_Locators.get_unitCount(), 2);
		logger.log(LogStatus.PASS, "Unit Count Select Successfully");
	}

	// Careers page
	public void Dashboard_page() {

		WebWait.elementToBeClickable(driver, entrat_Locators.get_Schedule_Demo(), Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@id='cookie-accept']")).click();
		WebWait.visibilityOfElement(driver, entrat_Locators.get_footer_section(), Duration.ofSeconds(30));
		WebScrollView.scrollToElement(driver, entrat_Locators.get_footer_section());
		WebWait.elementToBeClickable(driver, entrat_Locators.get_Link_Careers(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_Link_Careers(), driver);
	}

	public void Careers_Page() {
		WebWait.elementToBeClickable(driver, entrat_Locators.get_Btn_Search_Jobs(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_Btn_Search_Jobs(), driver);
		String originalWindow = driver.getWindowHandle();
		// Switch to the new window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break; // Exit loop after switching
			}
		}

	}

	public void SearchJob_Page() {
		WebWait.elementToBeClickable(driver, entrat_Locators.get_ddl_Location_type(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_ddl_Location_type(), driver);
		WebWait.elementToBeClickable(driver, entrat_Locators.get_ddv_Location_type(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_ddv_Location_type(), driver);
		WebWait.elementToBeClickable(driver, entrat_Locators.get_ddl_Location(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_ddl_Location(), driver);
		WebWait.elementToBeClickable(driver, entrat_Locators.get_ddv_Location(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_ddv_Location(), driver);
		WebWait.elementToBeClickable(driver, entrat_Locators.get_ddl_Team(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_ddl_Team(), driver);
		WebWait.elementToBeClickable(driver, entrat_Locators.get_ddv_Team(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_ddv_Team(), driver);
		WebWait.elementToBeClickable(driver, entrat_Locators.get_ddl_Work_type(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_ddl_Work_type(), driver);
		WebWait.elementToBeClickable(driver, entrat_Locators.get_ddv_Work_type(), Duration.ofSeconds(30));
		WebButton.JsclickButton(entrat_Locators.get_ddv_Work_type(), driver);
		WebWait.visibilityOfElement(driver, entrat_Locators.get_msg_JobNotification(), Duration.ofSeconds(30));
		String Job_FilterResult = entrat_Locators.get_msg_JobNotification().getText();
		System.out.println(Job_FilterResult);
		Assert.assertEquals("No job postings match these filters.Go back to all job postings".replaceAll("\\s+", ""),
		Job_FilterResult.replaceAll("\\s+", ""));

	}

	public void schedule_Demo() throws IOException, InterruptedException {
		click_on_schedule_demo();
		enter_First_Name();
		enter_Last_Name();
		enter_emailId();
		enter_Company_Name();
		enter_PhoneNo();
		select_Unit_Count();
	}

	public void Broken_Link() {
		Verify_broken_link_dashboard();
	}

	public void Careers_page() {
		Dashboard_page();
		Careers_Page();
		SearchJob_Page();
	}
}
