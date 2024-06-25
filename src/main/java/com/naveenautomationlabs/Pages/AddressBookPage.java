package com.naveenautomationlabs.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlabs.Testbase.TestBase;

public class AddressBookPage extends TestBase {

	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='New Address']")
	WebElement clickOnNewAddress;

	public void clickOnNewAddress() {
		clickOnNewAddress.click();
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement clickOnFirstName;

	public void clickOnFirstName() {
		clickOnFirstName.sendKeys("Jis");
	}

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement clickOnLastName;

	public void clickOnLastName() {
		clickOnLastName.sendKeys("George");
	}

	@FindBy(xpath = "//input[@name='address_1']")
	WebElement clickOnAddressLine;

	public void clickOnAddressLine() {
		clickOnAddressLine.sendKeys("24 Allen Street");
	}

	@FindBy(xpath = "//input[@name='city']")
	WebElement clickOnCity;

	public void clickOnCity() {
		clickOnCity.sendKeys("Sault Ste. Marie");
	}

	@FindBy(xpath = "//input[@name='postcode']")
	WebElement clickOnPostCode;

	public void clickOnPostCode() {
		clickOnPostCode.sendKeys("P6A 1V5");
	}

	@FindBy(xpath = "//select[@name='country_id']")
	WebElement clickOnCountry;

	public void clickOnCountry() {

		Select selectObject1 = new Select(clickOnCountry);
		selectObject1.selectByVisibleText("Canada");
	}

	@FindBy(xpath = "//select[@name='zone_id']")
	WebElement clickOnState;

	public void clickOnState() {
		Select selectObject2 = new Select(clickOnState);
		List<WebElement> options = selectObject2.getOptions();

		for (WebElement e : options) {
			// System.out.println(e.getText());
		}
		selectObject2.selectByVisibleText("Ontario");
	}

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement clickContinue;

	public void clickContinue() {
		clickContinue.click();
	}

	@FindBy(css = "div.alert")
	WebElement addressBookSuccessAlertBanner;

	public String addressBookSuccessAlertBanner() {
		return addressBookSuccessAlertBanner.getText().trim();

	}

	public void formElementsOnAddressBook() {
		clickOnNewAddress();
		clickOnFirstName();
		clickOnLastName();
		clickOnAddressLine();
		clickOnCity();
		clickOnPostCode();
		clickOnCountry();
		clickOnState();
		clickContinue();
	}

}