package loginscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom {
	
	@FindBy(id="email")
	private WebElement usernametb;
	@FindBy(id="pass")
	private WebElement passwrdtb;
	@FindBy(name="login")
	private WebElement logintb;
	
	Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void usernametab(String name)
	{
		usernametb.sendKeys("aman");
	}
	public void passwrdtab(String name)
	{
		passwrdtb.sendKeys("jha");
	}
	public void logintab()
	{
		logintb.click();
	}
}
