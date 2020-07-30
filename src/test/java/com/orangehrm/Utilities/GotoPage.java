package com.orangehrm.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GotoPage {
	
	
	public static void clickOn(WebDriver driver, String menu, String subMenu) {
		if(checkText(driver, menu)) {
			driver.findElement(By.partialLinkText(menu)).click();
			if(checkText(driver, subMenu)) {
				driver.findElement(By.partialLinkText(subMenu)).click();
			}
		}
		
		
	}
	public static void clickOn(WebDriver driver, String menu) {
		if(checkText(driver, menu)) {
			driver.findElement(By.partialLinkText(menu)).click();
		}
	}
	
	
	public static boolean checkText(WebDriver driver, String name) {
		try {
			return driver.findElement(By.partialLinkText(name)).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
