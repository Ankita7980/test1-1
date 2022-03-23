package practice;

import java.util.List;

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
import com.vtiger.objectRepository.CreatingNewOrganizationpage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganisationPage;
import com.vtiger.objectRepository.OrganizationInformationPgae;

public class CreateOrganisationSearchFromListAndDeleteTest {

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
         homepage.clickOnOrganisationLink();
         
         //Organization page
        
         OrganisationPage orgpage=new OrganisationPage(driver);
         orgpage.clickOnAddOrganizationButton();
         
         //creating new organization page
         
         CreatingNewOrganizationpage create=new CreatingNewOrganizationpage(driver);
         create.createNewOrganisation(orgname);
         OrganizationInformationPgae orginfo=new OrganizationInformationPgae(driver);
         orginfo.waitforelement(driver, driver.findElement(By.className("dvHeaderText")));
         homepage.clickOnOrganisationLink();
       //  driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
        // WebElement element = driver.findElement(By.xpath("//select[@name='search_field']"));
         
       // wLib.select(element, "Organization Name");
        
        // driver.findElement(By.xpath("//input[@name='submit']")).click();
         
        // driver.findElement(By.xpath("(//a[text()='"+orgname+"'])[2]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//a[@title='Organizations']"));
        for(;;)
        {
        	elements.equals(orgname);
        	driver.findElement(By.xpath("(//a[text()='"+orgname+"'])[2]")).click();
        	
			
		}
        
         
         //driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
        // wLib.swithToAlertWindowAndAccpect(driver);
        // homepage.signoutFromApplication(driver);
         
        
        
         

	}

}
