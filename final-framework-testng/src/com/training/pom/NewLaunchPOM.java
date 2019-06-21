package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchPOM {
	private WebDriver driver;
	
	public NewLaunchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//*[contains(text(),'New Launch ')]")
	private WebElement newLaunchTab;
	@FindBy(xpath="(//a[@title='Nullam hendrerit Apartments']/img[@class='attachment-wpmm_thumb size-wpmm_thumb wp-post-image'])[1]")
	private WebElement selectOptoin;
	@FindBy(xpath="//*[@id=\"wpmm-megamenu\"]/div/div[2]/div[1]/a")
	private WebElement selectOptoin1;
	@FindBy(xpath="(//button[@class='slick-next slick-arrow'])[1]")
	private WebElement nextphoto;
	@FindBy(name="your-name")
	private WebElement name;
	@FindBy(name="your-email")
	private WebElement email;
	@FindBy(name="your-subject")
	private WebElement subject;
	@FindBy(name="your-message")
	private WebElement message;
	@FindBy(xpath="//*[@id=\"wpcf7-f4-o1\"]/form/p[5]/input")
	private WebElement send;
	
	
	@FindBy(id="amount")
	private WebElement salePrice;
	@FindBy(id="downpayment")
	private WebElement downpayment;
	@FindBy(id="years")
	private WebElement loanTerm;
	@FindBy(id="interest")
	private WebElement interestRate;
	@FindBy(xpath="//*[@id=\"widget_mortgage_calc_properties-4\"]/form/button")
	private WebElement cal;
	
	public void newLaunch_Tab() { 
		
		Actions builder = new Actions(driver);
		 Action A1 = (Action) builder
		  .moveToElement(newLaunchTab).build();
		 A1.perform();
		//this.newLaunchTab.click();
		 
	}
	public void selection() { 
				this.selectOptoin.click();
	}
	
    public void selection1() { 
			this.selectOptoin1.click();
    }
	public void next() {
		for(int i=0;i<=4;i++) {
		this.nextphoto.click();
		}
	}
		
	public void fillName(String name)  {
		this.name.clear();
		this.name.sendKeys(name);
		}
	
	public void fillEmail(String email)  {
		this.email.clear();
		this.email.sendKeys(email);
		}
	
	public void fillSubject(String subject)  {
		this.subject.clear();
		this.subject.sendKeys(subject);
		}

	public void fillMessage(String message)  {
		this.message.clear();
		this.message.sendKeys(message);
		}
	public void submit() {
		this.send.click();
	}
	
	public void saleprice(String salePrice) {
		this.salePrice.clear();
		this.salePrice.sendKeys(salePrice);
	}
	public void payment(String downpayment) {
		this.downpayment.clear();
		this.downpayment.sendKeys(downpayment);
	}
	public void loan(String loanTerm) {
		this.loanTerm.clear();
		this.loanTerm.sendKeys(loanTerm);
	}
	public void interest(String interestRate) {
		this.interestRate.clear();
		this.interestRate.sendKeys(interestRate);
	}
	public void calculate() {
		this.cal.click();
		}
}
	/*
	 * public void addContent(String content) { this.content.clear();
	 * this.content.sendKeys(content); }
	 */

	