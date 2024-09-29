package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//standalone class for reading data from excel sheets
public class ReadExcelData {

	private static Logger demoLogger = LogManager.getLogger(ReadExcelData.class.getName());

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		demoLogger.fatal("FATAL log");
		demoLogger.warn("WARNING log");
		demoLogger.error("ERROR log");

		ReadExcelData readDataObj = new ReadExcelData();
		readDataObj.getData("login");

	}

	public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException {
		File eFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fs = new FileInputStream(eFile);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheetName = wb.getSheet(excelSheetName);

		int totalRows = sheetName.getLastRowNum();
		System.out.println("From sysout : Sheet Name :" + sheetName);
		System.out.println("From sysout : Total Rows :" + totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalColumns = rowCells.getLastCellNum();
		System.out.println("From sysout : Total Columns :" + totalColumns);

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalColumns];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				// System.out.println("Row: "+i +" column: "+ (j+1) +" Cell value :"+ testData[i
				// - 1][j]);
			}
		}
		return testData;

	}

}
