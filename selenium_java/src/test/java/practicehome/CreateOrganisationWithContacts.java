package practicehome;
/**
 * 
 * @author aman
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vitiger.comcast.generalUtility.FileUtility;
import com.vitiger.comcast.generalUtility.WebDriverUtility;

public class CreateOrganisationWithContacts {
			

public static void main(String[] args) throws Throwable {
	ExcelUtility eu=new ExcelUtility();
	FileUtility fu=new FileUtility();
	JavaUtility ju=new JavaUtility();
	WebDriverUtility wu=new WebDriverUtility();
	
	int randnum = ju.getRandomNumber();
	String orgname = eu.getDataFromExcel("Sheet1", 1, 0)+randnum;
	String contact=eu.getDataFromExcel("Sheet1", 4, 2)+randnum;
	System.out.println(orgname);
	System.out.println(contact);
	String browser = fu.getPropertyKeyValue("browser");
	String url = fu.getPropertyKeyValue("url");
	String username= fu.getPropertyKeyValue("username");
	String password = fu.getPropertyKeyValue("password");
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
		driver=new ChromeDriver();
	}
	driver.get(url);
	driver.manage().window().maximize();
	wu.waitForPageToLoad(driver);
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	WebElement text = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	wu.waitForElementToBeClickAble(driver, text);
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(contact);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	wu.swithToWindow(driver, "Accounts");
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
	driver.findElement(By.xpath("//input[@name='search']")).click();
	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	wu.swithToWindow(driver, "Contacts");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	wu.mouseOverOnElemnet(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	
	
	
}
	


}
