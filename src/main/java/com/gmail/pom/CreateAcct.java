package com.gmail.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAcct {
	public static WebDriver driver;
	public CreateAcct(WebDriver ca) {
		this.driver =ca;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="firstName")
	private WebElement firstName;
	@FindBy(id="lastName")
	private WebElement lastName;
	@FindBy(id="username")
	private WebElement username;
	@FindBy(xpath="//input[@name='Passwd']")
	private WebElement password;
	@FindBy(xpath="//input[@name='ConfirmPasswd']")
	private WebElement confirmPassword;
	@FindBy(xpath="//span[@class='CwaK9']")
	private WebElement Next;
	
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getConfirmPassword() {
		return confirmPassword;
	}
	public WebElement getNext() {
		return Next;
	}
}
