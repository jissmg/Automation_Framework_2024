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
		intialise();
		loginPage = new AccountLoginPage();
	}

	@Test(dataProvider="LoginData")
	public void validateLoginWithValidCredentials(String email, String password) {
		MyAccountPage myAccountPage = loginPage.loginToMyAccount(email,password);
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText);	
		

	}
	
	@Test
	public void validateLoginWithInvalidCredentials() {
		loginPage.loginToMyAccount("jismaria123@gmail.com", "Password@124");
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
	    String path = ".\\files\\loginData.xlsx";
	    ExcelUtils excelUtils = new ExcelUtils(path);
	    int rowCount = excelUtils.getRowCount("Sheet1");
	    int colCount = excelUtils.getColumnCount("Sheet1", 0); // Assuming the first row contains all columns

	    // Initialize array with rowCount + 1 because getRowCount gives the last row number (0-indexed)
	    String[][] loginData = new String[rowCount][colCount];

	    for (int i = 1; i <= rowCount; i++) {
	        for (int j = 0; j < colCount; j++) {
	            loginData[i-1][j] = excelUtils.getCellValue("Sheet1", i, j);
	        }
	    }
	    return loginData;
	}


}