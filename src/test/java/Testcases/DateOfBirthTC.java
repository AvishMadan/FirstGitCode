package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Insta.BaseTest;
import com.Insta.LoginPage;

import utility.Coomonfunction;

public class DateOfBirthTC  extends BaseTest{
	
	
	
	
	public DateOfBirthTC() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	public LoginPage lp;
	public Coomonfunction utobj;
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver=setUpBrowser();
	lp = new LoginPage(driver);
	utobj=new Coomonfunction();
	}

	@Test
	public void dateOfBirthFacebook() throws InterruptedException 
	{
	lp.clickCreateNewAccount();
	Thread.sleep(3000);
	lp.selectDob();	
	}
	
	
}
