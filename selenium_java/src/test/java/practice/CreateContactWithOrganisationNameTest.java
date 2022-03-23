package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganisationNameTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
FileInputStream fis=new FileInputStream("./src/main/resources/externaldata/data1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		String orgname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String contact=wb.getSheet("Sheet1").getRow(5).getCell(2).getStringCellValue();
		System.out.println("contact is created:"+contact);
		
		System.out.println("orgnaisation name is: "+orgname);
		FileInputStream fil=new FileInputStream("./src/main/resources/externaldata/data.properties");
		Properties p = new Properties();
		p.load(fil);
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		Random randnum=new Random();
		int rand = randnum.nextInt(1000);
		orgname=orgname+rand;
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
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
	
		System.out.println("organistaion is created==========================");
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contact);
		String parentwindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allwindow = driver.getWindowHandles();
		for (String window : allwindow) {
			if(!(window.equals(parentwindow)))
			{
				driver.switchTo().window(window);
				break;
			}
			
		}
	

		
		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
		String actheadermsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actheadermsg.contains(contact))
		{
			System.out.println(contact +"is verified======paasss");
		}
		else
		{
			System.out.println(contact +"is not verified======fail");
		}
		
		
	}


	}


