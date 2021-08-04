package com.orangehrm_hybridframework.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@id='welcome']")
	WebElement welcomeLink;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutLink;
	
	public DashboardPage(WebDriver ldriver) {
		this.driver= ldriver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogoutLink() {
		welcomeLink.click();
		logoutLink.click();
		if(driver.getPageSource().contains("LOGIN Panel")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false, "Logout failed");
		}
	}

}
