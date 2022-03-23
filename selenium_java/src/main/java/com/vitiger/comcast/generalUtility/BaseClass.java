package com.vitiger.comcast.generalUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver=null;
	public FileUtility futil=new  FileUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public JavaUtility jutil=new JavaUtility();
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void bs()
	{
		System.out.println("data base connection");
	}
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void bt()
	{
		System.out.println("execute script in parrel mode");
	}
	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void bc() throws Throwable
	{
		String browsername=futil.getPropertyKeyValue("browser");
		String url=futil.getPropertyKeyValue("url");
		if(browsername.equalsIgnoreCase("Chrome"))
{
	
	driver=new ChromeDriver();
} else if(browsername.equalsIgnoreCase("Firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}else {
	throw new Exception("browser is not compactiable");
}		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sdriver=driver;
		
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void bm() throws Throwable
	{
		String username=futil.getPropertyKeyValue("username");
		String password=futil.getPropertyKeyValue("password");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void am()
	{
		HomePage homepage=new HomePage(driver);
		homepage.signoutFromApplication(driver);
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void ac()
	{
		driver.quit();
	}
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void at()
	{
		System.out.println("close parrel mode execution");
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void as()
	{
		System.out.println("close database connection");
	}
}
