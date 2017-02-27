/*
 * Copyright (c) 2016 HealthLink Limited.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */

package net.healthlink.qa.selenium.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * The purpose of this...
 *
 * @author Giles
 */
public class WebDriverWrapper {

    private WebDriver driver;

    public WebDriverWrapper(DriverType driverType) {
        this.driver = driverType.getRemoteDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }
}
