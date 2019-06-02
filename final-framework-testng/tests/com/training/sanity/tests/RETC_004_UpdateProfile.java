package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
//import com.training.pom.Robot;
import com.training.pom.UpdateProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_004_UpdateProfile {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UpdateProfilePOM PrfUpdatePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		PrfUpdatePOM = new UpdateProfilePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	
	  @AfterMethod public void tearDown() throws Exception {
		  Thread.sleep(1000);
		  driver.quit();
	  
	  }
	 
	 
	@Test(priority=0)
	public void validLoginTest() throws InterruptedException {
		loginPOM.selectlink();
		Thread.sleep(1000);
		loginPOM.userName("harika.nanna@gmail.com");
		loginPOM.password("Hayat777");
		loginPOM.clickSignInBtn();
		screenShot.captureScreenShot("Second");
		
	}
	@Test(priority=1)
	public void ValidateTitle() {
		String j = driver.getTitle();
		System.out.println("Your page title Is : "+j);	
		Assert.assertEquals("My Profile – Real Estate",j);
		//Assert.assertEquals("Only Testing",driver.getTitle());
		}
	
	  @Test(priority=2,dependsOnMethods={"ValidateTitle"}) 
	  public void MyProfile() throws AWTException, InterruptedException {
			Robot rb=new Robot();
			  rb.keyPress(KeyEvent.VK_DOWN);
			  Thread.sleep(2000);
			  rb.keyRelease(KeyEvent.VK_DOWN);
			  Thread.sleep(2000);
			  rb.keyRelease(KeyEvent.VK_DOWN);
			  Thread.sleep(2000);
		 PrfUpdatePOM.ATitle("Hayat");
		 PrfUpdatePOM.phoneNum("354656568");
		 rb.keyRelease(KeyEvent.VK_DOWN);
		  Thread.sleep(2000);
		  rb.keyRelease(KeyEvent.VK_DOWN);
		  Thread.sleep(2000);
		  rb.keyRelease(KeyEvent.VK_DOWN);
		  Thread.sleep(2000);
		  rb.keyRelease(KeyEvent.VK_DOWN);
		  Thread.sleep(2000);
		 PrfUpdatePOM.SaveBtn();
		 screenShot.captureScreenShot("TC4_ProfileUpdate");
		}

	  
	  }
	 
	

