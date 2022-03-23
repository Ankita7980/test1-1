package practicehome;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	public int getRandomNumber()
	{
		Random rand=new Random();
		int randnum = rand.nextInt(10000);
		return randnum;
	}
	
	public String getSystemDateAndTime()
	{
		Date date=new Date();
		return date.toString();
	}
	public String getDateInFormat()
	{
		Date date=new Date();
		String d1 = date.toString();
		String YYYY = d1.split(" ")[5];
		String DD = d1.split(" ")[2];
		int mm = date.getMonth()+1;
		String finalformat = YYYY+"-"+DD+"-"+mm;
		return finalformat;
	}
	public static void main(String[] args) {
		
		JavaUtility jl=new JavaUtility();
		System.out.println(jl.getSystemDateAndTime());
		System.out.println(jl.getRandomNumber());
		System.out.println(jl.getDateInFormat());
		
		
	}

}
