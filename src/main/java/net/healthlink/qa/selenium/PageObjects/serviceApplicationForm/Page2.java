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
import net.healthlink.qa.selenium.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.event.HierarchyEvent;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class Page2 extends BaseForm {

    private By legalNameTextBox;
    private By knownAsTextBox;
    private By organizationTypeDropDown;

    private By streetAddressPartOneTextBox;
    private By streetAddressPartTwoTextBox;
    private By cityTextBox;
    private By regionDropDown;
    private By postCodeTextBox;
    private By lookupLink;
    private By countryTextBox;
    private By sameAddressRadioButton;
    private By differentAddressRadioButton;

    //postal adddress in case different
    private By postalStreetAddressPartOneTextBox;
    private By postalStreetAddressPartTwoTextBox;
    private By postalCityTextBox;
    private By postalRegionDropDown;
    private By postalPostCodeTextBox;
    private By postalLookupLink;
    private By postalCountryTextBox;

    private HealthlinkSelenium healthlinkSelenium = new HealthlinkSelenium();



    public Page2(WebDriver webdriver) {
        super(webdriver);
        //initialise page elements
        legalNameTextBox = By.name("organisationname");
        knownAsTextBox = By.name("knownas");
        organizationTypeDropDown = By.name("organisationtype");
        streetAddressPartOneTextBox = By.name("streetaddresspartone");
        streetAddressPartTwoTextBox = By.name("streetaddresspartwo");
        cityTextBox = By.name("streetaddresssuburb");
        regionDropDown = By.name("streetaddressregionlist");

        //postal
        postalStreetAddressPartOneTextBox = By.name("postalstreetaddresspartone");
        postalStreetAddressPartTwoTextBox = By.name("postalstreetaddresspartwo");
        postalCityTextBox = By.name("postalstreetaddresssuburb");
        postalRegionDropDown = By.name("postalstreetaddressregionlist");


    }

    public void completePage() {
        //todo break this in more methods

        healthlinkSelenium.textboxHandler().fillValue(legalNameTextBox, Constants.ORG_LEGAL_NAME);
        healthlinkSelenium.textboxHandler().fillValue(knownAsTextBox, Constants.ORG_ALIAS);
        healthlinkSelenium.dropdownHandler().selectOption(organizationTypeDropDown, OrganizationTypes.AGED.getFullName());
        healthlinkSelenium.textboxHandler().fillValue(streetAddressPartOneTextBox, "23 Mayor Street");
        healthlinkSelenium.textboxHandler().fillValue(streetAddressPartTwoTextBox, "Newmarket");
        healthlinkSelenium.textboxHandler().fillValue(cityTextBox, "Auckland");
        //SELECT REGION
       healthlinkSelenium.dropdownHandler().selectOption(regionDropDown, Regions.AUCKLAND.getFullName());

       healthlinkSelenium.textboxHandler().fillValue(postCodeTextBox, "3011");
    }

    public void lookupPostCode(){
       healthlinkSelenium.elementHandler().getElement(lookupLink).click();
    }
 public String getCountry(){
        return healthlinkSelenium.textboxHandler().getTextBoxValue(countryTextBox);
 }

 public boolean isPostalAddressDifferent(){

     return healthlinkSelenium.radioButtonHandler().isRadioButtonSelected(differentAddressRadioButton);
 }


    public void completePostalAddress() {

        healthlinkSelenium.textboxHandler().fillValue(postalStreetAddressPartOneTextBox, "12 Rua Street");
        healthlinkSelenium.textboxHandler().fillValue(postalStreetAddressPartTwoTextBox, "Mangapapa");
        healthlinkSelenium.textboxHandler().fillValue(postalCityTextBox, "Gisborne");
        //SELECT REGION
        healthlinkSelenium.dropdownHandler().selectOption(postalRegionDropDown, Regions.GISBORNE.getFullName());
        healthlinkSelenium.textboxHandler().fillValue(postalPostCodeTextBox, "2012");
    }
}
