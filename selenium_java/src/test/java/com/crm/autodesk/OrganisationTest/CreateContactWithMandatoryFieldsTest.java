package com.crm.autodesk.OrganisationTest;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vitiger.comcast.generalUtility.BaseClass;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreatingNewContactpage;
import com.vtiger.objectRepository.HomePage;

public class CreateContactWithMandatoryFieldsTest extends BaseClass {
	@Parameters("browsername")
	@Test(groups = "regressionTest")
	public void createContactWithMandatoryFields() throws Throwable
	{
		int randomnumber = jutil.getRanDomNumber();
		String contactname = eutil.getDataFromExcel("Sheet1", 4, 2)+randomnumber;
		  HomePage homepage=new HomePage(driver);
	         homepage.clickOncontactLink();
	         
	         ContactPage contactpage=new ContactPage(driver);
	         contactpage.clickOnAddcontactButton();
	         
	         CreatingNewContactpage contactpage1=new CreatingNewContactpage(driver);
	         
	         contactpage1.createNewContact(contactname);
	         
	         ContactInformationPage contact=new ContactInformationPage(driver);
	         String expectedorganisationtest = contact.getContactText();
	         
	         if(expectedorganisationtest.contains(contactname))
	         {
	        	 System.out.println("contact is created============test is passed");
	         }
	         else
	         {
	        	 System.out.println("contact is not created===========test is failed");
	         }
	}
	

}
