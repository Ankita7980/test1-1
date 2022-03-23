package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgBasics1 {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
	}
	@Test
	public void verifyTitleTest()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	@Test
	public void logodisplay()
	{
		boolean flag = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	
	@AfterMethod
	public void closeapp()
	{
		driver.quit();
	}

}
