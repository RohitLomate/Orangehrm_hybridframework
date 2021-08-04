package com.orangehrm_hybridframework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataPovider {
	public Properties prop = null;
	
	public ConfigDataPovider() {
		try {
			File fs = new File("./config/config.properties");
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);
		}catch (Exception e) {
			System.out.println("file not found in specified location" +e);
		}
		
		
	}
	public String getUrl() {
		return prop.getProperty("url");
	}
	public String getUsername() {
		return prop.getProperty("username");
	}
	public String getPassword() {
		return prop.getProperty("password");
	}
	public String searchKey(String key) {
		return prop.getProperty(key);
	}

}
