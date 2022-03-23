package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaignPage {
	//initialization
		public CompaignPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
		public WebElement getAddcompaignicon() {
			return addorganisationicon;
		}

		//Declaration
		@FindBy(xpath="//img[@title='Create Campaign...']")
				private WebElement addorganisationicon;
		
		
		//business logic
		
		public void clickOncompaignButton()
		{
			addorganisationicon.click();
			
		}

}
