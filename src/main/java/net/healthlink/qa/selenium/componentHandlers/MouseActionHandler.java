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

import net.healthlink.qa.selenium.utils.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to mouse action
 *
 * @author jaspal
 */
public class MouseActionHandler {
    

    
    public MouseActionHandler() {

    }
    
    private int webDriverWait_elementToBeClickable = 5;
    private int webDriverWait_visibilityOfElementLocated = 5;
    
    private ElementHandler elementHandler = new ElementHandler();
    private ScreenshotManager screenshotManager = new ScreenshotManager();
    
    /**
     * Click on element.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void click(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
       
        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeClickable);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not clickable
            }
            try {
                webElement =elementHandler.getElement(elementLocator);
                webElement.click();

            }
            catch (Throwable throwable ) {

                throw new RuntimeException("Step:- Click on element ("+elementName+")   Failure:- Unable to click on element, Exception occured: " + throwable.getMessage());
            }
        }
        else  {

            throw new RuntimeException("Step:- Click on element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }

    }
    
    /**
     * Move mouse cursor on element.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void moveMouse(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Actions actions;
       
        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement =elementHandler.getElement(elementLocator);
                actions = new Actions(HealthlinkSelenium.driver);
                actions.moveToElement(webElement).perform();

            }
            catch (Throwable throwable ) {

                throw new RuntimeException("Step:- Move mouse on element ("+elementName+")   Failure:- Unable to move mouse on element, Exception occured: " + throwable.getMessage());
            }
        }
        else  {

            throw new RuntimeException("Step:- Move mouse on element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }

    }
    
    /**
     * Right click on element.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void rightClick(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Actions actions;
       
        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeClickable);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not clickable
            }
            try {
                webElement =elementHandler.getElement(elementLocator);
                actions = new Actions(HealthlinkSelenium.driver);
                actions.contextClick(webElement).perform();

            }
            catch (Throwable throwable ) {

                throw new RuntimeException("Step:- Right click on element ("+elementName+")   Failure:- Unable to right click on element, Exception occured: " + throwable.getMessage());
            }
        }
        else  {

            throw new RuntimeException("Step:- Right click on element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }

    }
    
    /**
     * Double click on element.
     * 
     * @param elementName Name of the element.
     * @param elementLocator Location of the element using a By object.
     */
    public void doubleClick(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Actions actions;
        //int elementCount = handleElements.getElementCount(elementLocator);
        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_elementToBeClickable);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            }
            catch (Throwable throwable ) {
                // After wait, go forward if element is not clickable
            }
            try {
                webElement =elementHandler.getElement(elementLocator);
                actions = new Actions(HealthlinkSelenium.driver);
                actions.doubleClick(webElement).perform();

            }
            catch (Throwable throwable ) {

                throw new RuntimeException("Step:- Double click on element ("+elementName+")   Failure:- Unable to double click on element, Exception occured: " + throwable.getMessage());
            }
        }
        else  {

            throw new RuntimeException("Step:- Double click on element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }

    }

}
