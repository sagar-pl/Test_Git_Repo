package entrata_Test_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Entrat_Locators {

	public WebDriver driver;

	public Entrat_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Schedule Demo Link
	@FindBy(xpath = "//div[text()='Schedule Your Demo']")
	private WebElement schedule_Demo;

	public WebElement get_Schedule_Demo() {
		return schedule_Demo;

	}

	// Schedule Demo form First Name
	@FindBy(id = "FirstName")
	private WebElement first_Name;

	public WebElement get_first_Name() {
		return first_Name;

	}

	// Schedule Demo form last Name
	@FindBy(id = "LastName")
	private WebElement lasst_Name;

	public WebElement get_last_Name() {
		return lasst_Name;

	}

	// Schedule Demo form email Id
	@FindBy(id = "Email")
	private WebElement email_Id;

	public WebElement get_email_Id() {
		return email_Id;

	}

	// Schedule Demo form Company Name
	@FindBy(id = "Company")
	private WebElement company_Name;

	public WebElement get_Company_Name() {
		return company_Name;

	}

	// Schedule Demo form Phone No.
	@FindBy(id = "Phone")
	private WebElement phoneno;

	public WebElement phoneno() {
		return phoneno;

	}
	
	// Schedule Demo form Phone No.
	@FindBy(id = "Unit_Count__c")
	private WebElement unitCount;

	public WebElement get_unitCount() {
		return unitCount;
	}

	// Careers Page Locator
	@FindBy(xpath = "//section[@class='footer-section']")
	private WebElement footer_section;

	public WebElement get_footer_section() {
		return footer_section;
	}
	@FindBy(xpath = "//a[text()='Careers']")
	private WebElement Link_Careers;

	public WebElement get_Link_Careers() {
		return Link_Careers;
	}
	@FindBy(xpath = "//div[@class='single-product-left career']//div[text()='Search Jobs']")
	private WebElement Btn_Search_Jobs;

	public WebElement get_Btn_Search_Jobs() {
		return Btn_Search_Jobs;
	}
	@FindBy(xpath = "//div[text()='Location type']")
	private WebElement ddl_Location_type;

	public WebElement get_ddl_Location_type() {
		return ddl_Location_type;
	}
	@FindBy(xpath = "//a[text()='Remote']")
	private WebElement ddv_Location_type;

	public WebElement get_ddv_Location_type() {
		return ddv_Location_type;
	}
	@FindBy(xpath = "//div[text()='Location']")
	private WebElement ddl_Location;

	public WebElement get_ddl_Location() {
		return ddl_Location;
	}
	@FindBy(xpath = "//a[text()='Pune, India']")
	private WebElement ddv_Location;

	public WebElement get_ddv_Location() {
		return ddv_Location;
	}
	@FindBy(xpath = "//div[text()='Team']")
	private WebElement ddl_Team;

	public WebElement get_ddl_Team() {
		return ddl_Team;
	}
	@FindBy(xpath = "//a[text()='Finance & Accounting']")
	private WebElement ddv_Team;

	public WebElement get_ddv_Team() {
		return ddv_Team;
	}
	@FindBy(xpath = "//div[@class='filter-button filter-button-mlp' and contains(text(),'Work type')]")
	private WebElement ddl_Work_type;

	public WebElement get_ddl_Work_type() {
		return ddl_Work_type;
	}
	@FindBy(xpath = "//a[text()='Full-Time']")
	private WebElement ddv_Work_type;

	public WebElement get_ddv_Work_type() {
		return ddv_Work_type;
	}
	@FindBy(xpath = "//p[@class='no-postings-message' and contains(text(),'No job postings match these filters.')]")
	private WebElement msg_JobNotification;

	public WebElement get_msg_JobNotification() {
		return msg_JobNotification;
	}
}
