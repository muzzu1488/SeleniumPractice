package DDF;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadDataFromExcel {
	
	XSSFWorkbook wb;
	XSSFSheet Sheet;

	public void Config(String Path) {

		try {
			File Src = new File(Path);
			FileInputStream Fis = new FileInputStream(Src);
			wb =	new XSSFWorkbook(Fis);
			 
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public  int rowCount(int Sheetindex) {
		
		int count  = wb.getSheetAt(Sheetindex).getLastRowNum();
		
		return count;
		
	}
	
	public String GetTestData(int SheetName,int row,int colomn) {
		
		Sheet = wb.getSheetAt(SheetName);
		String Data = Sheet.getRow(row).getCell(colomn).getStringCellValue();
		return Data;
	}
}
