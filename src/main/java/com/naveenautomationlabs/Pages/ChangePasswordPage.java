package com.naveenautomationlabs.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.Testbase.TestBase;

public class ChangePasswordPage extends TestBase {

    private WebDriverWait wait;

    public ChangePasswordPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
    }

    @FindBy(xpath = "//input[@name='password']")
    WebElement enterPassword;

    public void enterPassword() {
        wait.until(ExpectedConditions.visibilityOf(enterPassword)).sendKeys("Password@1234");
    }

    @FindBy(xpath = "//input[@name='confirm']")
    WebElement enterConfirmPassword;

    public void enterConfirmPassword() {
        wait.until(ExpectedConditions.visibilityOf(enterConfirmPassword)).sendKeys("Password@1234");
    }

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement changePasswordContinue;

    public void changePasswordContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordContinue)).submit();
    }

    public void changePassword() {
        enterPassword();
        enterConfirmPassword();
        changePasswordContinue();
    }
}
