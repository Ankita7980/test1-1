package test_scripts_using_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vitiger.comcast.generalUtility.ExcelUtility;
import com.vitiger.comcast.generalUtility.FileUtility;
import com.vitiger.comcast.generalUtility.JavaUtility;
import com.vitiger.comcast.generalUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCompaignTest {
	public static void main(String[] args) throws Throwable {
		
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
                 FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		int randomnumber=jLib.getRanDomNumber();
		System.out.println("given random number is "+randomnumber);
		String product = eLib.getDataFromExcel("Sheet1", 5, 0)+randomnumber;
		String contactname = eLib.getDataFromExcel("Sheet1", 4, 2)+randomnumber;
		System.out.println(product);
		System.out.println(contactname);
		 String BROWER = fLib.getPropertyKeyValue("browser");
		 String URL = fLib.getPropertyKeyValue("url");
		 String USERNAME = fLib.getPropertyKeyValue("username");
		 String PASSWORD = fLib.getPropertyKeyValue("password");
		 System.out.println(BROWER);
		 System.out.println(URL);
		 System.out.println(USERNAME);
		 System.out.println(PASSWORD);
         WebDriver driver = null;
         if(BROWER.equals("chrome")) {
        	 WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
         }else if(BROWER.equals("firefox")){
        	  driver = new FirefoxDriver();
         }else if(BROWER.equals("ie")){
       	  driver = new InternetExplorerDriver();
        }else {
            driver = new ChromeDriver();
        }
         wLib.waitForPageToLoad(driver)              ;
         driver.get(URL);
         driver.manage().window().maximize();
                  /* step 1 : login to APP */ 
                  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
                  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
                  driver.findElement(By.id("submitButton")).click();
                  driver.findElement(By.xpath("//a[text()='Products']")).click();
                  driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
                  driver.findElement(By.name("productname")).sendKeys(product);
                  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
                   WebElement headerWb = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
                   wLib.waitForElementToBeClickAble(driver, headerWb);
                  WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
                  wLib.mouseOverOnElemnet(driver, element);
                  
                  driver.findElement(By.name("Campaigns")).click();
                  driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
                  driver.findElement(By.name("campaignname")).sendKeys(contactname);
                  
                  driver.findElement(By.xpath("//img[@title='Select']")).click();
                  wLib.swithToWindow(driver, "Products");
                  driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(product);
                  driver.findElement(By.xpath("//input[@name='search']")).click();
                  driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
                  wLib.swithToWindow(driver, "Campaigns");
                  
                  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
                  
                  
             
                 wLib.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
                 driver.findElement(By.linkText("Sign Out")).click();
                 driver.close();
                  
                  

	}


}
