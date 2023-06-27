package com.qafox.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qafox.base.TestBase;


public class LoginPage extends TestBase{
	
	
	// PageFactory - OR 
	
	@FindBy(how=How.CSS,using="#input-email")
	WebElement username;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"input-password\"]")
	WebElement password; 
	
	@FindBy(how=How.XPATH,using="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement loginbutton;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")
	WebElement forgotpassword;
	
	@FindBy(how=How.LINK_TEXT,using="Continue")
	WebElement continuetoregisterpage;
	
	
	// initializing the Page Obecjts 
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	// Actions 
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void validateUserNavigateToRegisterAccountPage() {
		continuetoregisterpage.click();
	}
	
	public HomePage Validatelogin(String un,String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		loginbutton.click();
		
		return new HomePage();
		
	}
	
	public boolean Validateforgotpassword() {
		return forgotpassword.isEnabled();
	}
	
	public boolean validateLoginButton() {
		return loginbutton.isEnabled();
	}
	
	public void validateforgotpasswordclicked() {
		
		 forgotpassword.click();
	}
	
	public boolean validateUsernametextboxenabled() {
		return username.isEnabled();
	}
	
	public boolean validatepasswordtextboxenabled() {
		return username.isEnabled();
	}
	
}

