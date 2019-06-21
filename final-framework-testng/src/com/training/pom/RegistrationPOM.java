package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RegistrationPOM {
		private WebDriver driver; 
	
		public RegistrationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		

	@FindBy(linkText="Log In / Register")
	private WebElement Register;
	
	@FindBy(linkText="Register")
	private WebElement RegisterTab; 
					
	@FindBy(id="email")
	private WebElement Email; 
	
	@FindBy(id="first-name")
	private WebElement FirstName;
	
	@FindBy(id="last-name")
	private WebElement LastName;
	
	@FindBy(name="submit")
	private WebElement RegisterBtn;
	
	public void selectlink() {
			this.Register.click();
	}
	
	public void registerTab() {
		this.RegisterTab.click();
	}
	
	public void sendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
	}
	
	public String getEmail() {
		return this.Email.getAttribute("value");
	}
	
	public void sendFirstName(String FirstName) {
		this.FirstName.clear(); 
		this.FirstName.sendKeys(FirstName); 
	}
	

	public String getFirstName() {
		return this.FirstName.getAttribute("value");
	}
	
	public void sendLastName(String LastName) {
		this.LastName.clear(); 
		this.LastName.sendKeys(LastName); 
	}
	public String getLastName() {
		return this.LastName.getAttribute("value");
	}
	
	public void clickRegisterBtn() {
		this.RegisterBtn.click(); 
	}

	}
