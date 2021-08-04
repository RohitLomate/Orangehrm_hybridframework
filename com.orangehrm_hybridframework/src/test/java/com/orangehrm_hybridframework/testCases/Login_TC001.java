package com.orangehrm_hybridframework.testCases;

import org.testng.annotations.Test;

import com.orangehrm_hybridframework.pageObject.LoginPage;
import com.orangehrm_hybridframework.testBase.TestBase;

public class Login_TC001 extends TestBase {

	@Test
	public void loginTC_001() {
		LoginPage login = new LoginPage(driver);
		login.setUsername(configDataProvider.getUsername());
		login.setPassword(configDataProvider.getPassword());
		login.ClickOnLoginBtn();
		
	}
}
