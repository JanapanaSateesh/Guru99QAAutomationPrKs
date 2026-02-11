package guru99.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static String[][] getData(String ExcelName, String SheetName) throws IOException {
		File file=new File("./TestData/"+ExcelName+".xlsx");
		FileInputStream fi=new FileInputStream(file);	
		
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet= workbook.getSheet(SheetName);
		int rows=sheet.getPhysicalNumberOfRows();
		int column=sheet.getRow(0).getLastCellNum();
		System.out.println("Rows Count: "+rows);
		System.out.println("Cols Count: "+column);
		
		String[][] data=new String[rows-1][column];
		
		for(int i=1;i<rows;i++) {//i=0,0<5
			
			for(int j=0;j<column;j++) { //j=0;j<3
				
				DataFormatter dt=new DataFormatter();
				
				data[i-1][j]=  dt.formatCellValue(sheet.getRow(i).getCell(j)) ; 
				//System.out.print(data[i-1][j]+" ");
			}
			//System.out.println();
		}
		
		return data;
	}
}
