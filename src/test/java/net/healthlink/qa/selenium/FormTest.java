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

    private static HealthlinkSelenium healthlinkSelenium = new HealthlinkSelenium();

    @BeforeClass
    public static void initialize() {
        driver = healthlinkSelenium.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void LandingPageTest() throws InterruptedException {

        // given
        LandingPage landingPage = new LandingPage(driver);

        landingPage.goTo();

        new WaitHandler().wait(3000);

        landingPage.selectRegion("North Island");

        assertThat(new Page1(driver).isAt(1));
    }


    public enum MyType {
        ONE("This is number one"),
        STRING_TWO("TWO");


        private final String text;

        /**
         * @param text
         */
        private MyType(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }


    @Test
    public void testenum() {

        // System.out.println(new BaseForm(driver).);
        System.out.println(MyType.ONE.text);


        initialize();
        printService(ClinicalSoftware.CLOUDAPPOINTMENTS);

    }

    private void printService(ClinicalSoftware software) {
        System.out.println(software.getName());
    }

}
