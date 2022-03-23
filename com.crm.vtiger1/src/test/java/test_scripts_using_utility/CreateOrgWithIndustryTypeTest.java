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

public class CreateOrgWithIndustryTypeTest {
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
                 FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		int randomnumber=jLib.getRanDomNumber();
		System.out.println("given random number is "+randomnumber);
		String orgname = eLib.getDataFromExcel("Sheet1", 1, 0)+randomnumber;
		String contactname = eLib.getDataFromExcel("Sheet1", 4, 2)+randomnumber;
		System.out.println(orgname);
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
                  /* step 1 : navigate to Org Page */ 
                  driver.findElement(By.linkText("Organizations")).click();

                  /* step 2 :  navigate to CREATE  Org Page*/ 
                  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
                  /* step 3 : create a new Org */
                  driver.findElement(By.name("accountname")).sendKeys(orgname);
                 WebElement element = driver.findElement(By.name("industry"));
                 wLib.select(element, "Healthcare");
                  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

                  String headerWb = driver.findElement(By.className("dvHeaderText")).getText();
                  if(headerWb.contains(orgname))
                  {
                	  System.out.println("organisation is created==============test is passs");
                  }
                  else
                  {
                	  System.out.println("test is fail===============");
                  }
                  wLib.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
                  driver.findElement(By.linkText("Sign Out")).click();
                  driver.close();

	}


}
