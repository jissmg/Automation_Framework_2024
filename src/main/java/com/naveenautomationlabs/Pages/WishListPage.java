package com.naveenautomationlabs.Pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.naveenautomationlabs.Testbase.TestBase;

public class WishListPage extends TestBase {
	WebDriverWait wait;
	
	public  WishListPage()
	{
		PageFactory.initElements(driver,this);
	}

	//samsung
	@FindBy(css="#content div table  tbody tr:first-of-type td:last-of-type a")
	WebElement itemOneRemoved;
	public void itemOneRemoved()
	{
		itemOneRemoved.click();
	}
	
	//apple
	@FindBy(css="div td:last-of-type a")
	WebElement itemTwoRemoved;
	public void itemTwoRemoved()
	{
		itemTwoRemoved.click();
	}
	
	public void wishListRemove()
	{
		 itemOneRemoved();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 itemTwoRemoved();
	}
	
	
	@FindBy(xpath="//p[text()='Your wish list is empty.']")
	WebElement emptyWishListAlert;
	
	public String getEmptyWishListAlert()
	{
		return emptyWishListAlert.getText().trim();
	}

	
	
	
	
}