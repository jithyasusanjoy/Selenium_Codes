package com.project.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public void read(String s) throws IOException {
	FileInputStream f= new FileInputStream(new File("D:\\Student.xlsx"));
    try (XSSFWorkbook wb = new XSSFWorkbook(f)) {
		XSSFSheet ws= wb.getSheetAt(0);
		for(Row row: ws)     //iteration over row using for each loop  
		{  
		for(Cell cell: row)    //iteration over cell using for each loop  
		{  
			System.out.print(cell+" ");
		}
		System.out.println();
		}
	}
   
}
}