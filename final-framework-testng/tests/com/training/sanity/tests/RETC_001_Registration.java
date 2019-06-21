package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_001_Registration {

	private WebDriver driver;
	private String baseUrl;
	private RegistrationPOM registrationPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		registrationPOM = new RegistrationPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	  @AfterMethod public void tearDown() throws Exception { 
		  Thread.sleep(1000);
		  driver.quit(); 
		  }
	 
	@Test
	public void validLoginTest() throws InterruptedException {
		registrationPOM.selectlink();
		Thread.sleep(1000);
		registrationPOM.registerTab();
		registrationPOM.sendEmail("harika4@gmail.com");
		registrationPOM.sendFirstName("Harika4");
		registrationPOM.sendLastName("Nanna"); 
		registrationPOM.clickRegisterBtn();
		screenShot.captureScreenShot("first");
	}
}
