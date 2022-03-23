package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {
	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="campaignname")
	private WebElement campaignnameTextBox;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveIcon;

	public WebElement getCampaignnameTextBox() {
		return campaignnameTextBox;
	}

	public WebElement getSaveIcon() {
		return saveIcon;
	}
	
	public void CreatingNewCampaign(String orgname)
	{
		campaignnameTextBox.sendKeys(orgname);
		saveIcon.click();
		
	}

}
