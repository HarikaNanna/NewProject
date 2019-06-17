package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPropertyPOM {
	private WebDriver driver; 

	public AddNewPropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//*[@id=\"menu-posts-property\"]/a/div[3]")
	private WebElement PropTab;

	@FindBy(xpath="//*[@id=\"menu-posts-property\"]/ul/li[3]/a")
	private WebElement addNew; 

	@FindBy(id="title")
	private WebElement title;

	@FindBy(id="content")
	private WebElement content;


	@FindBy(id="_price")
	private WebElement totalPrice;

	@FindBy(id="_price_per")
	private WebElement pricePer;

	@FindBy(id="ui-id-2")
	private WebElement mainDetails;

	@FindBy(id="_status")
	private WebElement status;

	@FindBy(id="_location")
	private WebElement location;

	@FindBy(id="_possession")
	private WebElement possession;

	@FindBy(id="ui-id-3")
	private WebElement locationDetails;
	
	@FindBy(id="_friendly_address")
	private WebElement address;
	
	@FindBy(id="_address")
	private WebElement googlemapAdd;
	
	@FindBy(id="_geolocation_lat")
	private WebElement latitude;
	
	@FindBy(id="_geolocation_long")
	private WebElement Longitude;
	

	@FindBy(id="ui-id-4")
	private WebElement details;

	@FindBy(id="_storage_room")
	private WebElement rooms;
	
	@FindBy(css="li:nth-child(1) > .acf-bl > li:nth-child(2) input")
	//@FindBy(className="children acf-bl")  
	public WebElement keytags;
	

	@FindBy(id="publish")
	private WebElement publish;
	
	public void selectPropTab() {
		this.PropTab.click();
	}

	public void addNewLink() {
		this.addNew.click();
	}

	public void addTitle(String title) { 
		this.title.clear();
		this.title.sendKeys(title); 
	}

	public void addContent(String content) { 
		this.content.clear();
		this.content.sendKeys(content); 
	}

	public void addTotalPrice(String totalPrice) { 
		this.totalPrice.clear();
		this.totalPrice.sendKeys(totalPrice);
	}

	public void addPricePer(String pricePer) { 
		this.pricePer.clear();
		this.pricePer.sendKeys(pricePer);
	}

	public void mainDetailsTab() {
		this.mainDetails.click();
	}

	public void addStatus(String status) { 
		this.status.clear();
		this.status.sendKeys(status);
	}

	public void addLocation(String location) { 
		this.location.clear();
		this.location.sendKeys(location);
	}

	public void addPossession(String possession) { 
		this.possession.clear();
		this.possession.sendKeys(possession);
	}
	
	public void locationDetails() { 
		this.locationDetails.click();
	} 
	
	public void addressDetails(String address) { 
		this.address.clear();
		this.address.sendKeys(address);
	} 
	
	public void googleAddress(String googlemapAdd) { 
		this.googlemapAdd.clear();
		this.googlemapAdd.sendKeys(googlemapAdd);
	} 
	
	public void LocationLat(String latitude) { 
		this.latitude.clear();
		this.latitude.sendKeys(latitude);
	}  
	
	public void LocationLong(String Longitude) { 
		this.Longitude.clear();
		this.Longitude.sendKeys(Longitude);
	}  
	
	public void details() { 
		this.details.click();
	}
	
	public void noOfRooms(String rooms) { 
		this.rooms.clear();
		this.rooms.sendKeys(rooms);
	} 
	

	public void tags() { 
		this.keytags.click();
		
	}

	public void publishInBtn() { 
		this.publish.click();
	}
}
