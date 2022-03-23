package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Calndertest1Test {

	public static void main(String[] args) throws InterruptedException {
		String monthandyear="June 2022";
		String date="21";
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.makemytrip.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			act.moveByOffset(10, 10).click().perform();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
			Thread.sleep(5000);
			
			String path = "//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
			
			
			for(;;){
			try {
				driver.findElement(By.xpath(path)).click();
				break;
				
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			
			
			

	}

}
}
