package propertiesfile.excelhelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dataproviderexcel {

public static Object[][] getTest(String filename,String sheetname) throws Exception {
		
		Object[][] data=null;
		
		File file=new File(filename);
		
		FileInputStream ee = null;
		try {
			ee = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Workbook wbee = null;
		try {
			wbee = WorkbookFactory.create(ee);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet st=wbee.getSheet(sheetname);
		
		data=new Object[st.getPhysicalNumberOfRows()-1][st.getRow(0).getPhysicalNumberOfCells()];
		
		for(int rowindex=st.getFirstRowNum()+1;rowindex<=st.getLastRowNum();rowindex++) {
			
			for(int colindex=st.getRow(rowindex).getFirstCellNum();colindex<st.getRow(rowindex).getLastCellNum();colindex++) {
				
				data[rowindex-1][colindex]=st.getRow(rowindex).getCell(colindex).toString();	
						
			
			}
			
			
			
		}
		
		wbee.close();
		
		return data;
		
		}
		
}
