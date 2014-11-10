package com.registeration_pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.registeration_basepage.BasePage;
import com.registeration_basepage.Data;

public class EmailPreferences extends BasePage {
	@FindBy(xpath = "//*[@id='portal-news-alert-button'][@class='right plainText-button alert-button']")
	WebElement bmcCheckBox;
	@FindBy(xpath = "//*[@id='special-offers-button'][@class='right plainText-button alert-button']")
	WebElement specialOffer;
	@FindBy(xpath = "//*[@id='bd-biosciences-button'][@class='right plainText-button alert-button']")
	WebElement affiliatedNewsletters;
	@FindBy(xpath = "//button[@class='right w129']")
	WebElement continueButton;
	

	public EmailPreferences(WebDriver driver) {
		super(driver);
	}

	public Confirmation fill_emailPreferencesDetails() throws IOException {
		try {
			if (getCurrentURLWordContain(Data.BMC_url)
					|| getCurrentURLWordContain(Data.GENOME_url))
				if (bmcCheckBox.isDisplayed()
						&& "select".equalsIgnoreCase(getTextValue(bmcCheckBox))) {
					click(bmcCheckBox);
				}
			if (pageContain("Affiliated Newsletters")
					&& affiliatedNewsletters.isDisplayed()
					&& "select"
							.equalsIgnoreCase(getTextValue(affiliatedNewsletters))) {
				click(affiliatedNewsletters);
			}

			if (pageContain("Special offers") && specialOffer.isDisplayed()
					&& "select".equalsIgnoreCase(getTextValue(specialOffer))) {
				click(specialOffer);
			}
			click(continueButton);
			checkPoint("Step 4 - Confirmation");
			takeScreenShot(Data.screenShotLocation, "ConfirmationPage"+System.currentTimeMillis());
		} catch (Exception e) {
			takeScreenShot(Data.screenShotLocationOfFailuerScreen,
					"FailuerScreenShot"+System.currentTimeMillis());
			e.printStackTrace();
		}
		return getCurrentPageAs(Confirmation.class);
	}
}
