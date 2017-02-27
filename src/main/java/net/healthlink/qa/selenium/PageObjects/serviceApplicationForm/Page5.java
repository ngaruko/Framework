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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class Page5 extends BaseForm{

    private By ediAccountNumberTextBox=By.id("txt_edi");


    public Page5(WebDriver webdriver) {
        super(webdriver);
    }
}
