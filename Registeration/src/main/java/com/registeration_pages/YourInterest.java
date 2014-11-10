package com.registeration_pages;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.registeration_basepage.BasePage;
import com.registeration_basepage.Data;

public class YourInterest extends BasePage {
	@FindBy(xpath = "//*[@id='Biology']/ul/li")
	List<WebElement> listOfGeneralScientificInterests;
	@FindBy(id = "userInterests.interests")
	WebElement describeRollAndWorkIntertest;
	@FindBy(id = "update-interests")
	WebElement continueButton;
	@FindBy(id = "Biology-header")
	WebElement biologyHeader_test;
	
	public YourInterest(WebDriver driver) {
		super(driver);

	}

	public EmailPreferences fill_yourInterestPage() throws IOException {
		try {
			if (getCurrentURLWordContain(Data.BMC_url)
					|| getCurrentURLWordContain(Data.GENOME_url)
					|| getCurrentURLWordContain(Data.NANO_url)) {
				if (StringUtils.isNotBlank(biologyHeader_test
						.getAttribute("class"))) {
				} else {
					click(biologyHeader_test);
				}

				for (WebElement element : listOfGeneralScientificInterests) {
					if ("Ecology".equalsIgnoreCase(element.getText())
							|| "Zoology".equalsIgnoreCase(element.getText())
							|| "Biophysics".equals(element.getText())
							|| "Genetics".equals(element.getText())
							|| "Biochemistry".equals(element.getText())
							|| "Bioinformatics".equals(element.getText())
							|| "Cell biology".equals(element.getText())
							|| "Analytical chemistry".equals(element.getText())) {
						element.click();
					}
				}
			}
			enter(describeRollAndWorkIntertest, Data.sendData);
			click(continueButton);
			checkPoint("Step 3 - Email preferences");
			takeScreenShot(Data.screenShotLocation, "EmailPreferences"+System.currentTimeMillis());
		} catch (Exception e) {
			takeScreenShot(Data.screenShotLocation, "FailuerScreen"+System.currentTimeMillis());
			e.printStackTrace();
		}
		return getCurrentPageAs(EmailPreferences.class);
	}
}