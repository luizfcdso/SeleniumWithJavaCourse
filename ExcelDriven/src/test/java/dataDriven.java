import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	//Identify Testcases column by scanning the entire list row
	//Once column is identified then scan entire testcase column to identify purchase test
	//After you grab purchase testcase row = pull all the data of that row and feed into test
	
	public ArrayList<String> getData(String testcaseName) throws IOException {
ArrayList<String> a=new ArrayList<String>();
		
		// TODO Auto-generated method stub~
		
		
		
	FileInputStream fis=new FileInputStream("C://Users//Luiz Fernando//Documents//demodata.xlsx"); 
		
     XSSFWorkbook workbook=new XSSFWorkbook(fis);
     
     int sheets = workbook.getNumberOfSheets();
     
     for(int i=0; i<sheets;i++) {
    	 
    	if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
    			{
    		
    	XSSFSheet sheet =  workbook.getSheetAt(i);
    	Iterator<Row> rows = sheet.iterator();
    	Row fisrtrow = rows.next();
    	Iterator<Cell> ce = fisrtrow.cellIterator();
    	
    	int k=0;
    	int column = 0;
    	while(ce.hasNext()) {
    		Cell value = ce.next();
    		if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
    		{
    			//desired column 
    			column=k;
    		}
    		k++;
    	}
    	System.out.println(column);
    
    	
    	while(rows.hasNext()) {
    		
    		Row r = rows.next();
    		if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
    			Iterator<Cell> cv=r.cellIterator();
    			while(cv.hasNext()) {
    				a.add(cv.next().getStringCellValue());
    			}
    		}
    		
    	}
    	}
    	


}
	return a;
}
}



	

