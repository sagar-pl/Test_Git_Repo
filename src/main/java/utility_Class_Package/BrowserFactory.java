package utility_Class_Package;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import dataSources.PropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	private static WebDriver driver;

	public static WebDriver setBrowser() throws IOException {
		final String browserName = PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "browser");

		switch (browserName) {
		case "Chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--window-size=1920,1080"); // Set specific window size
			chromeOptions.addArguments("--remote-allow-origins=*");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}

		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
