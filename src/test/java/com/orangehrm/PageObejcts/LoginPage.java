package com.orangehrm.PageObejcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver localdriver;
	
	public LoginPage(WebDriver remotedriver)
	{
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	
	@FindBy(name="txtUsername")
	WebElement Username;
	
	@FindBy(name="txtPassword")
	WebElement Password;
	
	@FindBy(name="Submit")
	WebElement Login;
	
	
	@FindBy(id="welcome")
	WebElement dropdown;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public void sendusername(String uname)
	{
		Username.sendKeys(uname);
	}
	
	public void sendpassword(String pass)
	{
		Password.sendKeys(pass);
	}
	
	public void clickbutton()
	{
		Login.click();
	}
	
	public void logoutoperation()
	{
		dropdown.click();
		logout.click();
	}
	

}
