package FirstMavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	
	@Test
	public void readDataFromExcel() throws IOException 
	{
		//Specify the path of excel
		File src=new File("E:\\ppt\\Book3.xlsx");
		//Load the data in background
		FileInputStream fis=new FileInputStream(src);
		//Load WorkBook
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//Load Sheet
		XSSFSheet sh=wb.getSheet("MST");
		//Fetch the sheet name 
		System.out.println(sh.getSheetName());
		//ROw and column fetch
		String s=sh.getRow(2).getCell(0).getStringCellValue();
		System.out.println("Data coming from the excel is :--->"+s);
		
System.out.println(sh.getLastRowNum());		
System.out.println(sh.getPhysicalNumberOfRows());
System.out.println(sh.getRow(1).getLastCellNum());
System.out.println(sh.getRow(1).getPhysicalNumberOfCells());
		
		
		
		
		
	}
	
	

}
