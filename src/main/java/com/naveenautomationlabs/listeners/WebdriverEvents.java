package com.naveenautomationlabs.listeners;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import com.naveenautomationlabs.Testbase.TestBase;

public class WebdriverEvents extends TestBase implements WebDriverListener {

    @Override
    public void beforeAccept(Alert alert) {
        logger.info("Accepting an alert!!!!!");
    }

    @Override
    public void afterAccept(Alert alert) {
        logger.info("Accepted an alert!!!!!");
    }

    @Override
    public void beforeDismiss(Alert alert) {
        logger.info("Dismissed an alert!!!!!");
    }

    @Override
    public void afterDismiss(Alert alert) {}

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        logger.info("Navigating to URL:" + url);
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        logger.info("Navigated to URL:" + url);
    }

    @Override
    public void  beforeBack(WebDriver.Navigation navigation) {}

    @Override
    public void afterBack(WebDriver.Navigation navigation) {}

    @Override
    public void  beforeForward(WebDriver.Navigation navigation) {}

    @Override
    public void afterForward(WebDriver.Navigation navigation) {}

    @Override
    public void beforeRefresh(WebDriver.Navigation navigation) {
        logger.info("Refreshing the Page!!!!");
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {}

    @Override
    public void beforeFindElement(WebDriver driver, By by) {
        logger.info("Finding an element:" + by);
    }

    @Override
    public void afterFindElement(WebDriver driver, By by, WebElement element) {
        logger.info("Found an element:" + by);
    }

    @Override
    public void  beforeClick(WebElement element) {
        logger.info("Clicking on element:" + element.getTagName());
    }

    @Override
    public void afterClick(WebElement element) {}

    
    @Override
    public void beforeWindow(WebDriver.TargetLocator targetLocator, String nameOrHandle) {
        logger.info("Switching to window: " + nameOrHandle);
    }

    @Override
    public void afterWindow(
    	      WebDriver.TargetLocator targetLocator, String nameOrHandle, WebDriver driver) {}

   
    @Override
    public void  beforeGetText(WebElement element) {
        logger.info("Getting text from element:" + element);
    }

    @Override
    public void  afterGetText(Alert alert, String result) {}
}
