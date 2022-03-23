package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgBasics {
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
	}
	@Test(priority=1)
	public void verfiyTitleTest()
	{
	    String title = driver.getTitle();
	    System.out.println("the page title is: "+title);
	    Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	
	}
	@Test(priority=2)
	public void verifyLogo()
	{
		 boolean flag = driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).isDisplayed();
		 Assert.assertTrue(flag);
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
