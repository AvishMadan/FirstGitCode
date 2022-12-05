package com.Insta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class BaseTest {

	public WebDriver driver;
	public LoginPage lp;
	Properties pro;
	
	

	
	public BaseTest() throws IOException {
		File file=new File("C:\\Users\\LENOVO\\eclipse-workspace\\com.Insta\\testdata.properties");
		//There is a file at that location
		FileInputStream fis=new FileInputStream(file);
		//We want read data from that file
		 pro=new Properties();  //Key value pair
		//We want to use property file key value
		pro.load(fis);
		
	}


	public WebDriver setUpBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				pro.getProperty("ChromeDriverPath"));
		driver = new ChromeDriver();
		// Object of chromeDriver class we stored in WebDriver Interface
		driver.navigate().to(pro.getProperty("url")); // to launch the url in application
		Thread.sleep(3000); // it will wait for 3 seconds
		driver.manage().window().maximize(); // maximize the window or browser
		return driver;
	}
	
	
	public void tearDown1() 
	{
		driver.close();
	}
	
	public Object[][] excelRead() throws IOException 
	{
		//location---
		String path=pro.getProperty("excelPath");
		FileInputStream fileInputStream=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet(pro.getProperty("sheetName"));
	    int LastRow=sheet.getLastRowNum();  //  4
	    System.out.println("LastRow"+LastRow);
	    int LastCol=sheet.getRow(0).getLastCellNum();  //2
	    System.out.println("LastRow"+LastCol);
	    Object[][] data=new Object[LastRow][LastCol];     
	    
	    //   0,0   0,1
	    //   1,0   1,1
	    //   2,0   2,1
	    
	                  // i max is 4
	                            
	    for (int i = 1; i <= LastRow; i++) {  //i is controlling the row  0-5
		
	    	XSSFRow row = sheet.getRow(i); //1---->2
	    	for (int j = 0; j < LastCol; j++) {  //j is controlling the column  0-1
				//i=2  j=0
	    //		System.out.print(row.getCell(j).getStringCellValue()+"|");
			// data[0][0]=nikhil;
	    	// data[0][1]=Pass1;	
	    		// data[1][0]=Avish;
	    		// data[1][1]=Pass2;
	     data[i-1][j]=	row.getCell(j).getStringCellValue();   	
	    	}
		}
		return data;  //dataprovider
		
		
	}

	public void captureScreenShot() 
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String location=pro.getProperty("screenshotPath")+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(srcfile, new File(location));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
}
