package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.Testbase.TestBase;

public class NewsLetterSubscriptionPageTest extends TestBase {

    AccountLoginPage loginPage;
    MyAccountPage myAccountPage;
    NewsletterSubscriptionPage newsletterSubscriptionPage;

    @BeforeMethod
    public void setup() {
        initialise();
        loginPage = new AccountLoginPage();
    }

    @Test
    public void loginAndNewsLetterSubscriptionValidate() {
        myAccountPage = loginPage.loginToMyAccount("jismaria123@gmail.com", "Password@1234");
        String getMyAccountText = myAccountPage.getMyAccountText();
        Assert.assertEquals(getMyAccountText, "My Account", "My Account text does not match");
        newsletterSubscriptionPage = myAccountPage.newsLetter();
        newsletterSubscriptionPage.newsLetterSubscription();
        
        String newsLetterAlertBannerText = newsletterSubscriptionPage.getNewsLetterAlertBanner();
        Assert.assertEquals(newsLetterAlertBannerText, "Success: Your newsletter subscription has been successfully updated!",
                "Newsletter subscription success message does not match");
    }

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }
}
