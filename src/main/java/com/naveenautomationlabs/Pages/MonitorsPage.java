package com.naveenautomationlabs.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.naveenautomationlabs.Testbase.TestBase;

public class MonitorsPage extends TestBase {
    WebDriverWait wait;

    public MonitorsPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(css = "button[data-original-title*='Wish List']")
	List<WebElement> addToWishListBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Wish')]")
	WebElement wishListBtn;
	
	public void addAllMonitorsToWishList() {
        for (WebElement btn : addToWishListBtn) {
            wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
        }
    }
	
	public WishListPage clickWishList() {
		wait.until(ExpectedConditions.elementToBeClickable(wishListBtn)).click();
		return new WishListPage();
	}

}