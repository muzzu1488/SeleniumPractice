package com.crm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

import com.crm.qa.base.CRMBase;

public class TestUtils extends CRMBase {

	public static long IMPLICIT_WAIT = 20;
	public static long EXPLICIT_WAIT = 20;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static String SHEET_PATH = "C:\\Users\\muzzu\\eclipse-workspace\\FW"
			+ "\\src\\main\\java\\com\\qa\\TestData\\CRMTestData.xlsx";

	static XSSFWorkbook book;
	static XSSFSheet sheet;
	static FileInputStream file;

	public static Object[][] GetTestData(String SheetName) {
		try {
			file = new FileInputStream(SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = new XSSFWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(SheetName);
		int lastRowCount = sheet.getLastRowNum();
		Object[][] Data = new Object[lastRowCount][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < lastRowCount; i++) {
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				Data[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return Data;
	}

	public static void TakeScreenshot() throws IOException {

	TakesScreenshot src = (TakesScreenshot) driver;
	File S = src.getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	File Dest = new File(currentDir+"/screenshots/" + System.currentTimeMillis() + ".png");
	FileUtils.copyFile(S, Dest);
	
	}
}
