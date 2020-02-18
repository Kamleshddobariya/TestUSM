package com.usm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.usm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;
		
	public static String TESTDATA_SHEET_PATH = "D:\\eclipse-workspace\\USM\\NewStoneData_POM_QA.xlsx";
	
	static Workbook book;
	public static Sheet sheet;
	public static String s1, s2;
	public static int TRowNum;
	public static String[][] data;
	
	public void switchToFrame() {
		driver.switchTo().frame(0);
	}
	
	public static String[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		String [][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("Number of Rows in Sheet= " + sheet.getLastRowNum());
		System.out.println("Number of Columns in Sheet= " + sheet.getRow(0).getLastCellNum());
		TRowNum = sheet.getLastRowNum();
		 
		for (int i = 0 ; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k <sheet.getRow(0).getLastCellNum(); k++) {
				
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.print(data[i][k]);
				System.out.print("||");
				
				//s1 = sheet.getRow(i + 1).getCell(6).toString();
				
				//s2 = sheet.getRow(i + 1).getCell(7).toString();
			
			}
			
			System.out.println("");
//			System.out.print("Vaule of s1: " + s1);
//			System.out.println("");
		}
		
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
}
