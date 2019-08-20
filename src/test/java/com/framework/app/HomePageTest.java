package com.framework.app;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import pageobjects.LandingObjects;
import pageobjects.LoginObjects;
import resources.Base;


public class HomePageTest extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());

@BeforeMethod
public void setUp() throws IOException {
	driver=initializeDriver();
	//	driver.get("http://www.qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		
}
	@Test(dataProvider="getData")
	public void pageBaseNavigation(String username, String password) throws IOException {
	
		LandingObjects lp= new LandingObjects(driver);
		lp.getsignIn().click();
		LoginObjects lo=new LoginObjects(driver);
		lo.getEmail().sendKeys(username);
		lo.getPassowrd().sendKeys(password);
		lo.getButton().click();
		log.info("Login has been done");
	}
	@AfterMethod
	public void TearDown() {
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[] [] data=new Object[2][2];
		data[0][0]="abc@gmail.com";
		data[0][1]="efgh";
		data[1][0]="bcd@gmail.com";
		data[1][1]="lmno";
		return data;
			
	}


}
