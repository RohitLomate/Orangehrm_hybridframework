package com.orangehrm_hybridframework.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.orangehrm_hybridframework.utility.ConfigDataPovider;
import com.orangehrm_hybridframework.utility.ExcelDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public ConfigDataPovider configDataProvider;
	public ExcelDataProvider excelDataProvider;
	
	@BeforeSuite
	public void init() {
		configDataProvider = new ConfigDataPovider();
		excelDataProvider = new ExcelDataProvider();
	}
  @BeforeMethod
  @Parameters("browser")
  public void setUp(@Optional("Chrome")String br) {
	  
	  
	  if(br.equals("Chrome")) {
		  WebDriverManager.chromedriver().setup();
		  driver= new ChromeDriver();
	  }
	  else if(br.equals("Firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver= new FirefoxDriver();
	  }
	  else if(br.equals("IE")) {
		  WebDriverManager.iedriver().setup();
		  driver= new InternetExplorerDriver();
	  }
	  else {
		  System.out.println("Driver exe doesn't match with above any driver, pls check again");
	  }
	  
	  driver.get(configDataProvider.getUrl());
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }
  
  @AfterMethod
  public void tearDown(){
	  driver.quit();
	  
  }
	
	
	

}
