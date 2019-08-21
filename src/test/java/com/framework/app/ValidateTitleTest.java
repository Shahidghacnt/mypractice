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

public class ValidateTitleTest extends Base{
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver=initializeDriver();
		//	driver.get("http://www.qaclickacademy.com");
			driver.get(prop.getProperty("url"));
			
	}
	@Test
	public void validatetitlefeaturedCourse() throws IOException {
		 Logger log=LogManager.getLogger(ValidateTitleTest.class.getName());
		 log.debug("Validating if the FEATURED COURSE is in the title");
		 log.error("Validating if the FEATURED COURSE is in the title:should not throw error");
		LandingObjects lp= new LandingObjects(driver);
	  
		Assert.assertEquals(lp.needTitle().getText(),"FEATURED COURSES" );

}
	@AfterMethod
	public void TearDown() {
		driver.close();
		driver=null;
	}
}