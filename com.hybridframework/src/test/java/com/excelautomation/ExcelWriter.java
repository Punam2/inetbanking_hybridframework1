package com.excelautomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	public static void main(String[] args) throws Exception {

		File fs= new File("./TestData/Data.xlsx");
		FileInputStream fins= new FileInputStream(fs);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fins);
		XSSFSheet sheet= workbook.getSheet("Sheet2");
		
		System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
		
		 sheet.getRow(0).createCell(4).setCellValue("status");
		 sheet.getRow(1).createCell(4).setCellValue("pass");
		 sheet.getRow(2).createCell(4).setCellValue("pass");
		
		FileOutputStream fout = new FileOutputStream(fs);
		workbook.write(fout);
		
		workbook.close();
		fout.close();
		fins.close();
	}

}
