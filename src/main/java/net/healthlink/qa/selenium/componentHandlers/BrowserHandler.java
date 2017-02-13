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

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to browser
 *
 * @author jaspal
 */
public class BrowserHandler {
    
private int pageLoadTimeout = 60;
    

    public void launchBrowser(String browserName) {
        //todo use selenium-driver by Giles

    }


    public void quitBrowser() {
//todo use selenium-driver by Giles

        try {
            if(HealthlinkSelenium.driver != null) {
                HealthlinkSelenium.driver.quit();
            }

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Quit browser window and session   Failure:- Unable to quit browser, Exception occured: " + throwable.getMessage());
        }
    }

    /**
     * Close one browser window (active window).
     */
    public void closeBrowser() {
        try {
            HealthlinkSelenium.driver.close();

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Close browser window   Failure:- Unable to close browser, Exception occured: " + throwable.getMessage());
        }
    }

    /**
     * Maximize browser window.
     */
    public void maximizeBrowser() {
        try {
            HealthlinkSelenium.driver.manage().window().maximize();

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Maximize browser window   Failure:- Unable to maximize browser window, Exception occured: " + throwable.getMessage());
        }
    }


//other

    public static void goBack()
    {
        HealthlinkSelenium.driver.navigate().back();
    }

    public static void forward()
    {
        HealthlinkSelenium.driver.navigate().forward();
    }

    public static void refreshPage()
    {
       HealthlinkSelenium.driver.navigate().refresh();
    }


    public String getUrl(){
        return HealthlinkSelenium.driver.getCurrentUrl();
    }

}
