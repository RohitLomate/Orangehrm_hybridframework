package com.orangehrm_hybridframework.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm_hybridframework.pageObject.LoginPage;
import com.orangehrm_hybridframework.testBase.TestBase;

public class Login_TC002 extends TestBase {
	
	//@Test
	//public void login_TC002() {
	//	LoginPage login = new LoginPage(driver);
	//	login.setUsername(excelDataProvider.getStringCellData("login", 1, 0));
	//	login.setUsername(excelDataProvider.getStringCellData("login", 1, 1));
	//	login.ClickOnLoginBtn();
		
	//}

//}
	@Test(dataProvider = "getData")
	public void loginTC002(String uname, String upass) {
		LoginPage login = new LoginPage(driver);
		login.setUsername(uname);
		login.setPassword(upass);
		login.ClickOnLoginBtn();
		
		
	}
	@DataProvider
	public Object getData() {
		Object[][] data = excelDataProvider.getCelData("Sheet1");
		return data;
		
	}
	}
