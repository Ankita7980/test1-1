package practicehome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vitiger.comcast.generalUtility.BaseClass;
import com.vtiger.objectRepository.HomePage;

public class ClickOnAllCheckBoxTest extends BaseClass {
	
	
	
	@Test()
	public void clickonalltextbox() throws Throwable
	{
		HomePage homepage=new HomePage(driver);
		homepage.clickOncontactLink();
		List<WebElement> allelement = driver.findElements(By.xpath("//input[@type='checkbox'  and  contains(@name,'selected_id')]"));
		
		for (WebElement Element : allelement) {
			
			Element.click();
			Thread.sleep(5000);
			System.out.println("====================");
		}
	}

}
