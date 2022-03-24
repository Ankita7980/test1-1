package com.crm.autodesk.OrganisationTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vitiger.comcast.generalUtility.BaseClass;
import com.vtiger.objectRepository.CreatingNewOrganizationpage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OrganisationPage;
import com.vtiger.objectRepository.OrganizationInformationPgae;
@Listeners(com.vitiger.comcast.generalUtility.ListenerImplementationClass.class)
public class CreateOrganisationWithIndustryTypeTest extends BaseClass {
	
	@Test(groups = "smokeTest")
	public void createOrganisationWithIndustryType() throws Throwable
	{
			int randomnumber = jutil.getRanDomNumber();
			String orgname = eutil.getDataFromExcel("Sheet1", 1, 0)+randomnumber;
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
	}

}
