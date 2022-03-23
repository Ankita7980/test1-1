package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T0 {

	public static void main(String[] args) {
			
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/mozilla/geckodriver/releases");

	}

}
