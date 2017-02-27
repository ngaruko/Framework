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
public class Page3 extends BaseForm{
    By sameAsStreetRadioButton=By.id("rdo21");
    By sameAsPostalRadioButton=By.id("rdo23");
    By differentAddressRadionButton=By.id("rdo22");

    By telephoneCodeDropDown=By.name("organisationtelephonecode");
    By telephoneTextBox=By.id("organisationtelephone_id");


    By secondaryTelephoneCodeDropDown=By.name("organisationsecondarytelephonecode");
    By secondaryTelephoneTextBox=By.id("organisationsecondarytelephone_id");;

    By faxCodeDropDown=By.name("organisationfaxcode");
    By faxTextBox=By.id("organisationfax_id");

    //
    By emalTextBox=By.name("organisationemail");
    By divisionDropDown=By.name("division");
    By gstNumberTextBox=By.name("gstNumber");

    //primary contact

    By prefixDropDown=By.name("primaryContactNamePrefixId");
    By fisrtNameTextBox=By.name("firstNamePrimaryContact");
    By lastNameTextBox=By.name("lastNamePrimaryContact");
    By jobTitleTextBox=By.name("jobtitlerole");
    By emailTextBox=By.name("emailPrimaryContact");
    By primaryTelephoneCodeDropDown=By.name("primarytelephonecode");
    By primaryTelephoneTextBox=By.name("primarytelephone");

    By contactSecondaryTelephoneCodeDropDow=By.name("secondarytelephonecode");
    By contactSecondaryTelephoneTextBox=By.name("secondarytelephone");

    By driversLicenceRadioButton=By.id("eoi_1");

    By birthCertificateRadioButton=By.id("eoi_2");
    By passportRadioButton=By.id("eoi_3");


    public Page3(WebDriver webdriver) {
        super(webdriver);


    }


    public void selectBillingAddress(BillingAddress billingAddress){
        switch (billingAddress) {
            case STREET:healthlinkSelenium.radioButtonHandler().clickRadioButton(sameAsStreetRadioButton);
                break;
            case POSTAL:healthlinkSelenium.radioButtonHandler().clickRadioButton(sameAsPostalRadioButton);
                break;
            case DIFFERENT:healthlinkSelenium.radioButtonHandler().clickRadioButton(differentAddressRadionButton);
                break;
        }


    }

    public void selectEvidenceOfIdentity(Evidence evidence){
        switch (evidence) {
            case DRIVERS:healthlinkSelenium.radioButtonHandler().clickRadioButton(driversLicenceRadioButton);
                break;
            case BIRTH_CERTIFICATE: healthlinkSelenium.radioButtonHandler().clickRadioButton(birthCertificateRadioButton);
                break;
            case PASSPORT:healthlinkSelenium.radioButtonHandler().clickRadioButton(passportRadioButton);
                break;
        }

    }



    enum Evidence{
        DRIVERS,
        BIRTH_CERTIFICATE,
        PASSPORT
    }


    enum BillingAddress{
        STREET,
        POSTAL,
        DIFFERENT
    }
}
