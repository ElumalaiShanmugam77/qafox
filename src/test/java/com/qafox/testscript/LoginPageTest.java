package com.qafox.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qafox.base.TestBase;
import com.qafox.pages.HomePage;
import com.qafox.pages.LoginPage;
import com.qafox.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void verifyLoginTitle() {

		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Account Login");
	}

	@Test(priority = 2)
	public void verifyLoginButtonEnabled() {

		boolean loginButton = loginPage.validateLoginButton();
		Assert.assertTrue(loginButton);

	}

	@Test(priority = 3)
	public void verifyUsernameTextboxEnabled() {
		boolean username = loginPage.validateUsernametextboxenabled();
		Assert.assertTrue(username);
	}

	@Test(priority = 4)
	public void verifyPasswordTextboxEnabled() {
		boolean password = loginPage.validatepasswordtextboxenabled();
		Assert.assertTrue(password);
	}

	@DataProvider(name = "sheet1")
	public Object[][] getLoginDataFromExcel() {
		Object data[][] = TestUtil.readExcel("Sheet1");
		return data;
	}

	@Test(priority = 5, dataProvider = "sheet1")
	public void verifyLoginWithUsernameAndPassword(String un, String pass) {
		loginPage.Validatelogin(un, pass);
		String titleOfMyAccount = homePage.validateaMyAccountPageTitle();
		Assert.assertEquals(titleOfMyAccount, "My Account", "Login not Successful");
	}

	@Test(priority = 6)
	public void verifyForgotPasswordLinkEnabled() {
		boolean True = loginPage.Validateforgotpassword();
		Assert.assertFalse(True);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
