package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcelDataFW {

	@DataProvider(name = "bvtDataFW")

	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String excelSheetName = m.getName();
		System.out.println("excelSheetName :" + excelSheetName);
		File eFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fs = new FileInputStream(eFile);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheetName = wb.getSheet(excelSheetName);

		int totalRows = sheetName.getLastRowNum();
		System.out.println("Sheet Name :" + sheetName);
		System.out.println("Total Rows :" + totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalColumns = rowCells.getLastCellNum();
		System.out.println("Total Columns :" + totalColumns);

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalColumns];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println("Row: " + i + " column: " + (j + 1) + " Cell value :" + testData[i - 1][j]);
			}
		}
		return testData;

	}

}
