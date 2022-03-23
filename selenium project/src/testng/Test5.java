package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test5 {

	
		
		WebDriver driver=null;
		@Parameters("browserName")
		@BeforeTest
		public void setup(String browserName)
		{
			System.out.println("browser name is===== :"+browserName);
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
			}
		}
			
			@Test
			public void test1() throws InterruptedException
			{
				driver.get("https://github.com/mozilla/geckodriver/releases");
				Thread.sleep(5000);
			}
		@AfterTest
		public void teardown() {
			driver.close();
			System.out.println("test complted successfully");
			
		}
		

	

}
