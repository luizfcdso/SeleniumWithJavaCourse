package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelRun {
	
	@Test
	public void getExcel() throws IOException {
FileInputStream fis = new FileInputStream("C://Users//Luiz Fernando//Documents//excelDriven.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colcount = row.getLastCellNum();
		Object data[][] = new Object[numberOfRows-1][colcount];
	
		
		for(int i=0;i<numberOfRows-1;i++) {
			row = sheet.getRow(i+1);
			for (int j=0; j<colcount;j++) {
				System.out.println(row.getCell(j));
			}
			
		}
	}

}
