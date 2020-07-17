package com.ebay.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ebay {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arun Sasha\\eclipse-workspace-photon\\Konica\\src\\test\\resource\\com\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wb=new WebDriverWait(driver, 10);
		driver.get("https://www.ebay.com/");
		HomePage Homepage=new HomePage(driver);
		ProdutPage Productpage=new ProdutPage(driver);
		ItemDetails itemDetails=new ItemDetails(driver);
		wb.until(ExpectedConditions.visibilityOf(Homepage.getSearch()));
		Homepage.getSearch().sendKeys("Electric Guitar");
		Assert.assertEquals("HomePAge not launched", "Electronics, Cars, Fashion, Collectibles & More | eBay",driver.getTitle());
		wb.until(ExpectedConditions.visibilityOf(Homepage.getSearch_btn()));
		Homepage.getSearch_btn().click();
		wb.until(ExpectedConditions.visibilityOf(Productpage.getProductName()));
		Productpage.getProductName().click();
		//System.out.println(Productpage.getProductName().getText());
		wb.until(ExpectedConditions.visibilityOf(itemDetails.getPrice()));
		System.out.println("ProductName: "+itemDetails.getItemTitle().getText()+" :"+itemDetails.getPrice().getText());
		driver.quit();
	}
}
