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

/**
 * The purpose of this...
 *
 * @author beden
 */
public enum OperatingSystem {

    LINUX("LINUX"),
    UNKNOWN("Unknown"),
    WINDOWS10("Windows 10"),
    WINDOWS8("Windows 8"),
    WINDOWSSERVER2008("Windows Server 2008"),
    WINDOWSSERVER2012("Windows Server 2012"),
    WINDOWSSERVER2003("Windows Server 2003"),
    WINDOWSSERVER2000("Windows Server 2000"),
    WINDOWSVISTA("Windows Vista"),
    WINDOWSXP("Windows XP"),
    MACOSX("MacOS X"),
    MACOS9("MacOS 9"),
    WINDOWS7("Windows 7"),
    OTHER("Other");

    OperatingSystem(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
