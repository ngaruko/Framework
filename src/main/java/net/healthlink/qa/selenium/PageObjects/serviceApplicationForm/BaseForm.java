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
package net.healthlink.qa.selenium.PageObjects.serviceApplicationForm;

import net.healthlink.qa.selenium.PageObjects.BaseObject;
import net.healthlink.qa.selenium.componentHandlers.ElementHandler;
import net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium;
import net.healthlink.qa.selenium.componentHandlers.WaitHandler;
import net.healthlink.qa.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class BaseForm extends BaseObject {

    private By homeLogoLocator;//
    private By contactDetailsLocator;
    private By contactUsLocator;
    private By formTitleLocator;
    private By getHealthLinkLocator;
    private By previousPageButtonLocator;
    private By nextPageButtonLocator;
    private By pageNumberLocator;

    HealthlinkSelenium healthlinkSelenium = new HealthlinkSelenium();

    public BaseForm(WebDriver webdriver) {
        super(webdriver);

        homeLogoLocator = By.cssSelector("a[title='Home']");
        contactDetailsLocator = By.className("ContactDetails HeaderText");
        contactUsLocator = By.linkText("Contact Us");
        formTitleLocator = By.tagName("h1");
        getHealthLinkLocator = By.linkText("Get HealthLink");
        previousPageButtonLocator = By.cssSelector("input[value='Previous Page']");
        nextPageButtonLocator = By.cssSelector("input[value='Next Page']");
        pageNumberLocator=By.tagName("h3");
    }

    public void goTo() throws InterruptedException {
        driver.get(Constants.FORMS_URL);
//        waitForElementToAppear(homeLogoLocator);

        //new WaitHandler().waitForWebElementInPage(homeLogoLocator,Constants.ELEMENT_LOAD_TIMEOUT);
    }

    public void goNext() {
        healthlinkSelenium.elementHandler().getElement(nextPageButtonLocator).click();
    }

    public void goBack() {
        healthlinkSelenium.elementHandler().getElement(previousPageButtonLocator).click();

    }

    public  boolean isAt(int pageNumber) {
//todo page number

        String pageNumberHeader;
        pageNumberHeader = healthlinkSelenium.elementHandler().getElement(pageNumberLocator).getText();

        System.out.println("Page header text: " + pageNumberHeader);
        String expectedText=String.format("Page {0} of 10", pageNumber);
        return pageNumberHeader.equals(expectedText);
    }
}
