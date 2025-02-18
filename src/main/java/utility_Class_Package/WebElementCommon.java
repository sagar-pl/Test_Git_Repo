package utility_Class_Package;
import org.openqa.selenium.WebElement;

public class WebElementCommon {
	public static boolean isPresent(WebElement element) {
		//As a user, I want to check whether element is present in DOM.
		boolean isPre =  false;
		if(element.isDisplayed()) {
			isPre = true;
		}return isPre;
		
	}
	public static boolean isClickable(WebElement element) {
		//As a user, I want to check whether element is clickble or Not
		boolean isclick =  false;
		if(isPresent(element)) {
			if(element.isEnabled()) {
				isclick = true;
			}
		}return isclick;
	}
	public static boolean clearField(WebElement element) {
		//As a user, I want to clear text Box.
		boolean isClear = false;
		if(isPresent(element)) {
			element.clear();
		}return isClear;
	}
	public static boolean isSelected(WebElement element) {
		// As a user, I want to check whether element is selected or not.
		boolean isSelect = false;
		if(isPresent(element)) {
			if(element.isSelected()) {
				isSelect = true;
			}
		}return isSelect;
			
	}
	

}
