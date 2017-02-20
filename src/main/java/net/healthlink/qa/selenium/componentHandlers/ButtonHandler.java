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
package net.healthlink.qa.selenium.componentHandlers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class ButtonHandler {

    private  WebElement element;
    private  ElementHandler elementHandler=new ElementHandler();


    public  void clickButton(By locator)
    {
        element = elementHandler.getElement(locator);
        element.click();
    }

    public  boolean isButtonEnabled(By locator)
    {
        element = elementHandler.getElement(locator);
        return element.isEnabled();
    }

    public  String getButtonText(By locator)
    {
        element = elementHandler.getElement(locator);
        if (element.getAttribute("value") == null)
            return StringUtils.EMPTY;
        return element.getAttribute("value");
    }

}
