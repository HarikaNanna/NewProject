package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class commercialTabScreenPOM {
	private WebDriver driver;
	
	public commercialTabScreenPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//*[@id=\"menu-item-513\"]/a")
	private WebElement commercialTab;
	@FindBy(name="keyword_search")
	private WebElement searchfield;
	@FindBy(xpath="//*[@id=\"realteo-search-form\"]/div[3]/div/button")
	private WebElement search;
	@FindBy(xpath="//*[@id=\"text-4\"]/div/div/p[2]/a")
	private WebElement Dropbox;
	
	
	
	@FindBy(name="name")
	private WebElement name;
	@FindBy(name="email")
	private WebElement email;
	@FindBy(name="subject")
	private WebElement subject;
	@FindBy(name="id:comments")
	private WebElement message;
	@FindBy(xpath="//*[@id=\"wpcf7-f119-p134-o1\"]/form/p/input")
	private WebElement send;
	

	
	public void commercialTabBtn() { 
		this.commercialTab.click();
	}
	
	public void searchInput(String name)  {
		this.searchfield.clear();
		this.searchfield.sendKeys(name);
		}
	
	public void searchBtn()  {
			this.search.click();
		}
	
	public void DropBoxBtn()  {
		this.Dropbox.click();
		}

	public void nameInput(String name)  {
		this.name.clear();
		this.name.sendKeys(name);
		}
	
	public void emailInput(String email)  {
		this.email.clear();
		this.email.sendKeys(email);
		}
	
	public void subjectInput(String subject)  {
		this.subject.clear();
		this.subject.sendKeys(subject);
		}
	public void messageInput(String message)  {
		this.message.clear();
		this.message.sendKeys(message);
		}
	public void sendBtn() {
		this.send.click();
	}
	
	
}