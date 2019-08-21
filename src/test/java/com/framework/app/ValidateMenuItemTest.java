package com.framework.app;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;


import pageobjects.LandingObjects;
import resources.Base;

public class ValidateMenuItemTest extends Base{
	
	 
	@BeforeMethod
	public void setUp() throws IOException {
		driver=initializeDriver();
		//	driver.get("http://www.qaclickacademy.com");
			driver.get(prop.getProperty("url"));
			
	}
	@Test
	public void validatemenuItem() throws IOException {
		
		 Logger log=LogManager.getLogger(ValidateMenuItemTest.class.getName());
		 log.info("Validating if menue item contact is diplayed");
		LandingObjects lp= new LandingObjects(driver);
	  
	    
	Assert.assertTrue(lp.getmenuItem().isDisplayed());
	

}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
		driver=null;
	}
}