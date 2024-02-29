package ExcelReader;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

	    private Workbook workbook;

	    public ExcelReader(String filePath) throws IOException {
	        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
	        workbook = WorkbookFactory.create(fileInputStream);
	    }

	    public Object[][] getData(String sheetName) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	        Object[][] data = new Object[rowCount - 1][colCount];

	        for (int i = 1; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                data[i - 1][j] = cell.toString();
	            }
	        }

	        return data;
	    }
	}

	

