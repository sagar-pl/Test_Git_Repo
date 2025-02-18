package utility_Class_Package;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebScreenshot {
	public static String getScreenshot(WebDriver driver, String screenShotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + screenShotName + dateName + ".jpg";
		File finalDestination = new File(destination);
		FileUtils.copyFile(Source, finalDestination);		
		return destination;
	}

}
