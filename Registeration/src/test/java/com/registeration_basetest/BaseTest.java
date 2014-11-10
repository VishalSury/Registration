package com.registeration_basetest;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.registeration_basepage.BasePage;
import com.registeration_basepage.Data;
import com.registeration_pages.YourDetails;

public class BaseTest {
	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("FF")) {
			Thread.sleep(5000);
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("CHROME")){
//			Thread.sleep(3000);
			System.setProperty("webdriver.chrome.driver",
					Data.chromeEXEFileLocation);
			driver = new ChromeDriver();
		}
	}

	@AfterClass
	public void setDown() {
		driver.quit();
	}

	public YourDetails yourDetails() {
		return (YourDetails) getCurrentPageAs(YourDetails.class);
	}

	public void takeScreenShotOfFailuerScreen(String url, String screenShotName)
			throws IOException {
		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		File desFile = new File(url + screenShotName
				+ System.currentTimeMillis() + ".jpg");
		FileUtils.copyFile(srcFile, desFile);
	}

	public <T> BasePage getCurrentPageAs(Class<T> clazz) {
		return (BasePage) PageFactory.initElements(driver, clazz);
	}
}
