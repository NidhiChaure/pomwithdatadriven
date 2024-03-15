package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	  WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement username;
	@FindBy(xpath = "//*[@id=\"userPassword\"]")
	WebElement password;
	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement submitbutton;
	
	public  LoginPage(WebDriver driver)
	{
		 //this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkusername(String Username)
	{
		username.sendKeys(Username);
		username.clear();
	}
	
	public void checkpassword(String Password)
	{
		password.sendKeys(Password);
		password.clear();
	}
	
	public void clicksubmit()
	{
		submitbutton.click();
	}

}
