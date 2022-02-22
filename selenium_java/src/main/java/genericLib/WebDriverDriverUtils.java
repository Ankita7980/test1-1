package genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverDriverUtils {
	
	public void dropDown(WebElement ele, String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	public void mouseHover(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	

}
