/*
 * Copyright (c) 2016 HealthLink Limited.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 *
 */
package net.healthlink.qa.selenium.componentHandlers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class contains all methods related to element
 *
 * @author jaspal
 */
public class ElementHandler {


   // private final ExtentTest extentLogger;
    //private final ExtentReporter extentReporter ;

    //todo magic numbers ===constants??
    private int webDriverWait_numberOfElementsToBe0 = 15;
    private int webDriverWait_visibilityOfElementLocated = 5;
    private int webDriverWait_invisibilityOfElementLocated = 15;
    private int webDriverWait_presenceOfElementLocated = 15;


    private ScreenshotManager screenshotManager = new ScreenshotManager();

//constructor



    public ElementHandler() {

    }


    public WebElement getElement(By elementLocator) {

        if (isElementPresent(elementLocator))

            return HealthlinkSelenium.driver.findElement(elementLocator);
        else
            throw new NoSuchElementException("Element Not Found : " + elementLocator.toString());

    }

    public boolean isElementPresent(By elementLocator) {

        try {
            return getElementCount(elementLocator) >= 1;

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isElementDisplayed(By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement;

        if (isElementPresent(elementLocator)) {

            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

            } catch (Throwable throwable) {
                // After wait, go forward if element is not visible
            }


        } else {
            //todo exception
            return false;
        }
        return getElement(elementLocator).isDisplayed();

    }


    public boolean isElementEnabled(By elementLocator) {

        return getElement(elementLocator).isEnabled();
    }


    //from handleElements class
    public int getElementCount(By elementLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_presenceOfElementLocated);
            wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        }
        catch (Throwable throwable) {
            // After wait, go forward if element is not present
        }
        int elementCount = HealthlinkSelenium.driver.findElements(elementLocator).size();
        return elementCount;
    }


}
