package organisationwithpomclass;

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
/**
 * 
 * @author aman
 *
 */
public class CreatingOrganisationWithIndustryTypeTest {

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
         create.createOrganisation(orgname, "Banking");
         
         OrganizationInformationPgae org=new OrganizationInformationPgae(driver);
         String expectedorganisationtest = org.getorganisationText();
         
         if(expectedorganisationtest.contains(orgname))
         {
        	 System.out.println("organisation is created============test is passed");
         }
         else
         {
        	 System.out.println("organisation is not created===========test is failed");
         }
         homepage.signoutFromApplication(driver);
         
         

	}

}
