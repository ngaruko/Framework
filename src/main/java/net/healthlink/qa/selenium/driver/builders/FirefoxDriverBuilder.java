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

package net.healthlink.qa.selenium.driver.builders;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * The purpose of this...
 *
 * @author Giles
 */
public class FirefoxDriverBuilder implements WebDriverBuilder {

    private static final String FIREFOX_PROFILE = "firefoxProfile";
    private static final String PROFILE_NAME = "default";

    @Override
    public RemoteWebDriver build() {
        String requiredProfile = System.getProperty(FIREFOX_PROFILE);
        if (StringUtils.isNotBlank(requiredProfile)) {
            return new FirefoxDriver(new ProfilesIni().getProfile(PROFILE_NAME));
        } else {
            return new FirefoxDriver();
        }
    }
}
