package com.inetbanking.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver)
	{
		String screenpath = System.getProperty("user.dir")+"//Screenshot//inetbanking_"+getCurrentDatetime() + ".png";
		try {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(source, new File(screenpath));
			
			System.out.println(" Captured screenshot ");
			
			return screenpath;
		} catch (Exception e) {
			
			System.out.println(" screenshot not a captured ");
			return null;
		}
	}
	public static String getCurrentDatetime()
	{
		SimpleDateFormat custDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate = new Date();
		return custDate.format(currentdate);
	}
	
	public static boolean isAlertPresent(WebDriver driver)
	{
		try {
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}
	public static String getRandomString()
	{
		return RandomStringUtils.randomAlphabetic(8);
	}
}
