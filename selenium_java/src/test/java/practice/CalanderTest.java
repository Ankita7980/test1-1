package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalanderTest {

	public static void main(String[] args) {
		String monthAndYear="May 2022"	;
		String date="8";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	Actions act=new Actions(driver);
	act.moveByOffset(10, 10).click().perform();
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	String path = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	for(;;){
	try {
		driver.findElement(By.xpath(path)).click();
		
	} catch (Exception e) {
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	}
	

	}

}
}