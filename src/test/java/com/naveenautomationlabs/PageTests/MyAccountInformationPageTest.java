package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.MyAccountInformationPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Testbase.TestBase;

public class MyAccountInformationPageTest extends TestBase {

    AccountLoginPage loginPage;
    MyAccountPage myAccountPage;
    MyAccountInformationPage editAccountPage;

    @BeforeMethod
    public void setup() {
        initialise();
        loginPage = new AccountLoginPage();
    }

    @Test
    public void loginAndValidateMyAccountInformation() {
        // Login and verify My Account page
        myAccountPage = loginPage.loginToMyAccount("jismaria123@gmail.com", "Password@1234");
        String getMyAccountText = myAccountPage.getMyAccountText();
        Assert.assertEquals(getMyAccountText, "My Account", "My Account text does not match");

        // Navigate to Edit Account page and update information
        editAccountPage = myAccountPage.clickOnEditAccount();
        editAccountPage.MyAccountInformation();
        
        // Verify success message after account update
        String editAccountAlertText = myAccountPage.getEditAccountSuccessAlert();
        Assert.assertEquals(editAccountAlertText, "Success: Your account has been successfully updated.",
                "Edit Account success message does not match");
    }

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }
}
