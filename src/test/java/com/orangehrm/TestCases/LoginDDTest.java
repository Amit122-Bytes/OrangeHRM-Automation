package com.orangehrm.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.PageObejcts.LoginPage;
import com.orangehrm.Utilities.XLUtils;

public class LoginDDTest extends BaseClass 
{

	@Test(dataProvider="LoginData")
	public void logindatadriven(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.sendusername(user);
		logger.info("User name is provided");
		lp.sendpassword(pwd);
		logger.info("Password is provided");
		lp.clickbutton();
		
		Thread.sleep(3000);
		boolean res=driver.getPageSource().contains("Invalid credentials");
		if(res==true)
		{
			
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			Thread.sleep(3000);
			lp.logoutoperation();
		}
		
	}
	
	public boolean getErrormessgae()
	{
		try{
			driver.findElement(By.id("spanMessage"));
			return true;
		}catch(Exception Ignore)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
	   String path=System.getProperty("user.dir")+"/src/test/java/com/orangehrm/TestData/LoginData.xlsx";
	   
	   int rownum=XLUtils.getRowCount(path, "Sheet1");
	   int coloumnum=XLUtils.getCellCount(path, "Sheet1", 1);
	   
	   String logindata[][]=new String[rownum][coloumnum];
	   
	   for(int i=1;i<=rownum;i++)
	   {
		   for(int j=0;j<coloumnum;j++)
		   {
			   logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1",i,j);
		   }
	   }
	return logindata;	  
	}
	
}
