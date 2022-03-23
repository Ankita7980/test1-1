package test_scripts_using_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vitiger.comcast.generalUtility.BaseClass;
import com.vtiger.objectRepository.CreatingNewOrganizationpage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OrganisationPage;
import com.vtiger.objectRepository.OrganizationInformationPgae;

public class CreateOrganisationTest extends BaseClass{
	@Test(groups = "regressionTest")
	public void createOrganisation() throws Throwable
	{						int randomnumber = jutil.getRanDomNumber();
		String orgname = eutil.getDataFromExcel("Sheet1", 1, 0)+randomnumber;
		//getting home page
        
        HomePage homepage=new HomePage(driver);
        homepage.clickOnOrganisationLink();
        
        //Organization page
       
        OrganisationPage orgpage=new OrganisationPage(driver);
        orgpage.clickOnAddOrganizationButton();
       
        
        //creating new organization page
        
        CreatingNewOrganizationpage create=new CreatingNewOrganizationpage(driver);
        create.createNewOrganisation(orgname);
        
        
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
        

}
}
