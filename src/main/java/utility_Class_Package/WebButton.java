package utility_Class_Package;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebButton {
	public static void clickButton(WebElement element) {
		// This method performing click operation on WebButton
		if (WebElementCommon.isClickable(element)) {
			element.click();
		}
	}

	public static void JsclickButton(WebElement element, WebDriver driver) {
		try {
			WebElementCommon.isClickable(element);
			element.click();

		} catch (Exception e) {
			String javascript = "arguments[0].click()";
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript(javascript, element);
		}
	}
}
