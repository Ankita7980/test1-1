package practicehome;

import com.vitiger.comcast.generalUtility.ExcelUtility;

public class Test10 {

	public static void main(String[] args) throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		for(int i=1;i<=3;i++)
		{
			int j=1;
			String data1 = elib.getDataFromExcel("Sheet1", i, j);
			System.out.println(data1);
		}
		
	}

}
