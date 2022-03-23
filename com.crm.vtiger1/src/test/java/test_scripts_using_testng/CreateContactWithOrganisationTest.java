package test_scripts_using_testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vitiger.comcast.generalUtility.BaseClass;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreatingNewContactpage;
import com.vtiger.objectRepository.CreatingNewOrganizationpage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OrganisationPage;
import com.vtiger.objectRepository.OrganizationInformationPgae;

public class CreateContactWithOrganisationTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContactWithOrganisationTest() throws Throwable
	{
		int randomnumber = jutil.getRanDomNumber();
		String orgname = eutil.getDataFromExcel("Sheet1", 1, 0)+randomnumber;
		String contactname = eutil.getDataFromExcel("Sheet1", 4, 2)+randomnumber;
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
        Assert.fail();
        
        
        //getting home page
        
        
        homepage.clickOncontactLink();
        
        ContactPage contactpage=new ContactPage(driver);
        contactpage.clickOnAddcontactButton();
        
        CreatingNewContactpage contactpage1=new CreatingNewContactpage(driver);
        
        
        contactpage1.addOrganizationToTheContact(driver, contactname, orgname);
	}


}
