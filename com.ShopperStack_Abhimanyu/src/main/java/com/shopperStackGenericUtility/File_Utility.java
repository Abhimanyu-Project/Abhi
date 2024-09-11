package com.shopperStackGenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Utility {
public String readPropertyData(String key) throws IOException {
	FileInputStream fis=new FileInputStream(FrameWorkContants.propertyFilePath);
	Properties prop=new Properties();
	prop.load(fis);
	String value = prop.getProperty(key);
	
	return value;
}

public String readExcelData(String SheetName,int rowNum,int cellNum ) throws EncryptedDocumentException, IOException {
	FileInputStream fis =new FileInputStream(FrameWorkContants.excelFilePath);
	Workbook wb=WorkbookFactory.create(fis);
	 String value = wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	return value;
}
}
