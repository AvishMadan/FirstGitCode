package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Coomonfunction {

	public void drpdown(WebElement bm, String visible) {
		Select month = new Select(bm); // select tag we used Select class
		month.selectByVisibleText(visible); // Method we used sbvt inside Select class
	}

}
