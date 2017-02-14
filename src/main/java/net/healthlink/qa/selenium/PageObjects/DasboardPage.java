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
package net.healthlink.qa.selenium.PageObjects;

import net.healthlink.qa.selenium.componentHandlers.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class DasboardPage {


    public static boolean isDisplayed() {

               return new ElementHandler().isElementPresent(By.id("dashbordTitle"));
    }
}
