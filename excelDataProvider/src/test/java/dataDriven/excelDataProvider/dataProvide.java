package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



//multiple sets of data to our tests
//arraypublic
//5 Sets of data as % arrays from data provider to your tests
	//then your test will run 5 times with 5 separete sets of data (Arrays)


public class dataProvide {
	
	DataFormatter formatter = new DataFormatter();
	
	
	@Test(dataProvider="driveTest")
	public void testCaseData(String name, String middleName,String id) {
		
		System.out.println(name+middleName+id);
		
	}
	

	@DataProvider(name="driveTest")
	public  Object[][] getData() throws IOException {
		
		//Object[][] data= {  {"luiz ","fernando ", "2"},   {"hello ","text ", "45"}, {"bye ", "message ", "94"}  };
		//every row of excel should be sent to 1 array 
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
				
				
				XSSFCell cell = row.getCell(j);
				
				data[i][j] = formatter.formatCellValue(cell);
			}
			
		}
		return data; 
		
		
	}
	
	
	
	

}
