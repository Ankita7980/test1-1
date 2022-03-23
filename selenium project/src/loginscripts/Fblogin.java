package loginscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fblogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("email")).sendKeys("12345");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.name("login")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Facebook-log in or sign up"))
				{
					System.out.println("passs:home page is diplayed");
				}
		
		// TODO Auto-generated method stub

	}

}
