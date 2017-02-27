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
import net.healthlink.qa.selenium.componentHandlers.RadioButtonHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class Page1 extends BaseForm {

    private By healthLinkSecureMessageRadioButtonLocator;//"HealthLink Secure Messaging"
    private By gensolveRadioButton;
    private By endGameRadioButton;

    private By serviceRadioButtonLocator;

    public Page1(WebDriver webdriver) {
        super(webdriver);

    }

    //using link text

    public void chooseService(HealthLinkService service) {
       serviceRadioButtonLocator = By.linkText(service.getName());
        RadioButtonHandler handler = new RadioButtonHandler();
        handler.clickRadioButton(serviceRadioButtonLocator);

    }


}
