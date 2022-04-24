package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.inetbanking.utility.Helper;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Login Page Object Repository
	
	@FindBy(name="uid")
	WebElement txt_username;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	public void setUsername(String username)
	{
		try {
			
			txt_username.clear();
			txt_username.sendKeys(username);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void setPassword(String pass)
	{
		try {
			
			txt_password.clear();
			txt_password.sendKeys(pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public HomePage clickOnLoginBtn() {
		try {
			loginBtn.click();
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
				Assert.assertTrue(true);
				Helper.captureScreenshot(driver);
				return new HomePage(driver);
			}
			else
			{
				Helper.captureScreenshot(driver);
				if(Helper.isAlertPresent(driver))
				{
					driver.switchTo().alert().accept();
				}
				Assert.assertTrue(false);
				return null;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
}
