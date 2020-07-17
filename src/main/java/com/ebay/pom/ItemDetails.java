package com.ebay.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetails {
	public static WebDriver driver;
	public ItemDetails(WebDriver itemDet) {
		this.driver=itemDet;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "convbinPrice")
	private WebElement price;

	@FindBy(id="itemTitle")
	private WebElement itemTitle;
	public WebElement getItemTitle() {
		return itemTitle;
	}
	public WebElement getPrice() {
		return price;
	}

}
