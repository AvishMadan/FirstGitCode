package com.Insta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(xpath = "//input[@id='email']")  //webelenemt ele=driver.findelemnt by xpath
WebElement email;
@FindBy(xpath = "//input[@id='pass']")
WebElement password;
@FindBy(xpath = "//button[@name='login']")   
WebElement LogIn;
@FindBy(xpath = "//a[normalize-space()='Forgotten password?']")
WebElement forgotPasswords;
@FindBy(xpath = "//a[text()='Create New Account']")
WebElement CreateNewAccount;
WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
}
public void setUserName(String username) 
{
	email.clear();
	email.sendKeys(username);
}
public void setPassword(String pass) 
{
	password.clear();
	password.sendKeys(pass);
}

public void clickLogin() 
{
	LogIn.click();
}
public void textForgotPassword() 
{
	String forgot=forgotPasswords.getText();
System.out.println(forgot);
}
public void clickForgotPassword() 
{
	forgotPasswords.click();
}

public void clickCreateNewAccount() 
{
	CreateNewAccount.click();
}



































	
}
