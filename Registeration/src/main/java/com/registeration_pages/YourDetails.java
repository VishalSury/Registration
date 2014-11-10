package com.registeration_pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.registeration_basepage.BasePage;
import com.registeration_basepage.Data;

public class YourDetails extends BasePage{
	@FindBy(xpath="//*[@id='loginLink']/a")
	WebElement logIn_link;
	@FindBy(xpath="//*[@class='formbuttons']/a")
	WebElement register_button;
	@FindBy(id="user.information.title")
	WebElement title;
	@FindBy(id="user.FName")
	WebElement firstName;
	@FindBy(name="user.LName")
	WebElement lastName;
	@FindBy(id="user.address.countryId")
	WebElement country;
	@FindBy(id="user.information.jobType")
	WebElement yourJobType;
	@FindBy(id="user.information.dept")
	WebElement deptName;
	@FindBy(id="user.information.org")
	WebElement organizationName;
	@FindBy(id="user.information.workPlace")
	WebElement placeOfWork;
	@FindBy(id="user.information.pplId")
	WebElement principalField;
	@FindBy(id="user.email")
	WebElement emailAddress;
	@FindBy(id="confirmEmail")
	WebElement confirmEmailAddress;
	@FindBy(id="user.password")
	WebElement password;
	@FindBy(id="confirmPassword")
	WebElement confirmPassword;
	@FindBy(id="rememberMe")
	WebElement rememberMe;
	@FindBy(xpath="//*[@id='btn_container']/button")
	WebElement registerAndContinue;
	
	
	
	public YourDetails(WebDriver driver) {
		super(driver);
	}
	
	public YourInterest fill_yourDetailsPage(String url) throws IOException{
		try{
		naviGateTo(url);
		String loginDeatils = System.currentTimeMillis()+"@yahoo.com";
		click(logIn_link);
		waitforMinitue();
		Thread.sleep(3000);
		click(register_button);
		takeScreenShot(Data.screenShotLocation, "YourDetails"+System.currentTimeMillis());
		waitforMinitue();
		selectValue(title, 1);
		enter(firstName, "test");
		enter(lastName, "test");
		selectValue(country, 1);
		selectValue(yourJobType, 1);
		enter(deptName, "test");
		enter(organizationName, "test");
		selectValue(placeOfWork, 1);
		selectValue(principalField, 1);
		enter(emailAddress, loginDeatils);
		enter(confirmEmailAddress, loginDeatils);
		waitforMinitue();
		enter(password, loginDeatils);
		enter(confirmPassword, loginDeatils);
		click(rememberMe);
		click(registerAndContinue);
		waitforMinitue();
		checkPoint("Step 2 - Your interests");
		takeScreenShot(Data.screenShotLocation, "YourInterest"+System.currentTimeMillis());
		
		}
		catch (Exception e) {
			takeScreenShot(Data.screenShotLocationOfFailuerScreen, "FailuerScreen"+System.currentTimeMillis());
			e.printStackTrace();
		}
		return getCurrentPageAs(YourInterest.class);
	}
}

