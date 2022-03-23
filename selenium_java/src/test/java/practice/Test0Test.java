package practice;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test0Test {

	public static void main(String[] args) throws InterruptedException {
		
		Random random=new Random();
		int rannum=random.nextInt(100);
		String orgname="tymantra_"+rannum;
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actual.contains(orgname))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
		Actions act=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		

	}

}
