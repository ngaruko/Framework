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

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all methods related to page title
 *
 * @author jaspal
 */
public class PageTitleHandler {

    
    public PageTitleHandler() {

    }
    
    private int webDriverWait_titleIs = 15;
    private int webDriverWait_titleContains = 15;
    

    public boolean isPageTitleEqualTo(String expectedTitle) {
        String actualTitle;

        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_titleIs);
            webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));
        }
        catch (Throwable throwable ) {
            // After wait, go forward if actual title not contains expected title
        }
        
        try {
            actualTitle = HealthlinkSelenium.driver.getTitle();

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Verify current page title   Failure:- Unable to get page title, Exception occured: " + throwable.getMessage());
        }
        return actualTitle.trim().equals(expectedTitle.trim());
    }


    public boolean pageTitleContains(String expectedTitle) {
        String actualTitle;

        try {
            WebDriverWait webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_titleContains);
            webDriverWait.until(ExpectedConditions.titleContains(expectedTitle));
        }
        catch (Throwable throwable ) {
            // After wait, go forward if actual title not contains expected title
        }
        try {
            actualTitle = HealthlinkSelenium.driver.getTitle();

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Verify current page title   Failure:- Unable to get page title, Exception occured: " + throwable.getMessage());
        }
        return actualTitle.trim().contains(expectedTitle.trim());
    }
    

    public boolean pageTitleWithRegEx(String expectedRegEx) {
        String actualTitle;

        try {
            actualTitle = HealthlinkSelenium.driver.getTitle();

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Verify current page title   Failure:- Unable to get page title, Exception occured: " + throwable.getMessage());
        }
        return actualTitle.trim().matches(expectedRegEx);
    }

}
