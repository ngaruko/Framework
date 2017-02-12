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

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to checkbox
 *
 * @author jaspal
 */
public class CheckboxHandler {
    
    private int webDriverWait_visibilityOfElementLocated = 5;
    private int webDriverWait_elementToBeSelected = 5;
    private int webDriverWait_elementSelectionStateToBeFalse = 5;
    
    private ElementHandler elementHandler = new ElementHandler();
    private ScreenshotManager screenshotManager = new ScreenshotManager();

    
    /**
     * Check element (checkbox).
     * 

     * @param elementLocator Location of the element using a By object.
     */
    public void checkCheckbox(By elementLocator) {
       elementHandler.getElement(elementLocator).click();
    }




    public void uncheckCheckBox(By elementLocator) {
        // TODO: 2/13/2017 ' if checked, click again ...and do we need this here?
        if(isCheckboxChecked(elementLocator)) checkCheckbox(elementLocator);
    }
    

    public boolean isCheckboxChecked(By elementLocator) {
       WebElement element = elementHandler.getElement(elementLocator);
        String flag = element.getAttribute("checked");

        if (flag == null)
            return false;
        else
            return flag.equals("true")|| flag.equals("checked");

    }
    


}
