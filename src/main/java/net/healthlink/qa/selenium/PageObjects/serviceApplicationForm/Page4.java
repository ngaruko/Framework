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

import net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class Page4 extends BaseForm{
    private By clinicalSoftwareDropDown=By.id("clinicalsoftware");
    private By operatingSystemDropDown=By.id("operatingsystem");

    //HealthlinkSelenium healthlinkSelenium=new HealthlinkSelenium();

    public Page4(WebDriver webdriver) {
        super(webdriver);
    }

    public void selectClinicalSoftware(ClinicalSoftware clinicalSoftware){
healthlinkSelenium.dropdownHandler().selectOption(clinicalSoftwareDropDown,clinicalSoftware.getName());

    }

    public void selectOperatingSystem(OperatingSystem operatingSystem){

        healthlinkSelenium.dropdownHandler().selectOption(clinicalSoftwareDropDown,operatingSystem.getName());
    }
}
