package Sprint1;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData (String fileName) throws IOException {
		//xls format
		//XSSFWorkbook wb = new HSSFWorkbook();
		
		// for .xlsx Format
		XSSFWorkbook wb = new XSSFWorkbook("./data/" + fileName + ".xlsx");

		//method to pass the sheet index
		XSSFSheet ws = wb.getSheetAt(0);
		
		/* XSSFRow row = ws.getRow(0);		
		XSSFCell cell = row.getCell(0);		
		String cellValue = cell.getStringCellValue();
		System.out.println(cellValue);
		
		//instead we can call in one line as below  
		  //String cellValue = ws.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(cellValue);		*/
		
		
		int rowCount = ws.getLastRowNum(); //automatically exclude the header - calculate only data
		//System.out.println("rowCount as : "+rowCount);

		short cellCount = ws.getRow(0).getLastCellNum();
		//System.out.println("cellCount as : "+cellCount);

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {

				data[i - 1][j] = ws.getRow(i).getCell(j).getStringCellValue();
				//String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(cellValue);

			}
			//System.out.println("********************");
		}

		wb.close();

		return data;

	}

}
