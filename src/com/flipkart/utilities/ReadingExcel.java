package com.flipkart.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static Object[][] readData(String SheetName) throws IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\Software Testing Hands On\\Automation Programs\\First Attempt towards POM\\src\\com\\flipkart\\data\\LoginTestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(SheetName);

		int totalRow = sheet.getPhysicalNumberOfRows();

		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

		Object arr[][] = new Object[totalRow - 1][totalColumns];

		for (int i = 1; i < totalRow; i++) {
			for (int j = 0; j < totalColumns; j++) {
				arr[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;

	}

}
