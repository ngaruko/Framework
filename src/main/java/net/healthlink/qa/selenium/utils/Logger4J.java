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
package net.healthlink.qa.selenium.utils;

import org.apache.log4j.*;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class Logger4J {

    static Logger log = Logger.getLogger(Logger4J.class);
    static Appender append;

    //@BeforeClass
    public static void setUpBeforeClass(){
        final PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("%d{yyyy-MM-dd} --%-10p %c{1} -%m%n");
        append = new ConsoleAppender(layout);
        log.addAppender(append);
        log.setLevel(Level.INFO);

        log.info("Running before method");
    }

    //@AfterClass
    public static void tearDownAfterClass() {
        log.debug("Running after method");
    }

    //@Test
    public static void logError(Exception error) {
        log.error(error);
    }
}