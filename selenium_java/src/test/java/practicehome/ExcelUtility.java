package practicehome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	
	
	public String getDataFromExcel(String SheetName, int rowName, int calName) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/main/resources/externaldata/data1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String data = wb.getSheet(SheetName).getRow(rowName).getCell(calName).getStringCellValue();
		 return data;
	}
	public static void main(String[] args) throws Throwable {
		ExcelUtility a=new ExcelUtility();
		String data = a.getExcelData("Sheet1", 1, 0);
		System.out.println(data);
		
	}
	
	
	public String getExcelData(String sheet,int row,int cell) throws Throwable
	{
		FileInputStream fil=new FileInputStream("./src/main/resources/externaldata/data1.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		String data = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		return data;
		
	}
	
	

}
