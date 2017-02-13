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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import static net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium.driver;

/**
 * This class contains method related to wait
 *
 * @author jaspal
 */
public class WaitHandler {




    public void wait(int waitTimeInMilliseconds) throws InterruptedException {

            Thread.sleep(waitTimeInMilliseconds);
    }

public WebElement waitForElement(final By locator){


    Wait<WebDriver> wait = new FluentWait<WebDriver>(HealthlinkSelenium.driver)
            .withTimeout(20, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);

    WebElement element;
    element = wait.until(new Function<WebDriver, WebElement>() {
        public WebElement apply(WebDriver driver) {
            return driver.findElement(locator);
        }
    });
    return element;
}





}
