package entrata_Test_Test_Scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import entrata_Test_Actions.Entrata_Actions;
import initializer.BaseClass;

public class Entrata_Test extends BaseClass {

	public Entrata_Actions entrat_Action;

	// This test case is for the validate the page title
	//@Test
	public void test_01_Get_Title() {
		String expected_Title = "Property Management Software | Entrata";
		String original_Title = driver.getTitle();
		Assert.assertEquals(original_Title, expected_Title);
	}

	// This test case is for fill the schedule demo form
	@Test(priority = 2)
	public void test_02_Schedule_Demo() throws IOException, InterruptedException {
		// This test case is for the validate the page title
		entrat_Action = new Entrata_Actions(driver, logger);
		entrat_Action.schedule_Demo();

	}

	// This test case is for identify the broken links from Entrata.com site
	//@Test(priority = 3)
	public void test_03_Broken_Link() throws IOException, InterruptedException {

		entrat_Action = new Entrata_Actions(driver, logger);
		entrat_Action.Broken_Link();
	}

	// This test case is for Select the job profile from the Career page
	//@Test(priority = 4)
	public void test_04_Careers_page() throws IOException, InterruptedException {

		entrat_Action = new Entrata_Actions(driver, logger);
		entrat_Action.Careers_page();
	}
}
