package practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TodaysDateTest {

	public static void main(String[] args) {
		LocalDateTime dateandtime=LocalDateTime.now();
	
		String month=dateandtime.getMonth().toString();
	
		int date=dateandtime.getDayOfMonth();
	
		int year=dateandtime.getYear();
		
		String actualmonth=month.substring(0,1)+month.substring(1).toLowerCase();
		String monthAndYear=actualmonth+" "+year;
	
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String path = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		driver.findElement(By.xpath(path)).click();

}
}
