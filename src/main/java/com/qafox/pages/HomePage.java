package com.qafox.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qafox.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(how=How.TAG_NAME,using="a")
	List<WebElement> getTextOfAllLink;
	
	
	// initializing the Page Obecjts 
		public HomePage() {
			PageFactory.initElements(driver,this);
		}

		public String validateaMyAccountPageTitle() {
			return driver.getTitle();
		}
		
		public void validateTheAllLink() {
			for (WebElement list:getTextOfAllLink)
			{
				
				System.out.println(list.getText()+"    "+list.getAttribute("href"));
			}
		}
		
}
