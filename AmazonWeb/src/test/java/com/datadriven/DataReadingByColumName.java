package com.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadingByColumName {

	public static void main(String[] args) throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\Dell\\Desktop\\testdata.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("login");
		XSSFRow row = sh.getRow(0);
		XSSFCell cell;
		int cellindex=-1;
		
		for(int i=0; i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Password"))
				cellindex = i;
		}
		
		row = sh.getRow(2);
		cell = row.getCell(cellindex);
		String str = cell.getStringCellValue();
		System.out.println(str);
		
		wb.close();
		fis.close();
		
		
		

	}

}
