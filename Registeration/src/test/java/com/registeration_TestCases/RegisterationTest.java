package com.registeration_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.registeration_basepage.Data;
import com.registeration_basetest.BaseTest;

public class RegisterationTest extends BaseTest{
	@Test
	public void registerationTestFireFox() throws IOException {
		String args[] = {Data.BMC_url, Data.GENOME_url, Data.NANO_url,	Data.CHEMISTORY_url};
		int count;
		for (count = 0; count <= args.length - 1; count++) {
			yourDetails()
			.fill_yourDetailsPage(args[count])
			.fill_yourInterestPage()
			.fill_emailPreferencesDetails()
			.confirmationPage();
		}
	}
}