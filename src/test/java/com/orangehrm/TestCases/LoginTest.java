package com.orangehrm.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.orangehrm.PageObejcts.LoginPage;
import com.orangehrm.Utilities.PageTitles;

public class LoginTest extends BaseClass 
{
     @Test
	 public void loginTest() throws IOException
	 {
    	
		 logger.info("URL is opened");
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 driver.manage().window().maximize();
		 LoginPage lp=new LoginPage(driver);
		 lp.sendusername(username);
		 logger.info("Entered Username");
		 lp.sendpassword(password);
		 logger.info("Entered Password");
		 lp.clickbutton();
		 
		 if(driver.getTitle().equals(PageTitles.OrangeHRM))
		 {
			 Assert.assertTrue(true);
			 logger.info("Test is passed");
		 }
		 else
		 {
			 capturescreen( driver,"LoginTest");
			 Assert.assertTrue(false);
			 logger.info("Test is failed");
		 } 
	 }	
}
