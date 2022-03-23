package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CleartripTest {

	public static void main(String[] args) {
		String monthandyear="June 2022";
		String date="10";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String path = "(//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='"+date+"']";
		for(;;){
		try {
			driver.findElement(By.xpath(path)).click();
			driver.findElement(By.xpath("//span[text()='Done']")).click();
			break;

			
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
	}

}
}
