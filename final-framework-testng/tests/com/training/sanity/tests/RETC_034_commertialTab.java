package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.commercialTabScreenPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class RETC_034_commertialTab {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private commercialTabScreenPOM comScreenPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		comScreenPOM = new commercialTabScreenPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	
	
	
	/*
	 * @AfterMethod public void tearDown() throws Exception { Thread.sleep(1000);
	 * driver.quit(); }
	 */
	 
	 
	@Test(priority=0)
	public void validLoginTest() throws InterruptedException {
		loginPOM.selectlink();
		Thread.sleep(1000);
		loginPOM.userName("harika.nanna@gmail.com");
		loginPOM.password("hayat777");
		loginPOM.clickSignInBtn();
		screenShot.captureScreenShot("TC34_0");
		comScreenPOM.commercialTabBtn();
		
	}
	
	
	  @Test(priority=1) public void ValidateTitle() { String j = driver.getTitle();
	  System.out.println("Your page title Is : "+j);
	  Assert.assertEquals("Commercial – Real Estate",j);
	  //Assert.assertEquals("Only Testing",driver.getTitle()); 
	  }
	 
	
	@Test(priority = 2,dependsOnMethods= {"ValidateTitle"})
		public void Addproperty() throws AWTException {
		
		  Robot rb =new Robot(); 
		/* rb.keyPress(KeyEvent.VK_DOWN); */
		 
		comScreenPOM.searchInput("Nullam hendrerit apartment");
		comScreenPOM.searchBtn();
		screenShot.captureScreenShot("TC34_1");
		
			rb.keyPress(KeyEvent.VK_DOWN);
		comScreenPOM.DropBoxBtn();
		comScreenPOM.nameInput("selenium");
		comScreenPOM.emailInput("selenium@gmail.com");
		comScreenPOM.subjectInput("apartment");
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		comScreenPOM.messageInput("looking for apartment");
		screenShot.captureScreenShot("TC34_2");
		comScreenPOM.sendBtn();
		screenShot.captureScreenShot("TC34_3");
		
	}
  }


