package practice;

import org.testng.annotations.Test;

public class DataProviderTest {
	
	
	@Test(dataProvider="getData")
	public void multipleData(String name,String company,String emailid,String empid)
	{
		System.out.println(name);
		System.out.println(company);
		System.out.println(emailid);
		System.out.println(empid);
		System.out.println("==============================");
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] getData()
	{
		Object[][] objectarray = new Object[2][4];
		objectarray[0][0]="adarsh";
		objectarray[0][1]="tyss banglore";
		objectarray[0][2]="adarsh@gmail.com";
		objectarray[0][3]="emp001";
		
		objectarray[1][0]="nitesh";
		objectarray[1][1]="tyss banglore";
		objectarray[1][2]="nitesh@gmail.com";
		objectarray[1][3]="emp002";
		return objectarray;
		
	}
	
	
	
	
	

	
}
