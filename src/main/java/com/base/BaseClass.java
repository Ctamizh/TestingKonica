package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static void launchBrowser(String browser) {
		try {//test
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resource\\com\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resource\\com\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Browser not valid");
		}

	}


	public static void LaunchURL(String URL)

	{
		driver.get(URL);
	}

	public static void CaptureShot(String fileName) throws IOException {
		File dest = new File(System.getProperty("user.dir") + "\\screenshot" + fileName);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, dest);

	}

	public static void Highlight_Pass(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid green'", element);

	}

	public static void Highlight_Fail(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}

	public static String getTitleName() {
		String title = driver.getTitle();
		return title;
	}

	public static void SendKeyToElement(WebElement element, String value) {
		VisibilityOfElement(element);
		boolean displayed = element.isDisplayed();
		boolean enabled = element.isEnabled();
		if (displayed && enabled) {
			element.clear();
			element.sendKeys(value);
		}
	}

	public static void ClickElement(WebElement element) {
		VisibilityOfElement(element);
		boolean displayed = element.isDisplayed();
		if (displayed) {
			element.click();
		}

	}

	public static void VisibilityOfElement(WebElement element) {
		WebDriverWait wb = new WebDriverWait(driver, 20);
		wb.until(ExpectedConditions.visibilityOf(element));

	}
}
