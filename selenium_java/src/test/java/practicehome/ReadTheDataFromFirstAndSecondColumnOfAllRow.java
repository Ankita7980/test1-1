package practicehome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.vitiger.comcast.generalUtility.ExcelUtility;

public class ReadTheDataFromFirstAndSecondColumnOfAllRow {

	public static void main(String[] args) throws Throwable {
			
		FileInputStream fis=new FileInputStream("./src/main/resources/externaldata/data1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(10);
		Cell cell = row.getCell(2);
		cell.setCellValue("pass");
	
		
		   FileOutputStream fos= new FileOutputStream("./src/main/resources/externaldata/data1.xlsx");
		   wb.write(fos);
		   wb.close();
		   System.out.println("created");
		

	}

}
