package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.RegistrationDataProviders;
import com.training.generics.ScreenShot;
//import com.training.pom.LoginPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_063_registerFail_excel {
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private RegistrationPOM registrationPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		registrationPOM = new RegistrationPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
			
	}
	@Test(priority=1)
	public void regPage() throws InterruptedException{
		
		registrationPOM.selectlink();
		Thread.sleep(1000);
		registrationPOM.registerTab();
	}
	


	/*
	 * @AfterMethod public void tearDown() throws Exception { driver.quit(); }
	 */
	@Test(priority=2,dataProvider = "excel-inputs1", dataProviderClass = RegistrationDataProviders.class)
	public void registration(String email, String firstname, String lastname) throws InterruptedException {
	
		
		registrationPOM.sendEmail(email);
		screenShot.captureScreenShot("63_email");
		registrationPOM.sendFirstName(firstname);
		registrationPOM.sendLastName(lastname); 
		screenShot.captureScreenShot("63_names");
		registrationPOM.clickRegisterBtn();
		screenShot.captureScreenShot("63_failed");

	}

}