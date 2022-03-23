package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitiger.comcast.generalUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	//Initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//declaration
		@FindBy(xpath="//a[text()='Organizations']")
		private WebElement organizationlink;
		

		@FindBy(xpath="//a[text()='Contacts']")
		private WebElement Contactslink;
		
		@FindBy(xpath="//a[text()='Leads']")
		private WebElement Leadslink;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement signouticonimage;
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement signout;
		
		@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
		private WebElement morelink;
		@FindBy(name="Campaigns")
		private WebElement Campaignslink;
		

		public WebElement getCampaignslink() {
			return Campaignslink;
		}

		public WebElement getMorelink() {
			return morelink;
		}

		public WebElement getSignout() {
			return signout;
		}

		public WebElement getOrganizationlink() {
			return organizationlink;
		}

		public WebElement getContactslink() {
			return Contactslink;
		}

		public WebElement getLeadslink() {
			return Leadslink;
		}
		//Business logic
		/**
		 * this method will click on organization link
		 */
		
		public void clickOnOrganisationLink()
		{
			organizationlink.click();
			
		}
		public void clickOncontactLink()
		{
			Contactslink.click();
		}
		/**
		 * this method is used for sign out from the application
		 * @param driver
		 */
		
		public void signoutFromApplication(WebDriver driver)
		{
			mouseOverOnElemnet(driver, signouticonimage);
			signout.click();
		}
		public void clickOnCompaign(WebDriver driver)
		{
			mouseOverOnElemnet(driver,morelink );
			Campaignslink.click();
			
		}
		

}
