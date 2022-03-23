package practice;

import org.testng.annotations.Test;

public class DependsOnMethodTest {
	
	@Test()
	public void createAccount() throws Exception 
	{
		System.out.println("login");
		System.out.println("create contact");
		System.out.println("logout");
		throw new Exception();
		
	}
	
	@Test(dependsOnMethods = "createAccount")
	public void modifyAccount()
	{
		System.out.println("login");
		System.out.println("modify account");
		System.out.println("logout");
	}
	@Test(dependsOnMethods = "modifyAccount")
	public void deleteAccount()
	{
		System.out.println("login");
		System.out.println("delete account");
		System.out.println("logout");
	}

}
