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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;


public class ScrollHandler {
    
    private ElementHandler elementHandler = new ElementHandler();


    public void scrollToElement(String elementName, By elementLocator) {
        WebElement webElement;
        JavascriptExecutor javascriptExecutor;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webElement = elementHandler.getElement(elementLocator);
                javascriptExecutor = (JavascriptExecutor) HealthlinkSelenium.driver;
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);

            }
            catch (Throwable throwable ) {

                throw new RuntimeException("Step:- Scroll to element ("+elementName+")   Failure:- Unable to scroll to element, Exception occured: " + throwable.getMessage());
            }
        }
        else {

            throw new RuntimeException("Step:- Scroll to element ("+elementName+")   Failure:- Unable to find element with locator: "+elementLocator);
        }

    }

}
