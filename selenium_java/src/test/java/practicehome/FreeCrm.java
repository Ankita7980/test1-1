package practicehome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vitiger.comcast.generalUtility.ExcelUtility;
import com.vitiger.comcast.generalUtility.FileUtility;
import com.vitiger.comcast.generalUtility.JavaUtility;
import com.vitiger.comcast.generalUtility.WebDriverUtility;

public class FreeCrm {

	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
                 FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		int randomnumber=jLib.getRanDomNumber();
		System.out.println("given random number is "+randomnumber);
		String product = eLib.getDataFromExcel("Sheet1", 5, 0)+randomnumber;
		String contactname = eLib.getDataFromExcel("Sheet1", 4, 2)+randomnumber;
		System.out.println(product);
		System.out.println(contactname);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.freecrm.com/");
		wLib.waitForPageToLoad(driver);
		driver.findElement(By.name("email")).sendKeys("adkr3815@gmail.com");
		driver.findElement(By.name("password")).sendKeys("99papA@34");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		WebElement element = driver.findElement(By.xpath("//span[text()='Contacts']"));
		wLib.mouseOverOnElemnet(driver, element);
		driver.findElement(By.xpath("(//i[@class='plus inverted icon'])[2]")).click();
		driver.findElement(By.name("first_name")).sendKeys(contactname);
		driver.findElement(By.name("last_name")).sendKeys(product);
		driver.findElement(By.className("save icon")).click();
		

	}

}
