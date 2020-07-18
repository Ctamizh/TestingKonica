package com.ebay.pom;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmail.pom.CreateAcct;
import com.gmail.pom.GmailHomePage;
import com.gmail.pom.PhoneVerificationPage;

public class Gmail {
	public static WebDriver driver;
	public static WebDriverWait wb;
	public static GmailHomePage hompage;
	public static CreateAcct createPage;
	public static PhoneVerificationPage phonePage;
	int i = 1;

	@BeforeSuite
	public static void launch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Arun Sasha\\eclipse-workspace-photon\\Konica\\src\\test\\resource\\com\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wb = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
	}

	@BeforeTest
	public void Launch() {

		hompage = new GmailHomePage(driver);
		createPage = new CreateAcct(driver);
		phonePage = new PhoneVerificationPage(driver);

	}

	@BeforeMethod
	private void launchBrowser() {
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");

	}

	@Test(dataProvider = "data")
	private void Test1(String fname, String lname, String username, String pwd, String confirmpwd, String filename,
			String phonenum) throws IOException {
		System.out.println("entered");
		wb.until(ExpectedConditions.visibilityOf(hompage.getCreate()));
		String text = hompage.getCreate().getText();
		String parentWindow = driver.getWindowHandle();
		System.out.println(text);
		hompage.getCreate().click();
		// int size = driver.getWindowHandles().size();

		List<String> allwindows = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(allwindows.get(i));
		i++;
//		i++;
		createPage.getFirstName().sendKeys(fname);
		createPage.getLastName().sendKeys(lname);
		createPage.getUsername().sendKeys(username);
		createPage.getPassword().sendKeys(pwd);
		createPage.getConfirmPassword().sendKeys(confirmpwd);
		createPage.getNext().click();
		File dest = new File(
				"C:\\Users\\Arun Sasha\\eclipse-workspace-photon\\Konica\\src\\test\\resource\\com\\screenshot\\"
						+ filename + ".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, dest);

		// driver.switchTo().window(parentWindow);
		wb.until(ExpectedConditions.visibilityOf(phonePage.getPhonenumber()));
		phonePage.getPhonenumber().sendKeys(phonenum);
		phonePage.getNext().click();
		File dest1 = new File(
				"C:\\Users\\Arun Sasha\\eclipse-workspace-photon\\Konica\\src\\test\\resource\\com\\screenshot\\"
						+ filename + "1.png");
		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File src1 = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, dest1);

	}

	@AfterMethod
	public void closeBr() {
		// driver.close();
	}

	@DataProvider(name = "data")
	public Object getData() {
		Object[][] data = new Object[2][6];
		return new String[][] { { "abc098", "xyz", "ar123ar1245", "abc123xyz", "abc123xyz", "testdata1", "8072993634" },
				{ "abc1209", "xyz", "ar123ar112456", "abc12xyz", "abc123xyz", "testdata2", "1234567890" } };

	}

	@AfterSuite
	private void close() {
		 driver.quit();

	}
}
