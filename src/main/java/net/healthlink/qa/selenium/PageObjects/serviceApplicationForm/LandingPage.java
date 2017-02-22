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

import net.healthlink.qa.selenium.componentHandlers.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class LandingPage extends BaseForm {

    private By selectedregionLink;

    public LandingPage(WebDriver webdriver) {
        super(webdriver);

    }

    public void selectRegion(String region) throws InterruptedException {

       try {
           for (WebElement element : getLinks(driver)) {
               if (element.isDisplayed() && region.equals(element.getText().trim())) {

                   System.out.println("Going to  " + element.getText());
                   element.click();
               }

           }
       }catch (Exception e){
           System.out.println("GOT EXCEPTION: " + e.getMessage());
       }
        //selectedregionLink = By.partialLinkText(region);
      //  waitForElementToBeClickable(selectedregionLink);
       // new ElementHandler().getElement(selectedregionLink).click();
    }
}
