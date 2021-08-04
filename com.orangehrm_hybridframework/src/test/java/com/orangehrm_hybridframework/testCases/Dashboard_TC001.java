package com.orangehrm_hybridframework.testCases;

import org.testng.annotations.Test;

import com.orangehrm_hybridframework.pageObject.DashboardPage;
import com.orangehrm_hybridframework.pageObject.LoginPage;
import com.orangehrm_hybridframework.testBase.TestBase;

public class Dashboard_TC001 extends TestBase{
	
	@Test
	public void logoutTC_001() {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		DashboardPage dp = lp.ClickOnLoginBtn();
		dp.clickOnLogoutLink();
	}

}
