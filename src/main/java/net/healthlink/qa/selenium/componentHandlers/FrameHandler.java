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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to frame
 *
 * @author jaspal
 */
public class FrameHandler {
    
private int webDriverWait_frameToBeAvailableAndSwitchToIt = 15;
    
       private WebDriverWait webDriverWait= new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_frameToBeAvailableAndSwitchToIt);


    public void switchToFrame(String frameIdOrName) {
        try {

            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdOrName));

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Switch to frame ("+frameIdOrName+")   Failure:- Unable to switch to frame, Exception occured: " + throwable.getMessage());
        }
    }
    

    public void switchToFrame(By frameLocator) {
        try {

            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Switch to frame ("+frameLocator+")   Failure:- Unable to switch to frame, Exception occured: " + throwable.getMessage());
        }
    }
    

    public void switchToFrame(int frameIndex) {
        try {

            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Switch to frame ("+frameIndex+")   Failure:- Unable to switch to frame, Exception occured: " + throwable.getMessage());
        }
    }
    

    public void switchToDefaultFrame() {
        try {
            HealthlinkSelenium.driver.switchTo().defaultContent();

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Switch to default frame   Failure:- Unable to switch to default frame, Exception occured: " + throwable.getMessage());
        }
    }

}
