package test_scripts_using_testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vitiger.comcast.generalUtility.BaseClass;
import com.vtiger.objectRepository.CampaignInformationpage;
import com.vtiger.objectRepository.CompaignPage;
import com.vtiger.objectRepository.CreatingNewCampaignPage;
import com.vtiger.objectRepository.HomePage;

public class CreateCompaignTest extends BaseClass {
	@Parameters("browsername")
	@Test(groups = "smokeTest")
	public void createCompaignTest() throws Throwable
	{
		int randomnumber = jutil.getRanDomNumber();
		String contactname = eutil.getDataFromExcel("Sheet1", 4, 2)+randomnumber;
		 
        //getting home page
        
        HomePage homepage=new HomePage(driver);
        homepage.clickOnCompaign(driver);
        
        CompaignPage compaign=new CompaignPage(driver);
        compaign.clickOncompaignButton();
        
        CreatingNewCampaignPage ap=new CreatingNewCampaignPage(driver);
        ap.CreatingNewCampaign(contactname);
        
        CampaignInformationpage compaigninfo=new CampaignInformationpage(driver);
        String expectedorganisationtest =compaigninfo.getcompaignText();
        
        if(expectedorganisationtest.contains(contactname))
        {
       	 System.out.println("compaign is created============test is passed");
        }
        else
        {
       	 System.out.println("compaign is not created===========test is failed");
        }
		
	}
	@Test
	public void regionalRegressionTesting()
	{
		System.out.println("this is only for reginal regression testing");
	}

}
