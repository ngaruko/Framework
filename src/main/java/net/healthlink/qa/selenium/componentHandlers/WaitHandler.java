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

import com.google.common.base.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium.driver;
import static net.healthlink.qa.selenium.utils.Constants.ELEMENT_LOAD_TIMEOUT;

/**
 * This class contains method related to wait
 *
 * @author Bede
 */
public class WaitHandler {


    private static final long POLLING_INTERVAL = 5;

    public static void wait(int waitTimeInMilliseconds) throws InterruptedException {

        Thread.sleep(waitTimeInMilliseconds);
    }


    public Function<WebDriver, Boolean> waitForWebElementFunc(final By locator) {

        return ((x) -> {
            if (x.findElements(locator).size() == 1)
                return true;
            return false;

        });


    }


    public Function<WebDriver, WebElement> waitForWebElementInPageFunc(final By locator) {

        return ((x) -> {
            if (x.findElements(locator).size() == 1)
                return x.findElement(locator);
            return null;

        });


    }

    //wait for element
    public boolean waitForWebElement(By locator, long timeout) throws InterruptedException {
        wait(ELEMENT_LOAD_TIMEOUT);
        WebDriverWait wait = getWebDriverWait(timeout);
        Boolean flag = wait.until(waitForWebElementFunc(locator));
        wait(ELEMENT_LOAD_TIMEOUT);
        return flag;
    }

    //wait for element in page
    public WebElement waitForWebElementInPage(By locator, long timeout) throws InterruptedException {
        wait(ELEMENT_LOAD_TIMEOUT);
        WebDriverWait wait = getWebDriverWait(timeout);
        WebElement element = wait.until(waitForWebElementInPageFunc(locator));
        wait(ELEMENT_LOAD_TIMEOUT);
        return element;
    }


    private static WebDriverWait getWebDriverWait(long timeout) throws InterruptedException {
        wait(ELEMENT_LOAD_TIMEOUT);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return (WebDriverWait) wait;
    }


    //wait for condition
    public static <T> void waitUntil(ExpectedCondition<T> expectedCondition, long timeout) {
        WebDriverWait webDriverWait = null;

                try {
            webDriverWait = getWebDriverWait(timeout);
            webDriverWait.until(expectedCondition);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
