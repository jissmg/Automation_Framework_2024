package com.naveenautomationlabs.Pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.naveenautomationlabs.Testbase.TestBase;

public class ForgotYourPasswordPage extends TestBase {

    private WebDriverWait wait;

    public ForgotYourPasswordPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
    }

    @FindBy(id = "input-email")
    WebElement emailInputForgot;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(css = "div.alert")
    WebElement alertBanner;

    public void inputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInputForgot)).sendKeys(email);
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public String getAlertBanner() {
        return wait.until(ExpectedConditions.visibilityOf(alertBanner)).getText();
    }

    public AccountLoginPage submitForgetPwdRequest(String email) {
        inputEmail(email);
        clickContinueButton();
        return new AccountLoginPage();
    }
}
