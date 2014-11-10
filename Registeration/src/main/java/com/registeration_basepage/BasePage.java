package com.registeration_basepage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		element.click();
	}

	public void selectValue(WebElement element, int index) {
		Select value = new Select(element);
		value.selectByIndex(index);
	}

	public void enter(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void naviGateTo(String url) {
		driver.navigate().to(url);
	}

	public boolean checkPoint(String value) {
		Assert.assertTrue(driver.getPageSource().contains(value));
		return false;
	}

	public boolean getCurrentURLWordContain(String value) {
		return driver.getCurrentUrl().contains(value);
	}

	public boolean pageContain(String value) {
		return driver.getPageSource().contains(value);
	}
	
	public String getTitleName(){
		return driver.getTitle();
	}

	public String getTextValue(WebElement element) {
		return element.getText();
	}

	public void takeScreenShot(String url, String screenShotName)
			throws IOException {
		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		File desFile = new File(url + screenShotName + ".jpg");
		FileUtils.copyFile(srcFile, desFile);
	}

	public void compaireValue(List<WebElement> listElement, String value) {
		for (WebElement element : listElement) {
			if (value.equalsIgnoreCase(element.getText())) {
				element.click();
				break;
			}
		}
	}

	public void waitforMinitue() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);
	}

	public WebElement findElementBy(By by) {
		return driver.findElement(by);
	}

	public String checkPresentOfAttribute(String xpathExpression,
			String attributeName) {
		try {
			return driver.findElement(By.xpath(xpathExpression)).getAttribute(
					attributeName);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public <T> T getCurrentPageAs(Class<T> T) {
		return PageFactory.initElements(driver, T);
	}

}