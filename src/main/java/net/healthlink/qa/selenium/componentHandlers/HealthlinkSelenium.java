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

import net.healthlink.qa.selenium.driver.DriverType;
import net.healthlink.qa.selenium.driver.WebDriverWrapper;
import net.healthlink.qa.selenium.utils.ExtentReporter;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * This class consolidates all handlers
 *
 * @author jaspal
 */
public class HealthlinkSelenium {

    // TODO: 2/13/2017 Refactor ot remove this 
    
   public static ExtentReports extentReport;

   //
    public static ExtentReporter extentReporter;
    public static ExtentTest extentLogger;
    public static WebDriver driver=new WebDriverWrapper(DriverType.CHROME).getDriver();
    
    private final AlertHandler alertHandler = new AlertHandler();
    private final BrowserHandler browserHandler = new BrowserHandler();
    private final CheckboxHandler checkboxHandler = new CheckboxHandler();
    private final CookiesHandler cookiesHandler = new CookiesHandler();
    private final DropdownHandler dropdownHandler = new DropdownHandler();

    //get rid of logger stuff here

   private final ElementHandler elementHandler = new ElementHandler();

    //like so
    //private final ElementHandler elementHandler = new ElementHandler(extentReporter);

    private final FrameHandler frameHandler = new FrameHandler();
    private final KeyboardActionHandler keyboardActionHandler = new KeyboardActionHandler();
    private final MouseActionHandler mouseActionHandler = new MouseActionHandler();
    private final PageTitleHandler pageTitleHandler = new PageTitleHandler();
    private final ScrollHandler scrollHandler = new ScrollHandler();
    private final TextboxHandler textboxHandler = new TextboxHandler();


    private final WaitHandler waitHandler = new WaitHandler();
    private final WindowHandler windowHandler = new WindowHandler();
    private RadioButtonHandler radioButtonHandler=new RadioButtonHandler();


    public AlertHandler alertHandler() {
        return alertHandler;
    }
    
    public BrowserHandler browserHandler() {
        return browserHandler;
    }
    
    public CheckboxHandler checkboxHandler() {
        return checkboxHandler;
    }
    
    public CookiesHandler cookiesHandler() {
        return cookiesHandler;
    }
    
    public DropdownHandler dropdownHandler() {
        return dropdownHandler;
    }
    
    public ElementHandler elementHandler() {
        return elementHandler;
    }
    
    public FrameHandler frameHandler() {
        return frameHandler;
    }
    
    public KeyboardActionHandler keyboardActionHandler() {
        return keyboardActionHandler;
    }
    
    public MouseActionHandler mouseActionHandler() {
        return mouseActionHandler;
    }
    
    public PageTitleHandler pageTitleHandler() {
        return pageTitleHandler;
    }
    
    public ScrollHandler scrollHandler() {
        return scrollHandler;
    }
    
    public TextboxHandler textboxHandler() {
        return textboxHandler;
    }


    public RadioButtonHandler radioButtonHandler() {
        return radioButtonHandler;
    }

    
    public WaitHandler waitHandler() {
        return waitHandler;
    }
    
    public WindowHandler windowHandler() {
        return windowHandler;
    }


    /**
     * Get WebDriver object.
     */
    public WebDriver getDriver() {

        return driver;
    }

}
