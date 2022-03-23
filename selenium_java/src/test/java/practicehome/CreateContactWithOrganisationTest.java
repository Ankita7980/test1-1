package practicehome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vitiger.comcast.generalUtility.ExcelUtility;
import com.vitiger.comcast.generalUtility.FileUtility;
import com.vitiger.comcast.generalUtility.JavaUtility;
import com.vitiger.comcast.generalUtility.WebDriverUtility;
/**
 * 
 * @author aman
 * 
 *
 */
public class CreateContactWithOrganisationTest {

	public static void main(String[] args) throws Throwable {
	
		JavaUtility aman=new JavaUtility();
		ExcelUtility ankita=new ExcelUtility();
		FileUtility ap=new FileUtility();
		WebDriverUtility wp=new WebDriverUtility();
		int randnum = aman.getRanDomNumber();
		
		String orgname = ankita.getDataFromExcel("Sheet1", 1, 0)+randnum;
		System.out.println(orgname);
						String contact = ankita.getDataFromExcel("Sheet1", 4, 2)+randnum;
						System.out.println(contact);
						String browser = ap.getPropertyKeyValue("browser");
						String url = ap.getPropertyKeyValue("url");
						String username = ap.getPropertyKeyValue("username");
						String password = ap.getPropertyKeyValue("password");
						System.out.println(browser);
						System.out.println(url);
						System.out.println(username);
						System.out.println(password);
						WebDriver driver=null;
						if(browser.equalsIgnoreCase("chrome"))
						{
							driver=new ChromeDriver();
						}
						else if(browser.equalsIgnoreCase("firefox"))
						{
							driver=new FirefoxDriver();
						}
						else
						{
							 driver = new FirefoxDriver();
						}
						
						wp.waitForPageToLoad(driver);
						driver.get(url);
						driver.manage().window().maximize();
						/*login to app */
						  driver.findElement(By.name("user_name")).sendKeys(username);
		                  driver.findElement(By.name("user_password")).sendKeys(password);
		                  driver.findElement(By.id("submitButton")).click();
		                  /* navigate to organisation page */
		                  driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		                  /* navigate to create org page */
		                  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		                  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		                  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		                  WebElement headerWb = driver.findElement(By.className("dvHeaderText"));
		                  wp.waitForElementToBeClickAble(driver, headerWb);
		                  driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		                  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		                  driver.findElement(By.name("lastname")).sendKeys(contact);
		                  driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		                  wp.swithToWindow(driver, "Accounts");
		                  driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
		                  driver.findElement(By.name("search")).click();
		                  driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		                  wp.swithToWindow(driver, "Contacts");
		                  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		                  wp.mouseOverOnElemnet(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		                  driver.findElement(By.linkText("Sign Out")).click();
		                  driver.close();
		                  
						 
						 
						
						

	}

}
