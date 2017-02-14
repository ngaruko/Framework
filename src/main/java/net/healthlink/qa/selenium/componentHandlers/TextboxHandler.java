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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * This class contains all methods related to textbox
 *
 * @author jaspal
 */
public class TextboxHandler {

    // TODO: 2/13/2017 Lookout for magin numbers and waits??  and try/catch
    public TextboxHandler(){
    }

    private int webDriverWait_visibilityOfElementLocated = 5;
    private int webDriverWait_textToBePresentInElementValue = 5;

    private ElementHandler elementHandler = new ElementHandler();

    public void fillValue(By elementLocator, String value) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            } catch (Throwable throwable) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = elementHandler.getElement(elementLocator);
                webElement.clear();
                webElement.sendKeys(value);

            } catch (Throwable throwable) {

               // throw new RuntimeException("Step:- Fill value (" + value + ") in (" + elementName + ")   Failure:- Unable to fill value, Exception occured: " + throwable.getMessage());
            }
        } else {

           // throw new RuntimeException("Step:- Fill value (" + value + ") in (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }

    }


    public void clearValue(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        // int elementCount = handleElements.getElementCount(elementLocator);

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            } catch (Throwable throwable) {
                // After wait, go forward if element is not visible
            }
            try {

                elementHandler.getElement(elementLocator).clear();

            } catch (Throwable throwable) {

                throw new RuntimeException("Step:- Clear value from (" + elementName + ")   Failure:- Unable to clear value, Exception occured: " + throwable.getMessage());
            }
        } else {

            throw new RuntimeException("Step:- Clear value from (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }

    }


    public boolean verifyValueEquals(By elementLocator, String expectedValue) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        String actualValue;
        boolean gotValue;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementValue);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, expectedValue));
            } catch (Throwable throwable) {
                // After wait, go forward if value not contains expected value
            }
            try {
                webElement = elementHandler.getElement(elementLocator);
                actualValue = webElement.getAttribute("value");

            } catch (Throwable throwable) {

                throw new RuntimeException(" Failure:- Unable to get value from textbox, Exception occured: " + throwable.getMessage());
            }

        } else {

            throw new RuntimeException("Failure:- Unable to find element with locator: " + elementLocator);
        }
        return actualValue.trim().equals(expectedValue.trim());
    }


    public boolean textBoxValueContains(By elementLocator, String expectedValue) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        String actualValue;
        boolean gotValue;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_textToBePresentInElementValue);
                webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, expectedValue));
            } catch (Throwable throwable) {
                // After wait, go forward if value not contains expected value
            }
            try {
                webElement = elementHandler.getElement(elementLocator);
                actualValue = webElement.getAttribute("value");

            } catch (Throwable throwable) {

                throw new RuntimeException("  Failure:- Unable to get value from textbox, Exception occured: " + throwable.getMessage());
            }

        } else {

            throw new RuntimeException("Sailure:- Unable to find element with locator: " + elementLocator);
        }

        return actualValue.trim().contains(expectedValue.trim());
    }


    public boolean texBoxValueWithRegEx(String elementName, By elementLocator, String expectedRegEx) {
        WebElement webElement;
        String actualValue;


        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webElement = elementHandler.getElement(elementLocator);
                actualValue = webElement.getAttribute("value");

            } catch (Throwable throwable) {

                throw new RuntimeException("Step:- Verify value in (" + elementName + ")   Failure:- Unable to get value from textbox, Exception occured: " + throwable.getMessage());
            }

        } else {

            throw new RuntimeException("Step:- Verify value in (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }
        return actualValue.trim().matches(expectedRegEx.trim());
    }

}
