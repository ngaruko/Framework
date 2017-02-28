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
public class CheckboxHandler extends ElementHandler{

    private ScreenshotManager screenshotManager = new ScreenshotManager();

    public void checkCheckbox(By elementLocator) {
        if(!isCheckboxChecked(elementLocator)) {
            clickElement(elementLocator);
        }
    }


    public void uncheckCheckBox(By elementLocator) {

        if(isCheckboxChecked(elementLocator)) {
            clickElement(elementLocator);
        }
    }
    

    private boolean isCheckboxChecked(By elementLocator) {
        WebElement element = getElement(elementLocator);
        String flag = element.getAttribute("checked");

        return flag != null && (flag.equals("true") || flag.equals("checked"));

    }
    


}
