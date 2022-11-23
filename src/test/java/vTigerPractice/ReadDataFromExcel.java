package vTigerPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
 public static void main(String[] args) throws Exception {
	FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TEST_DATA.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("contact");
	Row rw = sh.getRow(1);
	Cell col = rw.getCell(2);
	String LASTNAME = col.getStringCellValue();
	System.out.println("LASTNAME = "+LASTNAME);
}
}
