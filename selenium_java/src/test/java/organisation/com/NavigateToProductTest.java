package organisation.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateToProductTest {

	public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream("./src/main/resources/externaldata/data1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
			
		Sheet sheet = wb.getSheet("Sheet1");
			int rowcount = sheet.getLastRowNum();
			int coulumncount=sheet.getRow(0).getLastCellNum();
			System.out.println("total number of row "+rowcount);
			System.out.println("total number of coulmn "+coulumncount);
			
			for (int i = 0; i <= rowcount; i++) {
				for (int j = 0; j <coulumncount ; j++) {
					{
						Row row = sheet.getRow(i);
							Cell cell = row.getCell(j);
							String data = cell.getStringCellValue();
							System.out.println(data+" ");
					}
					System.out.println();
					
				}
			}
			System.out.println("============================================");
			String orgname=sheet.getRow(1).getCell(2).getStringCellValue();
			System.out.println("organistaion name is :"+orgname);
			FileInputStream fil=new FileInputStream("./src/main/resources/externaldata/data.properties");
			Properties p = new Properties();
			p.load(fil);
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
			driver.findElement(By.xpath("//a[text()='Products']")).click();
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			Random r = new Random();
			int randomnum = r.nextInt(1000);
			orgname=orgname+randomnum;
			driver.findElement(By.name("productname")).sendKeys(orgname);
			
			
			driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
			System.out.println("product is is created==========================");
			Thread.sleep(4000);
			Actions act=new Actions(driver);
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			act.moveToElement(ele).build().perform();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Sign Out")).click();
	}

	}


