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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPropertyPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_033_properties  {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddNewPropertyPOM addPropPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		addPropPOM = new AddNewPropertyPOM(driver); 
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

	 
	@Test(priority=0)
	public void validLoginTest() throws InterruptedException, AWTException {

		  Robot rb =new Robot(); 
		loginPOM.selectlink();
		Thread.sleep(1000);
		loginPOM.userName("admin");
		loginPOM.password("admin@123");
		rb.keyPress(KeyEvent.VK_DOWN);
		loginPOM.clickSignInBtn();
		Thread.sleep(3000);
		screenShot.captureScreenShot("TC33_0");
	}
	

	  @Test(priority=1) 
	  public void ValidateTitle() { 
		  String j = driver.getTitle();
	  System.out.println("Your page title Is : "+j);
	  Assert.assertEquals("Dashboard ‹ Real Estate — WordPress",j);
	  //Assert.assertEquals("Only Testing",driver.getTitle()); 
	  }
	 
	
	@Test(priority = 2,dependsOnMethods= {"ValidateTitle"})

		public void addProperty() throws AWTException {
		

		  Robot rb =new Robot(); 
		/* rb.keyPress(KeyEvent.VK_DOWN); */
		 
		addPropPOM.selectPropTab();
		rb.keyPress(KeyEvent.VK_ENTER);
		addPropPOM.addNewLink();
		rb.keyPress(KeyEvent.VK_ENTER);
		screenShot.captureScreenShot("TC33_1");
		 
		addPropPOM.addTitle("NewLaunch_H");
		addPropPOM.addContent("NewLaunch_H");
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		addPropPOM.publishInBtn();
		screenShot.captureScreenShot("TC33_2");
		addPropPOM.selectPropTab();
		screenShot.captureScreenShot("TC33_3");
		
	}
	
	
	 
	
  }


