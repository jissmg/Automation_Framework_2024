package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Browsers.Browsers;
import com.naveenautomationlabs.Browsers.CitiesInOntario;
import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.Testbase.TestBase;

public class AddressBookPageTest extends TestBase {

    AccountLoginPage loginPage;
    MyAccountPage myAccountPage;
    AddressBookPage addressBookPage;

    @BeforeMethod
    public void setup() {
        initialise();
        loginPage = new AccountLoginPage();
    }

    @Test
    public void loginAndAddressBookValidate() {
        MyAccountPage myAccountPage = loginPage.loginToMyAccount("jismaria123@gmail.com", "Password@1234");
        String getMyAccountText = myAccountPage.getMyAccountText();
        Assert.assertEquals(getMyAccountText, "My Account", "Not matching with My Account text");

        AddressBookPage addressBookPage = myAccountPage.clickOnAddressBook();
        addressBookPage.formElementsOnAddressBook("jis", "George", "Alen street", CitiesInOntario.SAULT_STE_MARIE, "P6A1V5");
        
        String addressBookAlertSuccessBannerText = addressBookPage.addressBookSuccessAlertBanner();
        Assert.assertEquals(addressBookAlertSuccessBannerText, "Your address has been successfully added", "Not matching text on address book page");
    }

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }
}
