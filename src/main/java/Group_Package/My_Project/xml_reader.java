package Group_Package.My_Project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xml_reader {
	public static void main(String[]args) throws IOException {
		FileInputStream reader = new FileInputStream(System.getProperty("user.dir")+"/Resources/spreadsheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(reader);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
	}

}
