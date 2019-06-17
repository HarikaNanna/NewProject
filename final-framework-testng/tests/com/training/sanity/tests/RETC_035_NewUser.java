package com.training.sanity.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.AddUserScreenPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_035_NewUser {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddUserScreenPOM adduserPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		adduserPOM = new AddUserScreenPOM(driver); 
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
		loginPOM.userName("admin");
		loginPOM.password("admin@123");
		loginPOM.clickSignInBtn();
		screenShot.captureScreenShot("TC35_0");
		
	}
	
	  @Test(priority=1)
	  public void ValidateTitle0() { 
	  String j = driver.getTitle();
	  System.out.println("Your page title Is : "+j);
	  Assert.assertEquals("Dashboard ‹ Real Estate — WordPress",j);
	  //Assert.assertEquals("Only Testing",driver.getTitle()); 
	  }
	 
	
	@Test(priority = 2)
	//@Test(priority = 2,dependsOnMethods= {"ValidateTitle0"})
		public void users() throws AWTException {
		
		  Robot rb =new Robot(); 
		/* rb.keyPress(KeyEvent.VK_DOWN); */
		 
		  adduserPOM.usersTab();
		  rb.keyPress(KeyEvent.VK_ENTER);
		  adduserPOM.addUser();
		  rb.keyPress(KeyEvent.VK_ENTER);
		screenShot.captureScreenShot("TC35_1");
		}
	
	@Test(priority = 3)
		public void ValidateTitle1() {
			String i = driver.getTitle();
			System.out.println("Your page title Is : "+i);	
			Assert.assertEquals("Add New User ‹ Real Estate — WordPress",i);
			//Assert.assertEquals("Only Testing",driver.getTitle());
		}
	
	@Test(priority = 4)
	//@Test(priority = 4,dependsOnMethods= {"ValidateTitle1"})
		public void addUser() throws AWTException, InterruptedException {
		
			adduserPOM.nameInput("harika2");
			adduserPOM.emailInput("harika2@gmail.com");
			adduserPOM.firstNameInput("Harika");
			adduserPOM.lastNameInput("Nanna");
			adduserPOM.webpageUrl("www.google.com");
			adduserPOM.PasswordBtn();
			Thread.sleep(5000);
			//adduserPOM.pwInput("nemali@123");
			adduserPOM.roleList();
			adduserPOM.role();
			screenShot.captureScreenShot("TC35_2");
			adduserPOM.adduserBtn();
			screenShot.captureScreenShot("TC35_3");
		
	}
  }
