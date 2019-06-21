package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostsScreenPOM {
private WebDriver driver;
 
	
	public PostsScreenPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[3]")
	private WebElement post;
	@FindBy(linkText="Categories")
	private WebElement categories;
		
	
	 @FindBy(name="tag-name")
	 private WebElement name;
	 
	  
	  @FindBy(name="slug") 
	  private WebElement slug;
	  
	  @FindBy(name="description") 
	  private WebElement disc;
	  
	  @FindBy(name="submit") 
	  private WebElement submit;
	  
	  @FindBy(linkText="Add New") 
	  private WebElement addposts;
	  
	  @FindBy(id="title")
	  private WebElement title;
	  

	  @FindBy(id="content") 
	  private WebElement Msg;
	  
	  @FindBy(id="in-category-349") 
	  private WebElement cat1;
	  
	  @FindBy(id="in-category-353") 
	  public WebElement cat2;
	  
	  @FindBy(id="publish") 
	  private WebElement publish;
	  
	 @FindBy(xpath="//a[contains(text(),'Howdy')]")
	 private WebElement helloadmin;
	
	 @FindBy(xpath="(//a[contains(text(),'Log Out')])[1]")
	 private WebElement logoutbtn;
	 
	 @FindBy(xpath="//*[@id=\"wp-admin-bar-site-name\"]/a")
	 private WebElement home;
	 
	 @FindBy(linkText="Blog")
	 private WebElement blogTab;
	 
	public void postTab() { 
		this.post.click();
	}
	
	public void catgTab()  {
		this.categories.click();
		}
	
	


	 public void nameInput(String name) {
	 this.name.clear();
	 this.name.sendKeys(name); 
	 }
	  
	  public void slugInput(String slug) { 
	  this.slug.clear();
	  this.slug.sendKeys(slug); 
	  }
	  
	  public void description(String disc) {
	  this.disc.clear();
	  this.disc.sendKeys(disc);
	  }
	  
	  
	  public void submitBtn() { 
	  this.submit.click();
	  }
	 
	  public void addPotsTab() { 
		  this.addposts.click();
		  }
	  public void fillTitle(String title) {
		  this.title.clear();
		  this.title.sendKeys(title);
		  } 

	  public void fillMsg(String Msg) {
		  this.Msg.clear();
		  this.Msg.sendKeys(Msg);
		  } 
	  
	  public void category1() {
		  this.cat1.click();
		  }

	  public void category2() {
		  this.cat2.click();
		  }
	  public void publishBtn() {
		  this.publish.click();
		  } 
	  
	    
	    public void selectadmin() throws InterruptedException, AWTException {   
	    	Robot r = new Robot();
	    	
	        Actions a = new Actions(this.driver);
	        a.moveToElement(this.helloadmin).build().perform();
	        a.pause(5);
	        r.keyPress(KeyEvent.VK_DOWN);
	        a.moveToElement(this.logoutbtn).click().build().perform();
	      //this.logoutbtn.click(); 
	        
	        
	    }
	public void home() {
		this.home.click();
	}
	
	  public void Blog() {
		  this.blogTab.click();
		  } 
}