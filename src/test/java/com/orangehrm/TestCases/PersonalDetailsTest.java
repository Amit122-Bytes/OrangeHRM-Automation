package com.orangehrm.TestCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.orangehrm.PageObejcts.LoginPage;
import com.orangehrm.PageObejcts.PersonalDetailsPage;
import com.orangehrm.Utilities.Elements;
import com.orangehrm.Utilities.GotoPage;
import com.orangehrm.Utilities.PageTitles;

public class PersonalDetailsTest extends BaseClass 
{
	@Test
	public void editpersonaldetails() throws InterruptedException, IOException
	{
		driver.manage().window().maximize();
		LoginPage data=new LoginPage(driver);
		data.sendusername(username);
		logger.info("Username Provided");
		data.sendpassword(password);
		logger.info("Password Provided");
		data.clickbutton();
		Thread.sleep(3000);
		GotoPage.clickOn( driver, "My Info", "Personal Details");
		PersonalDetailsPage add=new PersonalDetailsPage(driver);
		add.editdetails();
		logger.info("Click on Edit Button");
		
		add.firstnamechange();
		logger.info("Enter first name");
		
		add.lasttnamechange();
		logger.info("Enter last name");
	
		add.changeotherID();
		logger.info("Insert ID");
		
		add.changedate();
		logger.info("Data is inserting");
		
		add.choosegender();
		logger.info("Gender is Choosing");
		
		Elements.materialstatus(driver, "Married");
		logger.info("Choose Material status");
		
		Elements.natioanlity(driver, "Icelander");
		logger.info("Choose Nationality");
		
		add.savedetails();
		logger.info("Save Sucessfully");
	
		if(driver.getTitle().equals(PageTitles.OrangeHRM))
		 {
			 Assert.assertTrue(true);
			 logger.info("Test is passed");
		 }
		 else
		 {
			 capturescreen( driver,"PersonalDetailsTest");
			 Assert.assertTrue(false);
			 logger.info("Test is failed");
		 } 
	}
	

}
