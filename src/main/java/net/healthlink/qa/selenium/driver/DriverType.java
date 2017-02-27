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

import net.healthlink.qa.selenium.driver.builders.*;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Arrays;
import java.util.List;

/**
 * The purpose of this...
 *
 * @author Giles
 */
public enum DriverType {

    INTERNET_EXPLORER(new InternetExplorerDriverBuilder(), "internet explorer", "ie", "internet_explorer"),
    FIREFOX(new FirefoxDriverBuilder(), "firefox"),
    CHROME(new ChromeDriverBuilder(), "chrome"),
    SAFARI(new SafariDriverBuilder(), "safari"),
    DEFAULT(new InternetExplorerDriverBuilder(), "");

    private final WebDriverBuilder builder;
    private final List<String> gridNames;

    DriverType(WebDriverBuilder builder, String... gridNames) {
        this.builder = builder;
        this.gridNames = Arrays.asList(gridNames);
    }

    public static DriverType getDriverTypeFromText(String text) {
        for (DriverType type : DriverType.values()) {
            if (type.gridNames.contains(text)) {
                return type;
            }
        }
        return DEFAULT;
    }

    public RemoteWebDriver getRemoteDriver() {
        //path to chrome driver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //path to gecko driver
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        return builder.build();
    }
}
