package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//initialization
			public ContactPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
				
			}
			
			public WebElement getAddorganisationicon() {
				return addorganisationicon;
			}

			//Declaration
			@FindBy(xpath="//img[@title='Create Contact...']")
					private WebElement addorganisationicon;
			
			
			//business logic
			
			public void clickOnAddcontactButton()
			{
				addorganisationicon.click();
				
			}

}
