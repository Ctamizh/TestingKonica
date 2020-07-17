package com.ebay.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public static WebDriver driver;
	public HomePage(WebDriver hp) {
		this.driver=hp;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='gh-tb ui-autocomplete-input']")
	private WebElement search;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement search_btn;

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearch_btn() {
		return search_btn;
	}
	
	
}
