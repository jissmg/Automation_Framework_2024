package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.Pages.MyAccountInformationPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.Pages.YourAffliateInformationPage;
import com.naveenautomationlabs.Testbase.TestBase;

public class AccountLoginPageTest extends TestBase {

	AccountLoginPage loginPage;
	ForgotYourPasswordPage pwdPage;
	MyAccountPage myAccountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	AddressBookPage addressBookPage;
	ChangePasswordPage changePasswordPage;
	MyAccountInformationPage editAccountPage;
	YourAffliateInformationPage yourAffliateInformationPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}

	@Test
	public void validateLoginWithValidCredentials() {
		MyAccountPage myAccountPage = loginPage.loginToMyAccount("jismaria123@gmail.com", "Password@1234");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText, "Not matching with My Account text");	
		myAccountPage.logout();

	}

	@Test
	public void validateLoginWithInvalidCredentials() {
		loginPage.loginToMyAccount("jismaria123@gmail.com", "Password");
		String alertBannerText = loginPage.getTextFromAlertBanner().trim();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", alertBannerText);
	}

	@Test
	public void validateForgotYourPasswordFunctionality() {
		pwdPage = loginPage.clickForgotPassword();
		loginPage = pwdPage.submitForgetPwdRequest("jismaria123@gmail.com");
		String alertSuccessBannerText = loginPage.getTextFromAlertSuccessBanner().trim();
		Assert.assertEquals("An email with a confirmation link has been sent your email address.",
				alertSuccessBannerText);

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}