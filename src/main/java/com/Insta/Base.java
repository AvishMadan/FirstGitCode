package com.Insta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	String url ;
	public WebDriver driver;
	public WebDriver intialize() throws IOException {
		System.setProperty("webdriver.chrome.driver", 
				"E:\\New_Downloads\\Selenium_31_10_2022\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();   
		//Object of chromeDriver  class we stored in WebDriver Interface
      driver.navigate().to("https://www.facebook.com/");  //to launch the url in application
	driver.manage().window().maximize();  //maximize the window or browser
			return driver;
	}
	//property file url fetch
	
	
	public String captureScreenShot(WebDriver driver) 
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String location="C:\\Users\\LENOVO\\eclipse-workspace\\com.Insta\\screenshot\\"+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(srcfile, new File(location));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return location;
	}
	public String proppertyFileRead() throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\com.Insta\\testdata.properties");
		Properties properties=new Properties();
		properties.load(fis);
		String url=properties.getProperty("url");
	return url;
	
}
	public Object[][] excelRead() throws IOException 
	{
		
		//location---
		String path="E:\\ppt\\Book3.xlsx";
		FileInputStream fileInputStream=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("MST");
	    int LastRow=sheet.getLastRowNum();
	    int LastCol=sheet.getRow(0).getLastCellNum();
		
	    Object[][] data=new Object[LastRow][LastCol];     
	    
	    //   0,0   0,1
	    //   1,0   1,1
	    //   2,0   2,1
	    
	                  // i max is 4
	                            
	    for (int i = 1; i <= LastRow; i++) {  //i is controlling the row  0-5
		
	    	XSSFRow row = sheet.getRow(i);
	    	for (int j = 0; j < LastCol; j++) {  //j is controlling the column  0-1
				
	    //		System.out.print(row.getCell(j).getStringCellValue()+"|");
			
	     data[i-1][j]=	row.getCell(j).getStringCellValue();
	    	
	    	}
	    	
		}
		return data;
		
		
	}

}
