package com.ebay.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdutPage {
public static WebDriver driver;
	public ProdutPage(WebDriver pp) {
		this.driver=pp;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//h3[@class='s-item__title s-item__title--has-tags'])[1]")
	private WebElement productName;

	public WebElement getProductName() {
		return productName;
	}
	
	
}
