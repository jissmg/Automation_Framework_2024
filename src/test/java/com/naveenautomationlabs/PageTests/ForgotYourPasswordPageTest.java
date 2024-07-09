package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.Testbase.TestBase;

public class ForgotYourPasswordPageTest extends TestBase {
    AccountLoginPage loginPage;
    ForgotYourPasswordPage pwdPage;

    @BeforeMethod
    public void setup() {
        intialise();
        loginPage = new AccountLoginPage();
        pwdPage = new ForgotYourPasswordPage(); // Initialize the ForgotYourPasswordPage object
    }

    @Test
    public void validateForgotPassword() {
    	pwdPage = loginPage.clickForgotPassword();
        pwdPage.submitForgetPwdRequest("jismaria12@gmail.com");
        String alertBannerText = pwdPage.getAlertBanner().trim();
        Assert.assertEquals(alertBannerText, "Warning: The E-Mail Address was not found in our records, please try again!", "Not matching alert banner message");
    }

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }
}
