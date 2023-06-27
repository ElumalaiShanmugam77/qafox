package com.qafox.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qafox.base.TestBase;

public class ForgotPasswordPage extends TestBase{
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id=\"content\"]/h1")
	WebElement getTextOfForgotPassword;
	
	
	
	// initializing the Page Obecjts 
			public ForgotPasswordPage() {
				PageFactory.initElements(driver,this);
			}

			public String validateaMyAccountPageTitle() {
				return driver.getTitle();
			}

}
