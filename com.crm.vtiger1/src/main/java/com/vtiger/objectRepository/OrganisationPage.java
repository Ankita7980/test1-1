package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	//initialization
		public OrganisationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
		public WebElement getAddorganisationicon() {
			return addorganisationicon;
		}

		//Declaration
		@FindBy(xpath="//img[@title='Create Organization...']")
				private WebElement addorganisationicon;
		
		
		//business logic
		
		public void clickOnAddOrganizationButton()
		{
			addorganisationicon.click();
			
		}
		

}
