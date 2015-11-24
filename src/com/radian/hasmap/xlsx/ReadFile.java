package com.radian.hasmap.xlsx;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
	
  public HashMap<String,String> fileElement(){
	HashMap<String,String> descriptionList = new HashMap<String,String>();
	File myFile = new File("E:/Java_Setup/Jars For xlsx file/ALLEN'S PAS Document Type Categories KS.xlsx");
	XSSFWorkbook myWorkBook = null;
	XSSFSheet mySheet;
	try{
	FileInputStream fis = new FileInputStream(myFile);
	myWorkBook = new XSSFWorkbook (fis); 
	mySheet = myWorkBook.getSheetAt(0); 
	Iterator<Row> rowIterator = mySheet.iterator();
	for(int i=0;i<=4;i++){
	  rowIterator.next();
	}	
	while (rowIterator.hasNext()) { 
		Row row = rowIterator.next(); 
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) { 
     		descriptionList.put(cellIterator.next().getStringCellValue(), cellIterator.next().getStringCellValue());
			break;
	   }
	 }
	}catch(Exception e){
		System.out.println(e.getStackTrace());
	}finally{
		try{
		  myWorkBook.close();
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	return descriptionList;
  }
}
