package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithDataProviderTest {
	
	
	
	@Test(dataProvider="getData")
	public void createContact(String name, String mobilenumber)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(mobilenumber);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objectarray = new Object[2][2];
		objectarray[0][0]="aman";
		objectarray[0][1]="9934949554";
		
		objectarray[1][0]="ankita";
		objectarray[1][1]="9934949567";
		
		return objectarray;
		
	}

}
