package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPOM {
	private WebDriver driver; 
	
	public ResetPasswordPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}
	

	
	  @FindBy(linkText="Log In / Register") 
	  private WebElement Register;
	  
	  @FindBy(linkText="Lost Your Password?") 
	  private WebElement LostPw;
	  
	  @FindBy(id="email") 
	  private WebElement Email;
	  
	  @FindBy(name="submit")
	  private WebElement Reset;

	/*
	 * @FindBy(linkText="wp-menu-name") private WebElement UserTab;
	 * 
	 * @FindBy(name="submit") private WebElement RegisterBtn;
	 */

public void selectlink() {
		this.Register.click();
}

public void LostPassword() {
	this.LostPw.click();
}

public void sendEmail(String Email) {
	this.Email.clear();
	this.Email.sendKeys(Email);
}
public void ResetBtn() {
	this.Reset.click();
}
}

