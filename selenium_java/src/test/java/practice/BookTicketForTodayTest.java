package practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.vitiger.comcast.generalUtility.WebDriverUtility;

public class BookTicketForTodayTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		
		driver.findElement(By.xpath("//p[text()='Pune, India']")).click();
		
		driver.findElement(By.xpath("//p[text()='Kolkata, India']")).click();
		LocalDateTime dateandtime=LocalDateTime.now();
		
		String month=dateandtime.getMonth().toString();
	
		int date=dateandtime.getDayOfMonth();
	
		int year=dateandtime.getYear();
		
		String actualmonth=month.substring(0,1)+month.substring(1).toLowerCase();
		String monthAndYear=actualmonth+" "+year;
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String path = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		driver.findElement(By.xpath(path)).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		for(WebElement alloptions:elements)
		{
			System.out.println(alloptions.getText());
		}

		
		

	}

}
