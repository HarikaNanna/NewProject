package com.training.sanity.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.NewLaunchPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_032_NewLaunchTab {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private NewLaunchPOM newLunPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		newLunPOM = new NewLaunchPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	  @AfterClass 
	  public void tearDown() throws Exception {
		  Thread.sleep(1000);
	  driver.quit();
	  }
	 
	 
	/*
	 * @Test(priority=0) public void validLoginTest() throws InterruptedException {
	 * loginPOM.selectlink(); Thread.sleep(1000); loginPOM.userName("admin");
	 * loginPOM.password("admin@123"); loginPOM.clickSignInBtn();
	 * screenShot.captureScreenShot("TC32_0"); }
	 * 
	 * @Test(priority=1) public void ValidateTitle() { String j = driver.getTitle();
	 * System.out.println("Your page title Is : "+j);
	 * Assert.assertEquals("Dashboard ‹ Real Estate — WordPress",j);
	 * //Assert.assertEquals("Only Testing",driver.getTitle()); }
	 */
	
	
	@Test
		public void NewLaunch() throws AWTException, InterruptedException {
		
		  Robot rb =new Robot(); 
		 
		 
		  newLunPOM.newLaunch_Tab();
		  screenShot.captureScreenShot("TC32_0");
		  newLunPOM.selection();
		  screenShot.captureScreenShot("TC32_1");
		  rb.keyPress(KeyEvent.VK_DOWN);
		  newLunPOM.next();
		  rb.keyPress(KeyEvent.VK_DOWN);
		  rb.keyPress(KeyEvent.VK_DOWN);
		  rb.keyPress(KeyEvent.VK_DOWN);
		  newLunPOM.fillName("selenium");
		  newLunPOM.fillEmail("selenium@gmail.com");
		  newLunPOM.fillSubject("apartment");
		  newLunPOM.fillMessage("looking for Apartment");
		  newLunPOM.submit();
		  screenShot.captureScreenShot("TC32_2");
		  
		  rb.keyPress(KeyEvent.VK_DOWN);
		  rb.keyPress(KeyEvent.VK_DOWN);
		  rb.keyPress(KeyEvent.VK_DOWN);
		  newLunPOM.saleprice("40000");
		  newLunPOM.payment("2000");
		  newLunPOM.loan("2");
		  newLunPOM.interest("5");
		  newLunPOM.calculate();
		  rb.keyPress(KeyEvent.VK_DOWN);
		  screenShot.captureScreenShot("TC32_3");
		
  }
}
