package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ResetPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_003_ResetPassword {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ResetPasswordPOM RstPwdPOM;
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
		loginPOM = new LoginPOM(driver); 
		RstPwdPOM = new ResetPasswordPOM(driver);
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
		RstPwdPOM.selectlink();
		Thread.sleep(1000);
		RstPwdPOM.LostPassword();
		}
	
	@Test(priority=1)
	public void ValidateTitle() {
		String j = driver.getTitle();
		System.out.println("Your page title Is : "+j);	
		Assert.assertEquals("Lost Password – Real Estate",j);
		//Assert.assertEquals("Only Testing",driver.getTitle());
		
		}
	@Test(priority=2,dependsOnMethods={"ValidateTitle"})
	public void User() {
		RstPwdPOM.sendEmail("harika.nanna@gmail.com");
		RstPwdPOM.ResetBtn();
				
		}
	
}
