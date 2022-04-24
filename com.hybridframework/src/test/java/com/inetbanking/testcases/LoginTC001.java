package com.inetbanking.testcases;

import org.testng.annotations.Test;
import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.testbase.TestBase;

public class LoginTC001 extends TestBase{
  
//	@Test
//	public void verifyLoginFunctionalityTC001()
//	{
//		
//		LoginPage login = new LoginPage(driver);
//		
//		login.setUsername("mngr341390");
//		login.setPassword("vYmajuh");
//		login.clickOnLoginBtn();
//	}
	
	@Test
	public void verifyLoginFunctionalityTC001()
	{
		extentTest = extentReport.createTest("Login Functionality Test");
		
		LoginPage login = new LoginPage(driver);
		login.setUsername(configDataProvider.getUsername());
		login.setPassword(configDataProvider.getPwrd());
		login.clickOnLoginBtn();
	}
}

