package com.orangehrm_hybridframework.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	
	
	@FindBy(name = "txtUsername")
	WebElement text_user;
	
	@FindBy(name = "txtPassword")
	WebElement text_pass;
	
	@FindBy(id = "btnLogin")
	WebElement loginBtn;
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String username) {
		text_user.clear();
		text_user.sendKeys(username);
	}
	
	public void setPassword(String password){
		text_pass.clear();
		text_pass.sendKeys(password);	
	}
	
	public DashboardPage ClickOnLoginBtn() {
		loginBtn.click();
		if (driver.getPageSource().contains("Dashboard")) {
			Assert.assertTrue(true);
			return new DashboardPage(driver);
		}
		else {
			Assert.assertTrue(false, "login failed");
			return null;
		}
	
	}



}
