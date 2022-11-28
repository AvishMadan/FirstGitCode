package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Insta.Base;
import com.Insta.LoginPage;

public class CreateNewButtonTC extends Base {
	public WebDriver driver;
	public LoginPage lp;
	@BeforeMethod
	public void setup() throws InterruptedException 
	{		
		System.setProperty("webdriver.chrome.driver", 
				"E:\\New_Downloads\\Selenium_31_10_2022\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();   
		//Object of chromeDriver  class we stored in WebDriver Interface
      driver.navigate().to("https://www.facebook.com/");  //to launch the url in application
		Thread.sleep(3000);     //it will wait for 3 seconds
		driver.manage().window().maximize();  //maximize the window or browser
		lp=new LoginPage(driver);
	}
	
	
	@Test(dataProvider = "data")
	public void loginCheck(String user,String pass) 
	{
		 //create object of page class login
		lp.setUserName(user);   //
		lp.setPassword(pass);   //
		lp.clickLogin();		
	}
	
	@DataProvider
	public Object[][] data () throws IOException 
	{
		return excelRead();
		
		
		
		
	}
//	@Test
	public void forgotPasswordText() 
	{
		lp.textForgotPassword();
		
		
	}
	

	// @Test
	public void createNewButton() throws InterruptedException 
	{
		lp.clickCreateNewAccount();
		Thread.sleep(3000);
		
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.close();
		
		
	}
}
