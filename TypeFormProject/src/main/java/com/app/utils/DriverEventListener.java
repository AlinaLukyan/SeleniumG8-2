package com.app.utils;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class DriverEventListener implements WebDriverEventListener {

    private static final Logger LOG = Logger.getLogger(DriverEventListener.class);

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        LOG.info("Navigating to " + url + " ...");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        LOG.info("Has now been navigated to " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        LOG.info("Navigating back ...");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        LOG.info("Has been navigated back.");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        LOG.info("Navigating forward ...");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        LOG.info("Has been navigated forward.");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOG.info("Looking for an element: {" + by + "} ...");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        LOG.info("Found an element: {" + by + "}.");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOG.info("Clicking on {" + element + "} ...");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        LOG.info("Just clicked on {" + element + "}.");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        LOG.info("Changing the value for " + "{" + element + "} ...");
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        LOG.info("Just set a new value for " + "{" + element + "}.");
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        LOG.info("Executing {" + script + "} ...");
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        LOG.info("Just executed {" + script + "}.");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        LOG.info("{" + throwable + "} exception has been thrown");
    }
}
