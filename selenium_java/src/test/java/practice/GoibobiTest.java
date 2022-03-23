package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibobiTest {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/flights");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']")).click();
		for(;;){
		try {
			driver.findElement(By.xpath("//div[text()='May 2022']/ancestor::div[@class='DayPicker-Months']/descendant::div[text()='12']")).click();
			
		} catch (Exception e) {
			driver.findElement(By.className("c-pointer c-secondary-500")).click();
		}
		

	}

}
}
