package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.HomePage;
import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.NewCustomerPage;
import com.inetbanking.testbase.TestBase;
import com.inetbanking.utility.Helper;

public class AddNewCustomerTC_001 extends TestBase{

	@Test
	public void addNewCustomerPage() throws InterruptedException 
	{
		LoginPage login = new LoginPage(driver);
		login.setUsername(configDataProvider.getUsername());
		login.setPassword(configDataProvider.getPwrd());
		
		HomePage homepage = login.clickOnLoginBtn();
		
		Thread.sleep(3000);
		
		NewCustomerPage addCust = homepage.clickOnNewCustomerLink();
		addCust.setCustomerName("abcd");
		addCust.clickOnGenderRadiobtn("Male");
		
		addCust.setDob("12");
		Thread.sleep(2000);
		addCust.setDob("05");
		Thread.sleep(2000);
		addCust.setDob("2021");
		Thread.sleep(2000);
		
		addCust.setAddress("Rameshwar colony");
		addCust.setCity("Pune");
		
		addCust.setState("Maharashtra");
		addCust.setPincode("412205");
		
		addCust.setTelephone("9876543210");
		
		String randomString= Helper.getRandomString();
		addCust.setEmailId(randomString+"@gmail.com");
		
		addCust.setPassword("abcd123$");
		addCust.clickOnSubmitBtn();
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
