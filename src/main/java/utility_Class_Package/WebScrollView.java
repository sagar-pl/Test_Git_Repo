package utility_Class_Package;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebScrollView {

	public static void scrollIntoView(WebDriver driver, WebElement element) {
		String javascript = "arguments[0].scrollIntoView();";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(javascript, element);
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		try {
			// Scroll the element into view
			String javascript = "arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'center' });";
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript(javascript, element);

			// Optionally, you can wait for the page to stabilize after scrolling
			Thread.sleep(500); // Adjust the delay as needed
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
