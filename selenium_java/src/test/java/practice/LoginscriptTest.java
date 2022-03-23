package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginscriptTest {
	
	public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis=new FileInputStream("./src/main/resources/externaldata/data.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		WebDriver driver=null;
	
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			System.out.println("launched browser is:"+browser);
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("specify the browser name");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		

		
		
	}

}
