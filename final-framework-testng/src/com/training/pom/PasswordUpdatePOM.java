package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordUpdatePOM {
	private WebDriver driver; 
	
	public PasswordUpdatePOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}
	

	@FindBy(xpath="/html/body/div[1]/div[4]/div/article/div[1]/div/div/ul[2]/li[1]/a") 
	private WebElement changepw;
	 
	@FindBy(name="current_pass") 
	private WebElement currentpw;
	
	@FindBy(name="pass1") 
	private WebElement newpw;
	
	@FindBy(name="pass2") 
	private WebElement confpw;
	
	@FindBy(id="wp-submit")
		private WebElement Save;
	
	public void changePwTab() {
		this.changepw.click();
	}
	public void CurrentPw(String currentpw) {
		this.currentpw.sendKeys(currentpw);
	}
		
	public void NewtPw(String newpw) {
		this.newpw.sendKeys(newpw);
	}
	
	public void ConfPw(String confpw) {
		this.confpw.sendKeys(confpw);
	}


	public void SaveBtn() {
	this.Save.click();
	
	}



}
