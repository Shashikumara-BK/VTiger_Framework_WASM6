package vTigerPractice;

import java.io.IOException;

import vTigerGenericLibrary.ExcelFileLibrary;
import vTigerGenericLibrary.JavaLibrary;
import vTigerGenericLibrary.PropertyFileLibrary;

public class GenericMethodsPractice {
  public static void main(String[] args) throws IOException {
		
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		
		String date = jLib.getSystemDate();
		System.out.println(date);
		String date1 = jLib.getSystemDateInFormat();
		System.out.println(date1);
		
		
		String value = pLib.readDataFromPropertyFile("browser");
		System.out.println(value);
		String value1 = pLib.readDataFromPropertyFile("username");
		System.out.println(value1);
		
		
		String val = eLib.readDataFromExcel("organisation", 1, 2);
		System.out.println(val);
		int row = eLib.getRowCount("contact");
		System.out.println(row);
		eLib.writeDataIntoExcel("organisation", 7, 8, "Shashi");
		
}
}
