package com.naveenautomationlabs.PageTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.Pages.MyAccountInformationPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.Testbase.TestBase;
import com.naveenautomationlabs.Utils.ExcelUtils;

public class AccountLoginPageTest extends TestBase {

	AccountLoginPage loginPage;
	ForgotYourPasswordPage pwdPage;
	MyAccountPage myAccountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	AddressBookPage addressBookPage;
	ChangePasswordPage changePasswordPage;
	MyAccountInformationPage editAccountPage;
	YourAffliateInformationPageTest yourAffliateInformationPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}

	@Test(dataProvider="LoginData")
	public void validateLoginWithValidCredentials(String email, String pwd) {
		MyAccountPage myAccountPage = loginPage.loginToMyAccount(email,pwd);
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText);	
		

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
	@DataProvider(name = "LoginData")
	private String[][] loginInfoProvider() throws IOException {
		String filePath = "C:\\Users\\sudhe\\OneDrive\\Desktop\\loginData.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet2");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet2", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet2", i, j);
			}
		}
		return loginData;
	}

}