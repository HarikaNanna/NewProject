package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserScreenPOM {
	private WebDriver driver;
	
	public AddUserScreenPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//*[@id=\"menu-users\"]/a/div[3]")
	private WebElement users;
	@FindBy(xpath="//*[@id=\"menu-users\"]/ul/li[3]/a")
	private WebElement addUser;
		
	
	@FindBy(name="user_login")
	private WebElement username;
	@FindBy(name="email")
	private WebElement email;
	@FindBy(name="first_name")
	private WebElement firstName;
	@FindBy(name="last_name")
	private WebElement lastName;
	@FindBy(name="url")
	private WebElement webpage;
	@FindBy(xpath="//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")
	private WebElement PassBtn;
	@FindBy(id="pass1-text")
	private WebElement password;
	@FindBy(name="role")
	public WebElement roleList;
	@FindBy(xpath="//*[@id=\"role\"]/option[3]")
	private WebElement selectRole;
	
	@FindBy(id="createusersub")
	private WebElement adduserBtn;

	
	public void usersTab() { 
		this.users.click();
	}
	
	public void addUser()  {
		this.addUser.click();
		}
	
	

	public void nameInput(String username)  {
		this.username.clear();
		this.username.sendKeys(username);
		}
	
	public void emailInput(String email)  {
		this.email.clear();
		this.email.sendKeys(email);
		}
	
	public void firstNameInput(String firstName)  {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		}
	public void lastNameInput(String lastName)  {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		}
	public void webpageUrl(String webpage)  {
		this.webpage.clear();
		this.webpage.sendKeys(webpage);
		}
	public void PasswordBtn()  {
		this.PassBtn.click();
		}
	public void pwInput(String password)  {
		this.password.clear();
		this.password.sendKeys(password);
		}
	public void roleList()  {
		this.roleList.click();
		}
	public void role()  {
		this.selectRole.click();
		}
		public void adduserBtn() {
		this.adduserBtn.click();
	}
	
	
}