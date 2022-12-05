package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Insta.BaseTest;
import com.Insta.LoginPage;

public class LoginCheck extends BaseTest{
	public LoginCheck() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	public LoginPage lp;
   @BeforeMethod
	public void setup() throws InterruptedException {
	   driver=setUpBrowser();
		lp = new LoginPage(driver);
	}
	
	@Test(dataProvider = "getData")
	public void loginCheck(String user,String pass) {
		// create object of page class login
		lp.setUserName(user); //
		lp.setPassword(pass); //
		lp.clickLogin();
		
		
		
	}
	
	@AfterMethod
	public void tearDown() 
	{
		captureScreenShot();
		tearDown1();
	}
	
	@DataProvider   //2-d object
	public Object[][] getData() throws IOException 
	{
	Object[][] testdata = excelRead();
	return testdata;
	}
	
}
