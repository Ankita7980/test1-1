package practice;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertaionTest {
	
	@Test
	public void verify()
	{
		String name1="aman";
		String name2="aman";
		Assert.assertEquals(name1, name2);
	}
	@Test
	public void verify1()
	{
		String name1="aman";
		String name2="aman";
		Assert.assertEquals(name1, name2);
	}
	@Test
	public void verify2() {
		int a=10;
		int b=10;
		Assert.assertEquals(a, b);
	}
	@Test
	public void verify3() {
		boolean a=true;
		boolean b=true;
		Assert.assertEquals(a, b);
	}
	@Test
	public void verify4() {
		byte a=10;
		byte b=20;
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(a, b);
		sa.assertAll();
	}
	@Test
	public void verify5() {
		double a=3.4;
		double b=4.5;
		Assert.assertEquals(a, b);
		
	}

	
	

}
