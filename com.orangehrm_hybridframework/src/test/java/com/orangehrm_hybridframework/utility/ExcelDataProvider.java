package com.orangehrm_hybridframework.utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public ExcelDataProvider excelDataProvider;
	public XSSFWorkbook workbook;
	
	public ExcelDataProvider() {
		try {
			File fs = new File("./TestData/DataSheet.xlsx");
			FileInputStream fins = new FileInputStream(fs);
			workbook = new XSSFWorkbook(fins);
		}
	catch(Exception e) {
		System.out.println("file not found in specified location"+e);
	}
	}
	public String getStringCellData(int sheetIndex, int row, int col) {
		XSSFSheet sheet= workbook.getSheetAt(sheetIndex);
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	public String getStringCellData(String sheetname, int row, int col) {
		XSSFSheet sheet= workbook.getSheet(sheetname);
		return sheet.getRow(row).getCell(col).getStringCellValue();

	}
	
	public String getNumericCellData(int sheetIndex, int row, int col) {
		XSSFSheet sheet= workbook.getSheetAt(sheetIndex);
		return  sheet.getRow(row).getCell(col).getStringCellValue();
	}
	public String getNumericCellData(String sheetname, int row, int col) {
		XSSFSheet sheet= workbook.getSheet(sheetname);
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	
	public Object[][] getCelData(String sheetname) {
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		Object data[][] = new Object[rowCount][colCount];
		for(int i = 0; i<rowCount ; i++) {
			
			for(int j = 0; j<colCount ; j++) {
	
				data[i][j]= sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	
	}

}
