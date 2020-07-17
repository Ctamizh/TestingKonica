package com.gmail.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {
	public static WebDriver driver;

	public GmailHomePage(WebDriver ghp) {
		this.driver = ghp;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='h-c-button h-c-header__cta-li-link h-c-header__cta-li-link--primary' and @ga-event-action='create account']")
	private WebElement create;

	public WebElement getCreate() {
		return create;
	}

}
