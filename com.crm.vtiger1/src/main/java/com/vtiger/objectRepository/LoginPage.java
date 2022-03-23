package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//initialization of web elements
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		//Declaration of Web Elements
		
		@FindBy(name="user_name")
		private WebElement usernameTextField;
		
		@FindBy(name="user_password")
		private WebElement passwordTextField;
		
		
		@FindBy(id="submitButton")
		private WebElement loginButton;


		public WebElement getUsernameTextField() {
			return usernameTextField;
		}


		public WebElement getPasswordTextField() {
			return passwordTextField;
		}


		public WebElement getLoginButton() {
			return loginButton;
		}
		
		//business logic
		public void login(String username,String passowrd)
		{
			usernameTextField.sendKeys(username);
			passwordTextField.sendKeys(passowrd);
			loginButton.click();
		}
		
			
		}
		


