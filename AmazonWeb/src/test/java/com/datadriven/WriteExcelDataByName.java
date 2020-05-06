package com.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByName {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\Desktop\\testdata.xlsx");
		FileOutputStream fos = null;
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row =null;
		XSSFCell cell = null;
		XSSFFont font = wb.createFont();
		XSSFCellStyle style = wb.createCellStyle();
		
		
		
		int cellindex=-1;
		row = sheet.getRow(0);
		
		for(int i=0; i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Password"))
				cellindex = i;
		}
		
		row = sheet.getRow(2);
		cell = row.getCell(cellindex);
		
		font.setFontName("Algerian");
		font.setFontHeight(14.0);
		font.setBold(true);
		
		style.setFont(font);
		
		cell.setCellStyle(style);
		cell.setCellValue("Rohith");
		
		fos = new FileOutputStream("C:\\Users\\Dell\\Desktop\\testdata.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
	}

}
