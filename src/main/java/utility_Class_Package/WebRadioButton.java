package utility_Class_Package;

import java.util.List;

import org.openqa.selenium.WebElement;

public class WebRadioButton {
	public static void radioTest(List<WebElement> element, String value) {
		for(WebElement radiobtns: element) {
			String radio = radiobtns.getAttribute(value);
			if(radio.equals(value)) {
				if(!radiobtns.isSelected()) {
					radiobtns.click();
				}
				else {
					if (radiobtns.isSelected()) {
						radiobtns.click();
					}
				}
			}
		}
	}

}
