package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Insta.BaseTest;
import com.Insta.ForgotPasswordPage;
import com.Insta.LoginPage;

public class SearchAfterForgotPassword extends BaseTest{
	public SearchAfterForgotPassword() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	public LoginPage lp;
	public ForgotPasswordPage fp;
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver=setUpBrowser();
	lp = new LoginPage(driver);
	fp=new ForgotPasswordPage(driver);
	}
@Test
public void checkForgotSearchFunctionality() throws InterruptedException 
{	
	String expectedError="No search results";
	lp.clickForgotPassword();
	String actualError=fp.searchFunctionality();
	Assert.assertEquals(actualError, expectedError);
}
	
	
	
	
	
	
	
}
