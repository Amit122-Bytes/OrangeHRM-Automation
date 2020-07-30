package com.orangehrm.TestCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.orangehrm.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig read=new ReadConfig();
	public String baseURL=read.getApplicationURL();
	public String username=read.getusername();
	public String password=read.getpassword();
	public static WebDriver driver;
	
	public static  Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
	      
	  logger=Logger.getLogger("OrangeHRM");
	  PropertyConfigurator.configure("log4j.properties");
	  
	  if(br.equals("Chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver",read.chrome());
		  driver=new ChromeDriver();
	  }
	  
	  else if(br.equals("Firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver",read.firefox());
		  driver=new FirefoxDriver();
	  }
	  else if(br.equals("InternetExplorer"))
	  {
		  System.setProperty("webdriver.ie.driver",read.IDE());
		  driver=new InternetExplorerDriver();
	  }
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get(baseURL);
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	
	public void capturescreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile= new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname+ ".png");
		FileUtils.copyFile(SrcFile, DestFile);
		System.out.println("Screeshot taken");
	}
}
