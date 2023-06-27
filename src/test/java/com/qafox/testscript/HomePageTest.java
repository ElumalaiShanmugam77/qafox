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

public class HomePageTest  extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@DataProvider(name = "ValidUsPass")
	public Object[][] getLoginDataFromExcel() {
		Object data[][] = TestUtil.readExcel("Sheet2");
		return data;
	}

	@Test(priority = 7, dataProvider = "ValidUsPass")
	public void verifyHomePageLinks(String un, String pass) {
		loginPage.Validatelogin(un, pass);
		homePage.validateTheAllLink();
	}
	@Test(priority = 8, dataProvider = "ValidUsPass")
	public void verifyHomePageTitle(String un, String pass) {
		loginPage.Validatelogin(un, pass);
		String title = homePage.validateaMyAccountPageTitle();
		Assert.assertEquals(title, "My Account");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
