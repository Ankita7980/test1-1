package com.vitiger.comcast.generalUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * it is used to generate random number
	 * @return int data
	 * 
	 */
		public int getRanDomNumber()
		{
			Random random=new Random();
			int intRandom = random.nextInt(2000);
			return intRandom;
		}
	/**
	 * used to get system date and time in Ist format
	 * @return
	 */
		public String getSystemDateAndTime()
		{
			Date date=new Date(0);
			return date.toString();
		}
	/**
	 * used to get system date in YYYY-MM-DD format
	 * @return
	 */
		public String getSystemDateWithFormat()
		{
			Date date=new Date(0);
			String DateAndTime = date.toString();
			String YYYY = DateAndTime.split(" ")[5];
			String DD=DateAndTime.split(" ")[2];
			int MM=date.getMonth()+1;
			String FinalFormat=YYYY+"-"+MM+"-"+DD;
			return FinalFormat;
		}
		
}
