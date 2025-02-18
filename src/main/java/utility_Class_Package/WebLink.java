package utility_Class_Package;

import org.openqa.selenium.WebElement;

public class WebLink {
	public static void webLink(WebElement element) {
		if(WebElementCommon.isClickable(element)) {
			element.click();
		}
	}

}
