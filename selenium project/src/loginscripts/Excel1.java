package loginscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//String url=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		//String username=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		//String password=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		//driver.get(url);
		//driver.findElement(By.id("email")).sendKeys(username);
		//driver.findElement(By.id("pass")).sendKeys(password);
		String url1=wb.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		String word=wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(url1);
		driver.findElement(By.name("q")).sendKeys(word);
		
		

	}

}
