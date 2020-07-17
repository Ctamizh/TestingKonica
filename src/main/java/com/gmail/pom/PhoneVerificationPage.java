package com.gmail.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhoneVerificationPage {
	public static WebDriver driver;
	public PhoneVerificationPage(WebDriver ca) {
		this.driver =ca;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="phoneNumberId")
	private WebElement phonenumber;
	

	@FindBy(xpath="//div[@class='VfPpkd-RLmnJb']")
	private WebElement next;
	public WebElement getPhonenumber() {
		return phonenumber;
	}


	public WebElement getNext() {
		return next;
	}
	
	
}
