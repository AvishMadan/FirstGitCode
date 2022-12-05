package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Insta.BaseTest;
import com.Insta.LoginPage;

public class ForgotPassword extends BaseTest {
	public ForgotPassword() throws IOException {
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

	
	@Test
	public void forgotPasswordText() {
		lp.textForgotPassword();

	}
	
	
}
