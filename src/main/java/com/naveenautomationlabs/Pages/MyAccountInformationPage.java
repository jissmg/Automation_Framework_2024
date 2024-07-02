package com.naveenautomationlabs.Pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.naveenautomationlabs.Testbase.TestBase;

public class MyAccountInformationPage extends TestBase {
    WebDriverWait wait;

    public MyAccountInformationPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with a 10-second timeout
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement editFirstName;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement clickOnContinueMyAccountInformation;

    public void editFirstName() {
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOf(editFirstName));
        firstNameField.clear();
        firstNameField.sendKeys("Sid");
    }

    public void clickOnContinueMyAccountInformation() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnContinueMyAccountInformation)).click();
    }

    public void MyAccountInformation() {
        editFirstName();
        clickOnContinueMyAccountInformation();
    }
}
