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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to alert
 *
 * @author jaspal
 */
public class AlertHandler {
    
    private int webDriverWait_alertIsPresent = 5;


    private Alert alert;
    

   public String getAlertText(){

       try {
         WaitHandler.waitUntil(ExpectedConditions.alertIsPresent(), Constants.WAIT_ALERT_PRESENT);
       }
       catch (Throwable throwable ) {
           // After wait, go forward if alert is not present
       }
       try {
           alert = HealthlinkSelenium.driver.switchTo().alert();
           return alert.getText();

       }
       catch (Throwable throwable ) {

           throw new RuntimeException("Step:- Verify alert text and accept it   Failure:- Unable to get text from alert, Exception occured: " + throwable.getMessage());
       }
   }



    public boolean isTextEqualTo(String expectedText) {

        String actualAlertText = getAlertText();

            return actualAlertText.trim().equals(expectedText.trim());

    }


    public void acceptAlert(){
        //todo exception handling

            alert.accept();
    }
    

    public boolean alertTextContains(String expectedText) {
        //Alert alert = null;
        String actualAlertText=getAlertText();

       return actualAlertText.trim().contains(expectedText.trim());
    }
    

    public boolean alertTextWithRegEx(String expectedRegEx) {
        Alert alert;
        String actualAlertText=getAlertText();

        return  actualAlertText.trim().matches(expectedRegEx.trim());
    }
    

    public void dismissAlert(Alert alert) {
//todo exception handling
        alert.dismiss();
    }


    


}
