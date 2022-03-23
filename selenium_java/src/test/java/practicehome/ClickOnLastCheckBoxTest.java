package practicehome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.vitiger.comcast.generalUtility.BaseClass;
import com.vitiger.comcast.generalUtility.ExcelUtility;
import com.vitiger.comcast.generalUtility.FileUtility;
import com.vitiger.comcast.generalUtility.JavaUtility;
import com.vitiger.comcast.generalUtility.WebDriverUtility;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

public class ClickOnLastCheckBoxTest extends BaseClass{
	
	public static void main(String[] args) throws Throwable {
		//creating object for utilities
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
                 FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		int randomnumber=jLib.getRanDomNumber();
		System.out.println("given random number is "+randomnumber);
		//get data from excel sheet
		String orgname = eLib.getDataFromExcel("Sheet1", 1, 0)+randomnumber;
		String contactname = eLib.getDataFromExcel("Sheet1", 4, 2)+randomnumber;
		System.out.println(orgname);
		System.out.println(contactname);
		//get data from property files
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
         
         //login to the application
         LoginPage login=new LoginPage(driver);
         login.login(USERNAME, PASSWORD);
         
         //getting home page
         
         HomePage homepage=new HomePage(driver);
         homepage.clickOncontactLink();
         List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox'  and contains(@name,'selected_id')]"));
        for (WebElement Element : elements) {
        	
        	String id = Element.getAttribute("id");
        	if(id.equals("100") || id.equals("98") || id.equals("89"))
        	{
        		Element.click();
        	}
		}
		
	}
}