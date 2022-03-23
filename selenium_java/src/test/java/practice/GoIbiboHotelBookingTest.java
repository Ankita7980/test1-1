package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.vitiger.comcast.generalUtility.WebDriverUtility;

public class GoIbiboHotelBookingTest {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/hotels/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys("Kolkata");
			driver.findElement(By.xpath("//ul[@id='downshift-1-menu']")).click();
		
		driver.findElement(By.xpath("//h4[text()='Mar 18, 2022']")).click();
		
		driver.findElement(By.xpath("//span[@data-testid='date_31_2_2022']")).click();
		driver.findElement(By.xpath("//span[@data-testid='date_9_3_2022']")).click();
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']")).click();
		
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.mouseOverOnElemnet(driver, driver.findElement(By.xpath("//span[text()='Rooms']")));
		driver.findElement(By.xpath("(//span[text()='+'])[3]")).click();
		
		
		
	}

}
