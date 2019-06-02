package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPOM {
		private WebDriver driver; 
	
		public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		

	@FindBy(linkText="Log In / Register")
	private WebElement LoginTab;
	
	@FindBy(id="user_login")
	private WebElement LoginId; 
	
	@FindBy(id="user_pass")
	private WebElement Password;
	

	@FindBy(name="login")
	private WebElement SignIn;
	
	public void selectlink() {
			this.LoginTab.click();
	}
	
	public void userName(String LoginId) {
		this.LoginId.clear(); 
		this.LoginId.sendKeys(LoginId); 
	}
	public void password(String Password) {
		this.Password.clear(); 
		this.Password.sendKeys(Password); 
	}
	
	public void clickSignInBtn() {
		this.SignIn.click(); 
	}

	}
