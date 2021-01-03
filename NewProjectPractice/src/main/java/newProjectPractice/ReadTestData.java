package newProjectPractice;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestData {

	XSSFWorkbook wb;
	XSSFSheet Sheet;

	public ReadTestData(String Path) {

		try {
			File Src = new File(Path);
			FileInputStream Fis = new FileInputStream(Src);
			wb = new XSSFWorkbook(Fis);
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int rowCount(int Sheetindex) {
		int count = 0;
		try {
			Sheet = wb.getSheetAt(Sheetindex);
			count = Sheet.getPhysicalNumberOfRows();
			System.out.println("RowCount is " + count);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int ColCount(int Sheetindex) {
		int count = 0;
		try {
			Sheet = wb.getSheetAt(Sheetindex);
			count = Sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("ColCount is " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public String getCellData(int SheetName, int row, int colomn) {
		String Data = null;
		try {
			Sheet = wb.getSheetAt(SheetName);
			Data = Sheet.getRow(row).getCell(colomn).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Data;
	}
}
