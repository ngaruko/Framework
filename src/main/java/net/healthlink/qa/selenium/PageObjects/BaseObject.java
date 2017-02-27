/*
 * Copyright (c) 2017 HealthLink Limited.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package net.healthlink.qa.selenium.PageObjects;

import net.healthlink.qa.selenium.componentHandlers.WaitHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class BaseObject {

    protected final WebDriver driver;
    String winHandleBefore;

    // TODO: improve the architecture by puting a variable error message into
    // the wait functions
    public BaseObject(WebDriver driver) {
        super();
        this.driver = driver;

    }

    public void waitForElementToAppear(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void waitForElementToBeClickable(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 160);
        wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    public void waitForElementToPresentInDom(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }

    public void waitForFrame(String frameName) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(frameName));
    }

    /**
     * @param sleepTime
     *            - the number of milliseconds to sleep
     * @throws InterruptedException
     */
    public void waitFor(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void clickWithJavascript(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


    public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 20) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public boolean retryingFindSendKeys(By by, String text) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 20) {
            try {
                driver.findElement(by).sendKeys(text);
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public List<WebElement> getLinks(WebDriver driver) throws InterruptedException {
        List<WebElement> linksToClick = new ArrayList<WebElement>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.addAll(driver.findElements(By.tagName("img")));

        for (WebElement e : elements) {
            if (e.getAttribute("href") != null) {
                linksToClick.add(e);
            }
        }
new WaitHandler().wait(3000);
        return linksToClick;
    }


}
