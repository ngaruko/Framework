/*
 * Copyright (c) 2017 HealthLink Limited.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package net.healthlink.qa.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.healthlink.qa.selenium.PageObjects.serviceApplicationForm.*;
import net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium;
import net.healthlink.qa.selenium.componentHandlers.WaitHandler;
import net.healthlink.qa.selenium.componentHandlers.WindowHandler;
import net.healthlink.qa.selenium.driver.DriverType;
import net.healthlink.qa.selenium.driver.WebDriverWrapper;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class FormTest {

    private static WebDriver driver;

    private static HealthlinkSelenium healthlinkSelenium ;
    private BaseForm form;

    @BeforeClass
    public static void initialize() {
        driver  =new HealthlinkSelenium().getDriver();
        new WindowHandler().maximize(driver);

        //healthlinkSelenium = new HealthlinkSelenium(new WebDriverWrapper(DriverType.CHROME).getDriver());

    }

    @Test
    public void LandingPageTest() throws InterruptedException {
                // given
        LandingPage landingPage = new LandingPage(driver);

        landingPage.goTo();
        //when
       form= landingPage.selectRegion("North Island");
        //then
        assertThat(new Page1(driver).isAt(1));
    }

    @Test
    public void Page1Test() throws InterruptedException {

             assertThat(new Page1(driver).isAt(1));

    }



    @AfterClass
    public static void tearDown() {
        driver.close();
        driver.quit();
    }


}
