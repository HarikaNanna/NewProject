package com.training.regression.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.RegistrationDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.NewLaunchPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_64_Newlaunch_excel {
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private NewLaunchPOM newLunPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		newLunPOM = new NewLaunchPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
			
	}
	
	/*
	 * @AfterMethod public void tearDown() throws Exception { driver.quit(); }
	 */
	
	@Test(priority=1,dataProvider = "excel-inputs2", dataProviderClass = RegistrationDataProviders.class)
	public void registration(String name,String email, String subject, String message) throws InterruptedException, AWTException {
	
		
		Robot rb =new Robot(); 
		 
		 
		  newLunPOM.newLaunch_Tab();
		  screenShot.captureScreenShot("TC64_0");
		  newLunPOM.selection1();
		  screenShot.captureScreenShot("TC64_1");
		  rb.keyPress(KeyEvent.VK_DOWN);
		  rb.keyPress(KeyEvent.VK_DOWN);
		  rb.keyPress(KeyEvent.VK_DOWN);
		  newLunPOM.fillName(name);
		  screenShot.captureScreenShot("TC64_name");
		  newLunPOM.fillEmail(email);
		  screenShot.captureScreenShot("TC64_email");
		  newLunPOM.fillSubject(subject);
		  screenShot.captureScreenShot("TC64_subject");
		  newLunPOM.fillMessage(message);
		  screenShot.captureScreenShot("TC64_message");
		  newLunPOM.submit();
		  rb.keyPress(KeyEvent.VK_DOWN);
		  screenShot.captureScreenShot("TC64_final");
		  

	}

}
