package com.registeration_pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.registeration_basepage.BasePage;

public class Confirmation extends BasePage {

	public Confirmation(WebDriver driver) {
		super(driver);
	}

	public void confirmationPage() throws IOException {
		System.out.println("Registeration is successful." + getTitleName());
	}
}
