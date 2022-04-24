package com.excelautomation;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws Exception {

		File fs=new File("./TestData/Data.xlsx");
		FileInputStream fins = new FileInputStream(fs);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fins);
		XSSFSheet sheet =workbook.getSheet("Sheet1");
		
		String value_1 = sheet.getRow(0).getCell(0).getStringCellValue();
		String value_2 = sheet.getRow(0).getCell(1).getStringCellValue();
		String value_3 = sheet.getRow(0).getCell(2).getStringCellValue();
		
		String value1 = sheet.getRow(1).getCell(0).getStringCellValue();
		String value2 = sheet.getRow(1).getCell(1).getStringCellValue();
		String value3 = sheet.getRow(1).getCell(2).getStringCellValue();
		
		String value01 = sheet.getRow(2).getCell(0).getStringCellValue();
		String value02 = sheet.getRow(2).getCell(1).getStringCellValue();
		String value03 = sheet.getRow(2).getCell(2).getStringCellValue();
		
		System.out.println(value_1 + " " +value_2 + " " + value_3);
		System.out.println(value1 + " " +value2 + " " + value3);
		System.out.println(value01 + " " +value02 + " " + value03);
		
	//	double eid = sheet.getRow(2).getCell(4).getNumericCellValue();
	//	System.out.println(eid);
		
		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total row = "+ row + " Total column= "+cell);
		
		XSSFRow row0 = sheet.getRow(2);
		for(int i=0;i<cell;i++)
		{
			System.out.print(row0.getCell(i).toString()+" ");
		}
		System.out.println();
		workbook.close();
	}

}
