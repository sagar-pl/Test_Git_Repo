package utility_Class_Package;

import org.openqa.selenium.WebElement;


public class WebTextBox {
	public static void sendInput(WebElement textBox, String text) {
		// This method send text to TextBox
		if(WebElementCommon.isPresent(textBox)) {
				textBox.sendKeys(text);	
		}
		
	}
	
}
