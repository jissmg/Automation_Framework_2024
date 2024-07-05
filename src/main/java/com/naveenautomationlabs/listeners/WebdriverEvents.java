package com.naveenautomationlabs.listeners;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
        logger.info("Dismissing an alert!!!!!");
    }

    @Override
    public void afterDismiss(Alert alert) {
        logger.info("Dismissed an alert!!!!!");
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        logger.info("Navigating to URL: " + url);
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        logger.info("Navigated to URL: " + url);
    }

    @Override
    public void beforeBack(WebDriver.Navigation navigation) {
        logger.info("Navigating back in browser history.");
    }

    @Override
    public void afterBack(WebDriver.Navigation navigation) {
        logger.info("Navigated back in browser history.");
    }

    @Override
    public void beforeForward(WebDriver.Navigation navigation) {
        logger.info("Navigating forward in browser history.");
    }

    @Override
    public void afterForward(WebDriver.Navigation navigation) {
        logger.info("Navigated forward in browser history.");
    }

    @Override
    public void beforeRefresh(WebDriver.Navigation navigation) {
        logger.info("Refreshing the page!!!!");
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        logger.info("Page refreshed.");
    }

    @Override
    public void beforeFindElement(WebDriver driver, By by) {
        logger.info("Finding an element: " + by);
    }

    @Override
    public void afterFindElement(WebDriver driver, By by, WebElement element) {
        logger.info("Found an element: " + by);
    }

    @Override
    public void beforeClick(WebElement element) {
        logger.info("Clicking on element: " + element.getTagName());
    }

    @Override
    public void afterClick(WebElement element) {
        logger.info("Clicked on element: " + element.getTagName());
    }

    @Override
    public void beforeGetWindowHandle(WebDriver driver) {
        logger.info("Before getting window handle of: " + driver);
    }

    @Override
    public void afterGetWindowHandle(WebDriver driver, String result) {
        logger.info("Window handle obtained: " + result);
    }

    @Override
    public void beforeGetText(WebElement element) {
        logger.info("Getting text from element: " + element);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        logger.info("Text obtained from element: " + result);
    }

//    @Override
//    public void beforeGetScreenshotAs(OutputType<?> target) {
//        logger.info("Taking a screenshot.");
//    }
//
//    @Override
//    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
//        logger.info("Screenshot taken.");
//    }
}
