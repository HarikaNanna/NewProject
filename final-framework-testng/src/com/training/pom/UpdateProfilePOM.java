package com.training.pom;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePOM {


		private WebDriver driver; 
		
		public UpdateProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		

		@FindBy(id="agent_title") 
		private WebElement agentTitle;
		 
		@FindBy(id="phone") 
		private WebElement phoneNo;
		
		@FindBy(xpath="/html/body/div[1]/div[4]/div/article/div[2]/div/div[1]/form/button")
			private WebElement Save;
		
		public void ATitle(String agentTitle) {
			this.agentTitle.clear();
			this.agentTitle.sendKeys(agentTitle);
		}
			
		public void phoneNum(String phoneNo) {
			this.phoneNo.clear();
			this.phoneNo.sendKeys(phoneNo);
					
			}

	
		public void SaveBtn() {
		this.Save.click();
		
		}
	

	
	
	}



