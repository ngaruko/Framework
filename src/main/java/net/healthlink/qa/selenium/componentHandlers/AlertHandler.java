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

import net.healthlink.qa.selenium.utils.Constants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AlertHandler {

    private Alert alert;
    private String actualAlertText;
    private WaitHandler waitHandler=new WaitHandler();

    private String getAlertText()  {

        waitHandler.waitUntil(ExpectedConditions.alertIsPresent(), Constants.WAIT_ALERT_PRESENT);
        alert = HealthlinkSelenium.driver.switchTo().alert();
        return alert.getText();
    }

    public boolean isTextEqualTo(String expectedText) {

        actualAlertText = getAlertText();

        return actualAlertText.trim().equals(expectedText.trim());

    }


    public void acceptAlert()  {

        waitHandler.waitUntil(ExpectedConditions.alertIsPresent(), Constants.WAIT_ALERT_PRESENT);
        alert.accept();
    }


    public boolean alertTextContains(String expectedText)
    {

        actualAlertText = getAlertText();

        return actualAlertText.trim().contains(expectedText.trim());
    }

    public boolean alertTextWithRegEx(String expectedRegEx)  {
        actualAlertText = getAlertText();
        return actualAlertText.trim().matches(expectedRegEx.trim());
    }

    public void dismissAlert(Alert alert)  {
        waitHandler.waitUntil(ExpectedConditions.alertIsPresent(), Constants.WAIT_ALERT_PRESENT);
        alert.dismiss();
    }


}
