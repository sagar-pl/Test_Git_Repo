package utility_Class_Package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDropDown {

	//select the drop-down using "select by visible text".
		public static void selectByText(WebElement element, String VisibleText){
		Select selObj=new Select(element);
		selObj.selectByVisibleText(VisibleText);
		}

		//select the drop-down using "select by index".
		public static void selectByIndex(WebElement WE, int IndexValue){
		Select selObj=new Select(WE);
		selObj.selectByIndex(IndexValue);
		}

		//select the drop-down using "select by value".
		public static void selectByValue(WebElement WE, String Value){
		Select selObj=new Select(WE);
		selObj.selectByValue(Value);
		}

}
