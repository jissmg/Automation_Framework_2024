package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.Testbase.TestBase;


public class ForgotYourPasswordPageTest extends TestBase{
	
	AccountLoginPage loginPage;
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}

	
	@Test
	public void validateLoginWithValidCredentialsForForgotPassword()
	{
		  
		ForgotYourPasswordPage pwdPage = loginPage.clickForgotPassword();
		pwdPage.submitForgetPwdRequest("jis@gmail.com");
		String alertBannerText = pwdPage.getAlertBanner().trim();
		Assert.assertEquals("Warning: The E-Mail Address was not found in our records, please try again!",alertBannerText,"Not matching alert banner message");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
}
