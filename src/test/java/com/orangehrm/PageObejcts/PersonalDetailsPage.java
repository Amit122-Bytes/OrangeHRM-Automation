package com.orangehrm.PageObejcts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.TestData.TestConstant;

public class PersonalDetailsPage {

WebDriver localdriver;
	
	public PersonalDetailsPage(WebDriver remotedriver)
	{
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='btnSave']")
	@CacheLookup
	WebElement clickonedit;
	
	@FindBy(how=How.NAME, using="personal[txtEmpFirstName]")
	@CacheLookup
	WebElement changefname;
	
	@FindBy(how=How.NAME, using="personal[txtEmpLastName]")
	@CacheLookup
	WebElement changelname;
	
	@FindBy(how=How.NAME, using="personal[txtOtherID]")
	@CacheLookup
	WebElement otherID;
	
	@FindBy(how=How.XPATH, using="//input[@id='personal_txtLicExpDate']")
	@CacheLookup
	WebElement calender;
	
	@FindBy(how=How.ID, using="personal_optGender_1")
	@CacheLookup
	WebElement gender;
	
	@FindBy(how=How.XPATH, using="//input[@id='btnSave']")
	@CacheLookup
	WebElement Save;
	
	public void editdetails() 
	{
		clickonedit.click();	
	}
	public void firstnamechange()
	{
		changefname.clear();
		changefname.sendKeys(TestConstant.firstname);
	}
	public void lasttnamechange()
	{
		changelname.clear();
		changelname.sendKeys(TestConstant.lastname);
	}
	public void changeotherID()
	{
		otherID.clear();
		otherID.sendKeys(TestConstant.otherID);
	}
	public void changedate()
	{
		calender.clear();
		calender.sendKeys(TestConstant.datepick);
	}
	public void choosegender()
	{
		gender.click();
	}
	public void savedetails() 
	{
		Save.click();	
	}
}

