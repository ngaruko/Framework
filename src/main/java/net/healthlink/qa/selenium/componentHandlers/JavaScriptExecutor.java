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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class JavaScriptExecutor {


    public static Object ExecuteScript(String script)
    {
        JavaScriptExecutor executor = ((JavaScriptExecutor)HealthlinkSelenium.driver);
        return executor.ExecuteScript(script);
    }
    public static void ScrollToAndClick(WebElement element) throws InterruptedException {
        ExecuteScript("window.scrollTo(0," + element.getLocation().getY() + ")");
       WaitHandler.wait(300);
        element.click();
    }

    public static void ScrollToAndClick(By locator) throws InterruptedException {
        WebElement element = new ElementHandler().getElement(locator);
        ExecuteScript("window.scrollTo(0," + element.getLocation().getY() + ")");
        WaitHandler.wait(300);
        element.click();
    }

}
