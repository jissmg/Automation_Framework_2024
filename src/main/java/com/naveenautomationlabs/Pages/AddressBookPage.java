package com.naveenautomationlabs.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlabs.Browsers.Browsers;
import com.naveenautomationlabs.Browsers.CitiesInOntario;
import com.naveenautomationlabs.Testbase.TestBase;

public class AddressBookPage extends TestBase {

    public AddressBookPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='New Address']")
    WebElement clickOnNewAddress;

    private void clickOnNewAddress() {
        clickOnNewAddress.click();
    }

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement clickOnFirstName;

    public void clickOnFirstName(String firstName) {
        clickOnFirstName.sendKeys(firstName);
    }

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement clickOnLastName;

    public void clickOnLastName(String lastName) {
        clickOnLastName.sendKeys(lastName);
    }

    @FindBy(xpath = "//input[@name='address_1']")
    WebElement clickOnAddressLine;

    public void clickOnAddressLine(String address1) {
        clickOnAddressLine.sendKeys(address1);
    }

    @FindBy(xpath = "//input[@name='city']")
    WebElement clickOnCity;

    public void clickOnCity(String city) {
        clickOnCity.sendKeys(city);
    }

    @FindBy(xpath = "//input[@name='postcode']")
    WebElement clickOnPostCode;

    public void clickOnPostCode(String postCode) {
        clickOnPostCode.sendKeys(postCode);
    }

    @FindBy(xpath = "//select[@name='country_id']")
    WebElement country;

    public void clickOnCountry() {
        Select selectObject1 = new Select(country);
        selectObject1.selectByVisibleText("Canada");
    }

    @FindBy(xpath = "//select[@name='zone_id']")
    WebElement region;

    public void clickOnState() {
        Select selectObject2 = new Select(region);
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

    public AddressBookPage formElementsOnAddressBook(String firstName, String lastName, String address1, CitiesInOntario city, String postCode) {
        clickOnNewAddress();
        clickOnFirstName(firstName);
        clickOnLastName(lastName);
        clickOnAddressLine(address1);
        clickOnCity(city.getCities()); // Use the enum to get the city name
        clickOnPostCode(postCode);
        clickOnCountry();
        clickOnState();
        clickContinue();
        return new AddressBookPage();
    }
}
