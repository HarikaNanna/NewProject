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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.AddNewPropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_031_AddNewProperty {
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
	  driver.quit(); }
	 
	 
	@Test(priority=0)
	public void validLoginTest() throws InterruptedException, AWTException {
		 Robot rb =new Robot(); 
		loginPOM.selectlink();
		Thread.sleep(1000);
		loginPOM.userName("admin");
		loginPOM.password("admin@123");
		rb.keyPress(KeyEvent.VK_DOWN);
		loginPOM.clickSignInBtn();
		//Thread.sleep(3000);
		screenShot.captureScreenShot("TC31_0");
	}
	
	
	  @Test(priority=1) public void ValidateTitle() { 
		  String j = driver.getTitle();
	  System.out.println("Your page title Is : "+j);
	  Assert.assertEquals("Dashboard ‹ Real Estate — WordPress",j);
	  //Assert.assertEquals("Only Testing",driver.getTitle());
	  }
	 	
	
	//@Test(priority = 2,dependsOnMethods= {"ValidateTitle"})
	@Test(priority = 1)
		public void Addproperty() throws AWTException {
		
		  Robot rb =new Robot(); 
		/* rb.keyPress(KeyEvent.VK_DOWN); */
		 
		addPropPOM.selectPropTab();
		rb.keyPress(KeyEvent.VK_ENTER);
		addPropPOM.addNewLink();
		rb.keyPress(KeyEvent.VK_ENTER);
		screenShot.captureScreenShot("TC31_1");
		
		addPropPOM.addTitle("New_Launch");
		addPropPOM.addContent("New_Launch");
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		
		addPropPOM.addTotalPrice("500000.00");
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		addPropPOM.addPricePer("200.00");	
		screenShot.captureScreenShot("TC31_2");
		
		
		addPropPOM.mainDetailsTab();
		addPropPOM.addStatus("New");
		addPropPOM.addLocation("Electronic City");	
		addPropPOM.addPossession("Immediate");
		screenShot.captureScreenShot("TC31_3");

		addPropPOM.locationDetails();
		//rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		addPropPOM.addressDetails("yeshwanthapur");
		addPropPOM.googleAddress("yeshwanthapur");	
		addPropPOM.LocationLat("120");
		addPropPOM.LocationLong("56");
		screenShot.captureScreenShot("TC31_4");
		
		addPropPOM.details();
		addPropPOM.noOfRooms("2");
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		//Select select = new Select(_driver.findElement(By.cssPath("CSS Path of Multi-Select Box field")));
		addPropPOM.tags();
		System.out.println(addPropPOM.keytags.isSelected());
		//addPropPOM.publishInBtn();
		screenShot.captureScreenShot("TC31_5");
		/*
		 * rb.keyPress(KeyEvent.VK_PAGE_UP); rb.keyPress(KeyEvent.VK_PAGE_UP);
		 * rb.keyPress(KeyEvent.VK_PAGE_UP); rb.keyPress(KeyEvent.VK_PAGE_UP);
		 * //addPropPOM.publishInBtn();
		 */	
		
	}
  }

