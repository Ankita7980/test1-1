package practicehome;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author aman
 *
 */

public class WebDriverUtility {
	
	public void waitforpageToLoad(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void waitforpagetoloadexplicitwait(WebDriver driver,WebElement element)
	{
		WebDriverWait  wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void switchtowindow(WebDriver driver, String partailpagetitle)
	{
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
					String wid = it.next();
					driver.switchTo().window(wid);
					String currentpagetitle = driver.getTitle();
					if(currentpagetitle.contains(partailpagetitle))
					{
						break;
					}
			}
			
		
				
				
	}
	public void alartPopupaccepted(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public static void main(String[] args) {
		WebDriverUtility w=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		w.maximizeTheWindow(driver);
		
	}
	public void alartdismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void selectByIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
		
	}
	public void selectByvisibletext(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void javaScriptExectutor(WebDriver driver,String javascript)
	{
		JavascriptExecutor js=(JavascriptExecutor )driver;
		js.executeAsyncScript(javascript, null);
	}
	public void takescreenshot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotname+".png");
		Files.copy(src, dest);
	}

}
