package utility_Class_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebMouseOperation {

	public static void moveToElement(WebDriver driver, WebElement element) {
		if (WebElementCommon.isClickable(element)) {
			new Actions(driver).moveToElement(element).perform();
		}

	}
	public static void moveToElementClick(WebDriver driver, WebElement element) {
		if (WebElementCommon.isClickable(element)) {
			new Actions(driver).moveToElement(element).click().perform();
		}

	}
	public static void moveToElementDoubleClick(WebDriver driver, WebElement element) {
		if (WebElementCommon.isClickable(element)) {
			new Actions(driver).moveToElement(element).doubleClick().perform();
		}

	}
}
