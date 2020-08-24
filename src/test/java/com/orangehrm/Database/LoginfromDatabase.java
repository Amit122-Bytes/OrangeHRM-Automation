package com.orangehrm.Database;
import java.sql.Connection;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.orangehrm.TestCases.BaseClass;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginfromDatabase extends BaseClass {
	@Test
	public void setup() throws InterruptedException, SQLException{
		String dbUrl = "jdbc:mysql://localhost:3306/orangehrm";
		String username = "root";
		String password = "Amitmeta";
//		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customer where NAME ='Dip'");
		while (rs.next()) {

		logger.info("Browser is launching");
		driver.manage().window().maximize();
		driver.findElement(By.name("txtUsername")).sendKeys(rs.getString("username"));
		logger.info("Accessing Username from Database");
		driver.findElement(By.name("txtPassword")).sendKeys(rs.getString("password"));
		logger.info("Accessing Password from Database");
		driver.findElement(By.id("btnLogin")).click();
		logger.info("Click on Login");
		
		}
		
	}
}
