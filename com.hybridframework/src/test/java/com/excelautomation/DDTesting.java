package com.excelautomation;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTesting
{
	
	@Test(dataProvider="getData")
	public void setData(String username,String password, String eid)
	{
		System.out.println("username= " + username);
		System.out.println("password= " + password);
		System.out.println("Email id= " + eid);
	}
	@DataProvider
	public String[][] getData()
	{
		String data[][]=null;
		try
		{
			File  fs = new File("./TestData/Data.xlsx");
			FileInputStream fins = new FileInputStream(fs);
			
			XSSFWorkbook wb =new XSSFWorkbook(fins);
			XSSFSheet sheet = wb.getSheet("Sheet3");
			
			int row = sheet.getLastRowNum();
			int col = sheet.getRow(0).getLastCellNum();
			
			System.out.println("total row ="+ row + "total column =" + col);
			data= new String[5][3];
			
		//	data= new String[row][col];
			for(int i=0;i<=row;i++)
			{
				for(int j=0;j<col;j++)
				{
					data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					
				}
			}
			return data;
			
		}catch(Exception e)
		{
			
		}
		return data;
	}
}
