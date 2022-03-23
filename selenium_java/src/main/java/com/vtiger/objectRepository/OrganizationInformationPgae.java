package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitiger.comcast.generalUtility.WebDriverUtility;

public class OrganizationInformationPgae extends WebDriverUtility {
	public OrganizationInformationPgae(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement expectedOrganisationText;

	
	
	public String getorganisationText()
	{
		return expectedOrganisationText.getText();
	}
	
	

	public void waitforelement(WebDriver driver,WebElement element)
	{
		waitForElementToBeClickAble(driver, expectedOrganisationText);
	}

}
