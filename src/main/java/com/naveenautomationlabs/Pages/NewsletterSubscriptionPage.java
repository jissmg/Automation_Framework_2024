package com.naveenautomationlabs.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.naveenautomationlabs.Testbase.TestBase;

public class NewsletterSubscriptionPage extends TestBase {
    
    WebDriverWait wait;

    @FindBy(xpath = "//input[@checked ='checked']")
    WebElement clickOnYesNewsLetter;

    @FindBy(css = "div.col-sm-10 label:last-of-type")
    WebElement clickOnNoNewsLetter;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement newsLetterContinue;

    @FindBy(css = "div.alert.alert-success")
    WebElement newsLetterYesAlertBanner;

    public NewsletterSubscriptionPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnYesNewsLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnYesNewsLetter));
        clickOnYesNewsLetter.click();
    }

    public void clickOnNoNewsLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnNoNewsLetter));
        clickOnNoNewsLetter.click();
    }

    public void newsLetterContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(newsLetterContinue));
        newsLetterContinue.submit();
    }

    public String getNewsLetterAlertBanner() {
        wait.until(ExpectedConditions.visibilityOf(newsLetterYesAlertBanner));
        return newsLetterYesAlertBanner.getText().trim();
    }

    public void newsLetterSubscription() {
        clickOnNoNewsLetter();
        newsLetterContinue();
    }

}
