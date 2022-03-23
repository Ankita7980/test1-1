package practicehome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.objectRepository.LoginPage;

public class DataProvider {
	
	
	
	@Test(dataProvider="multiplecreditanials")
	public void login(String username, String password)
	{
		WebDriver driver = null;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		LoginPage login=new LoginPage(driver);
		login.login(username, password);
	}
	
	
	
	
	
	
	@org.testng.annotations.DataProvider()
	public Object[][] multiplecreditanials()
	{
			Object [][]	objectarry=new Object[2][2];
				
			objectarry [0][0]="username";
			objectarry[0][1]="passowrd";
			
			objectarry [1][0]="aman";
			objectarry [1][1]="jha";
			return objectarry;
			
	

}
}
