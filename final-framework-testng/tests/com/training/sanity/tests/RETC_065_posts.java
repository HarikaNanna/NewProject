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
import com.training.pom.PostsScreenPOM;
import com.training.pom.AddUserScreenPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_065_posts {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private PostsScreenPOM postPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		postPOM = new PostsScreenPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*
	 * @AfterClass public void tearDown() throws Exception { Thread.sleep(1000);
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
	
	   
	  @Test(priority = 1)
	  public void users() throws AWTException {
	  Robot rb =new Robot(); 
	  rb.keyPress(KeyEvent.VK_DOWN);
	  
	  postPOM.postTab(); rb.keyPress(KeyEvent.VK_ENTER);
	  screenShot.captureScreenShot("TC65_1"); 
	  postPOM.catgTab();
	  rb.keyPress(KeyEvent.VK_ENTER);
	  screenShot.captureScreenShot("TC65_2"); 
	  }
	  
	  @Test(priority = 2) 
	  public void ValidateTitle1() {
		  String i = driver.getTitle(); 
		  System.out.println("Your page title Is : "+i);
	  Assert.assertEquals("Categories ‹ Real Estate — WordPress",i);
	  //Assert.assertEquals("Only Testing",driver.getTitle()); 
	  }
	 

	
	  //@Test 
	  @Test(priority = 3, dependsOnMethods = { "ValidateTitle1" }) 
	  public void addUser() throws AWTException, InterruptedException {
	  
	  Robot rb = new Robot(); 
	  postPOM.nameInput("New Launches_H");
	  postPOM.slugInput("Launch");
	  postPOM.description("New Launches of villas, apartments, flats");
	  postPOM.submitBtn();
	  
	  // postPOM.postTab(); // rb.keyPress(KeyEvent.VK_ENTER);
	  
	  postPOM.addPotsTab(); // rb.keyPress(KeyEvent.VK_ENTER);
	  
	  postPOM.fillTitle("New Launches_H"); 
	  postPOM.fillMsg("New Launch in Home");
	  postPOM.category1();
	  postPOM.category2(); 
	  Thread.sleep(5000);
	  
	  postPOM.publishBtn();
	  
	  
	  Thread.sleep(2000);
	  postPOM.home();
	  screenShot.captureScreenShot("TC65_2");
	  postPOM.Blog();
	  screenShot.captureScreenShot("TC65_3");
	  
	  }
	  
	 
	}
