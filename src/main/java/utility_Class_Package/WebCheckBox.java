package utility_Class_Package;

import java.util.List;

import org.openqa.selenium.WebElement;

public class WebCheckBox {
	public static void checkBoxTest(List<WebElement> element) {
		for(WebElement checkBox: element) {
			if(!checkBox.isSelected()) {
				checkBox.click();
			}else {
				if(checkBox.isSelected()) {
					checkBox.click();
				}
			}
		}
		
	}

}
