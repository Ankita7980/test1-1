package hard_coded_Test_Scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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

public class CreateCompaignTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./src/main/resources/externaldata/data1.xlsx");
				
				Workbook wb = WorkbookFactory.create(fis);
				
					String orgname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
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
					Thread.sleep(4000);
					Actions act=new Actions(driver);
					WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
					act.moveToElement(ele).build().perform();
					Thread.sleep(5000);
					driver.findElement(By.name("Campaigns")).click();
				
					
					System.out.println("=======comapign is created");
					driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
					Random r = new Random();
					int randomnum = r.nextInt(1000);
					orgname=orgname+randomnum;
					driver.findElement(By.name("campaignname")).sendKeys(orgname);
					String parentWindow = driver.getWindowHandle();
					driver.findElement(By.xpath("//img[@title='Select']")).click();
					 Set<String> alltWindows = driver.getWindowHandles();
					 for (String windo : alltWindows) {
						if (!(windo.equals(parentWindow))) {
							driver.switchTo().window(windo);
							break;
						}
					}
					 driver.findElement(By.xpath("//a[text()='india197']")).click();
					 
					 driver.switchTo().window(parentWindow);
					

					//WebElement address = driver.findElement(By.xpath("//img[@title='Select']"));
					//address.click();
					//Select s=new Select(address);
					//s.selectByVisibleText("india197");
					
					driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
					//System.out.println("compaign is created=================");


			}

}
