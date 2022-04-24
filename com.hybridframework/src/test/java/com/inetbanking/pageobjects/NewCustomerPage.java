package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver driver;
	
	public NewCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	//Object Repository
	
	@FindBy(name="name")
	@CacheLookup
	WebElement customer_Name;
	
	@FindBy(xpath="//input[@type='radio' and @value='m']")
	@CacheLookup
	WebElement maleRadioBtn;
	
	@FindBy(name="//input[@type='radio' and @value='m']")
	@CacheLookup
	WebElement femaleRadioBtn ;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement cust_dob ;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement addr_txt ;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city_name ;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement state_txt ;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pinno_txt;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement telephone_txt;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement emaiId_txt;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password_txt;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement subBtn;
	
	public void setCustomerName(String custName)
	{
		customer_Name.clear();
		customer_Name.sendKeys(custName);
	}
	public void clickOnGenderRadiobtn(String male)
	{
		if(male.equals("Male")) {
			maleRadioBtn.click();
		}
		else
		{
			femaleRadioBtn.click();
		}
	}
	public void setDob(String dob)
	{
		cust_dob.sendKeys(dob);
		
	}
	public void setAddress(String address)
	{
		addr_txt.clear();
		addr_txt.sendKeys(address);
	}
	public void setCity(String city)
	{
		city_name.clear();
		city_name.sendKeys(city);
	}
	public void setState(String state)
	{
		state_txt.clear();
		state_txt.sendKeys(state);
	}
	public void setPincode(String pincode)
	{
		pinno_txt.clear();
		pinno_txt.sendKeys(pincode);
	}
	public void setTelephone(String telephone)
	{
		telephone_txt.clear();
		telephone_txt.sendKeys(telephone);
	}
	public void setEmailId(String email)
	{
		emaiId_txt.clear();
		emaiId_txt.sendKeys(email);
	}
	public void setPassword(String password)
	{
		password_txt.clear();
		password_txt.sendKeys(password);
	}
	public void clickOnSubmitBtn()
	{
		subBtn.click();
	}
	
}
