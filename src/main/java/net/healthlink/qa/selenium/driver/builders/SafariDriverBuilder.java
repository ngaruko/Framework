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

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * The purpose of this...
 *
 * @author Giles
 */
public class SafariDriverBuilder implements WebDriverBuilder {

    @Override
    public RemoteWebDriver build() {
        return new SafariDriver();
    }
}
