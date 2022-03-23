package contact.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vitiger.comcast.generalUtility.ExcelUtility;
import com.vitiger.comcast.generalUtility.FileUtility;
import com.vitiger.comcast.generalUtility.JavaUtility;
import com.vitiger.comcast.generalUtility.WebDriverUtility;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreatingNewContactpage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
/**
 * 
 * @author aman
 *
 */
public class CreateContactWithMandatoryFieldsWithNotifyOwnerCheckBoxTest {

	public static void main(String[] args) throws Throwable {
		//creating object for utilities
				JavaUtility jLib = new JavaUtility();
				WebDriverUtility wLib = new WebDriverUtility();
		                 FileUtility fLib = new FileUtility();
				ExcelUtility eLib = new ExcelUtility();
				int randomnumber=jLib.getRanDomNumber();
				System.out.println("given random number is "+randomnumber);
				//get data from excel sheet
			
				String contactname = eLib.getDataFromExcel("Sheet1", 4, 2)+randomnumber;
				
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
		         //getting contact page
		         
		         ContactPage contactpage=new ContactPage(driver);
		         contactpage.clickOnAddcontactButton();
		         //creating new contact page
		         
		         CreatingNewContactpage contactpage1=new CreatingNewContactpage(driver);
		         
		         contactpage1.createNewContactWithnotifyownerckbox(contactname);
		         
		         
					  ContactInformationPage contact=new ContactInformationPage(driver);
					  
					String expectedorganisationtest = contact.getContactText();
					 
					  if(expectedorganisationtest.contains(contactname))
					  {
					 System.out.println("contact is created with notify owner============test is passed"); } else {
					  System.out.println("contact is not created===========test is failed"); }
					  homepage.signoutFromApplication(driver);
					 
		         
		}


	}


