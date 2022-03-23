package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitiger.comcast.generalUtility.WebDriverUtility;

public class CreatingNewOrganizationpage extends WebDriverUtility {
	
	public CreatingNewOrganizationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement OrganizationNameTextBox;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveIcon;


	public WebElement getOrganizationNameTextBox() {
		return OrganizationNameTextBox;
	}


	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}


	public WebElement getSaveIcon() {
		return saveIcon;
	}
	
	//business logic
	public void createOrganisation(String orgname,String text)
	{
		OrganizationNameTextBox.sendKeys(orgname);
		select(industryDropDown, text);
		saveIcon.click();
		
	}
	public void createNewOrganisation(String orgname)
	{
		OrganizationNameTextBox.sendKeys(orgname);
		saveIcon.click();
	}

}
