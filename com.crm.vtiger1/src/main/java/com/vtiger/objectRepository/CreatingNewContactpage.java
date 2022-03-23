package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitiger.comcast.generalUtility.WebDriverUtility;

public class CreatingNewContactpage extends WebDriverUtility {
	private static final String orgname = null;

	public CreatingNewContactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="lastname")
	public WebElement lastnameTextBox;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveIcon;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement addorganizationimage;
	@FindBy(name="search_text")
	private WebElement searchbox;
	@FindBy(name="search")
	private WebElement Search;
	@FindBy(xpath="//input[@name='reference']")
	private WebElement refrencecheckbox;
	@FindBy(xpath="//input[@name='notify_owner']")
	private WebElement notifyownercheckbox;


	
	
	public WebElement getNotifyownercheckbox() {
		return notifyownercheckbox;
	}

	public WebElement getRefrencecheckbox() {
		return refrencecheckbox;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearch() {
		return Search;
	}

	public WebElement getAddorganizationimage() {
		return addorganizationimage;
	}

	public WebElement getLastnameTextBox() {
		return lastnameTextBox;
	}

	public WebElement getSaveIcon() {
		return saveIcon;
	}
	
	public void createNewContact(String contactname)
	{
		lastnameTextBox.sendKeys(contactname);
		saveIcon.click();
		
	}
	public void addOrganizationToTheContact(WebDriver driver,String contactname,String orgname) 
	{
		lastnameTextBox.sendKeys(contactname);
		addorganizationimage.click();
		swithToWindow(driver, "Accounts");
		
		searchbox.sendKeys(orgname);
		Search.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	
		swithToWindow(driver, "Contacts");
	
		saveIcon.click();
	}
	public void createNewContactWithRefrencecheckbox(String contactname)
	{
		
		lastnameTextBox.sendKeys(contactname);
		refrencecheckbox.click();
		saveIcon.click();
		
	}
	public void createNewContactWithnotifyownerckbox(String contactname)
	{
		lastnameTextBox.sendKeys(contactname);
		notifyownercheckbox.click();
		saveIcon.click();
	}
	


}
