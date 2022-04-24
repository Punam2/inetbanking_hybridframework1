package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.HomePage;
import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.testbase.TestBase;

public class HomeTC_001 extends TestBase {

	HomePage homepage;
	
	@Test(priority=1)
	public void verifyLoginFunctionalityTC001()
	{
		
		LoginPage login = new LoginPage(driver);
		
		login.setUsername(configDataProvider.getUsername());
		login.setPassword(configDataProvider.getPwrd());	
		homepage=login.clickOnLoginBtn();
	}
	@Test (priority=2)
	public void navigateNewCustomerPage() 
	{
		homepage.clickOnNewCustomerLink();
	}
	//@Test
	public void navigateToDeleteCustomerPage()
	{
		homepage.clickOnDeleteCustomerLink();
	}
	
//	@Test(priority=2)
	public void navigateToEditCustomerPage() 
	{
		homepage.clickOnEditCustomerLink();
	}
//	@Test
	public void verifyLogoutFunctionality()
	{
		homepage.clickOnLogoutLink();
		if(driver.getTitle().equals("Guru99 Bank Home Page"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);

		}
	}
	
}
