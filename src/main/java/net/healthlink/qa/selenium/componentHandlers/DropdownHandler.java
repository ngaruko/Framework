/*
 * Copyright (c) 2016 HealthLink Limited.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 *
 */
package net.healthlink.qa.selenium.componentHandlers;

import java.util.List;
import java.util.logging.Logger;

import net.healthlink.qa.selenium.customExceptions.HealthLinkCustomException;
import net.healthlink.qa.selenium.utils.Constants;
import net.healthlink.qa.selenium.utils.Logger4J;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class DropdownHandler {
    private ElementHandler elementHandler = new ElementHandler();


    private int webDriverWait_visibilityOfElementLocated = 5;
    private By elementLocator;


    public void selectOption(By elementLocator, String visibleText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                new WaitHandler().waitUntil(ExpectedConditions.visibilityOfElementLocated(elementLocator), Constants.WAIT_VISIBILITY_OF_ELEMENT);
                webElement = elementHandler.getElement(elementLocator);
                select = new Select(webElement);
                select.selectByVisibleText(visibleText);
            } catch (Exception e) {
                Logger4J.logError(e);

                throw new HealthLinkCustomException("Step:- Select option (" + visibleText + ") Failure:- Unable to select option, Exception occured: " + e.getMessage());
            }
        } else {

            throw new HealthLinkCustomException("Step:- Select option (" + visibleText + "). Failure:- Unable to find element with locator: " + elementLocator);
        }

    }


    public void selectOption(String elementName, By elementLocator, int index) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            } catch (Throwable throwable) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = elementHandler.getElement(elementLocator);
                select = new Select(webElement);
                select.selectByIndex(index);

            } catch (Throwable throwable) {

                throw new RuntimeException("Step:- Select option by index number (" + index + ") from (" + elementName + ")   Failure:- Unable to select option, Exception occured: " + throwable.getMessage());
            }
        } else {

            throw new RuntimeException("Step:- Select option by index number (" + index + ") from (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }

    }


    public void deselectOption(String elementName, By elementLocator, String visibleText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            } catch (Throwable throwable) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = elementHandler.getElement(elementLocator);
                select = new Select(webElement);
                select.deselectByVisibleText(visibleText);

            } catch (Throwable throwable) {

                throw new RuntimeException("Step:- Deselect option (" + visibleText + ") from (" + elementName + ")   Failure:- Unable to deselect option, Exception occured: " + throwable.getMessage());
            }
        } else {

            throw new RuntimeException("Step:- Deselect option (" + visibleText + ") from (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }

    }


    public void deselectAllOptions(String elementName, By elementLocator) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            } catch (Throwable throwable) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = elementHandler.getElement(elementLocator);
                select = new Select(webElement);
                select.deselectAll();

            } catch (Throwable throwable) {

                throw new RuntimeException("Step:- Deselect all options from (" + elementName + ")   Failure:- Unable to deselect options, Exception occured: " + throwable.getMessage());
            }
        } else {

            throw new RuntimeException("Step:- Deselect all options from (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }

    }


    public void verifySelectedOptionEquals(String elementName, By elementLocator, String expectedText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
        WebElement selectedOptionPath;
        String actualSelectedOption;
        boolean gotSelectedOption;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            } catch (Throwable throwable) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = elementHandler.getElement(elementLocator);
                select = new Select(webElement);
                selectedOptionPath = select.getFirstSelectedOption();
                actualSelectedOption = selectedOptionPath.getText();
                gotSelectedOption = true;
            } catch (Throwable throwable) {

                throw new RuntimeException("Step:- Verify selected option in (" + elementName + ")   Failure:- Unable to get selected option from dropdown, Exception occured: " + throwable.getMessage());
            }
            if (gotSelectedOption) {
                if (actualSelectedOption.trim().equals(expectedText)) {

                } else {

                    throw new RuntimeException("Step:- Verify selected option in (" + elementName + ")   Failure:- Actual selected option is: " + actualSelectedOption + ", which is not equal to expected option: " + expectedText);
                }
            }
        } else {

            throw new RuntimeException("Step:- Verify selected option in (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }

    }

    public void verifySelectedOptionContains(String elementName, By elementLocator, String expectedText) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
        WebElement selectedOptionPath;
        String actualSelectedOption;
        boolean gotSelectedOption;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            } catch (Throwable throwable) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = elementHandler.getElement(elementLocator);
                select = new Select(webElement);
                selectedOptionPath = select.getFirstSelectedOption();
                actualSelectedOption = selectedOptionPath.getText();
                gotSelectedOption = true;
            } catch (Throwable throwable) {

                throw new RuntimeException("Step:- Verify selected option in (" + elementName + ")   Failure:- Unable to get selected option from dropdown, Exception occured: " + throwable.getMessage());
            }
            if (gotSelectedOption) {
                if (actualSelectedOption.trim().contains(expectedText)) {

                } else {

                    throw new RuntimeException("Step:- Verify selected option in (" + elementName + ")   Failure:- Actual selected option is: " + actualSelectedOption + ", which does not contains expected option: " + expectedText);
                }
            }
        } else {

            throw new RuntimeException("Step:- Verify selected option in (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }

    }


    public void verifySelectedOptionWithRegEx(String elementName, By elementLocator, String expectedRegEx) {
        WebDriverWait webDriverWait;
        WebElement webElement = null;
        Select select;
        WebElement selectedOptionPath;
        String actualSelectedOption;
        boolean gotSelectedOption;
        // int elementCount = handleElements.getElementCount(elementLocator);
        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webDriverWait = new WebDriverWait(HealthlinkSelenium.driver, webDriverWait_visibilityOfElementLocated);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            } catch (Throwable throwable) {
                // After wait, go forward if element is not visible
            }
            try {
                webElement = elementHandler.getElement(elementLocator);
                select = new Select(webElement);
                selectedOptionPath = select.getFirstSelectedOption();
                actualSelectedOption = selectedOptionPath.getText();
                gotSelectedOption = true;
            } catch (Throwable throwable) {

                throw new RuntimeException("Step:- Verify selected option in (" + elementName + ")   Failure:- Unable to get option from dropdown, Exception occured: " + throwable.getMessage());
            }
            if (gotSelectedOption) {
                if (actualSelectedOption.trim().matches(expectedRegEx)) {

                } else {

                    throw new RuntimeException("Actual selected option is: " + actualSelectedOption + ", which does not match with expected regular expression: " + expectedRegEx);
                }
            }
        } else {

            throw new RuntimeException("Step:- Verify selected option in (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }

    }


    public void verifyOptions(String elementName, By elementLocator, int expectedNumberOfOptions, String[] expectedOptions) {
        WebElement webElement = null;
        Select select;
        List<WebElement> dropdownOptions = null;
        boolean gotOptions;
        boolean verifiedOptionsCount = false;
        int actualNumberOfOptions;

        if (elementHandler.isElementPresent(elementLocator)) {
            try {
                webElement = elementHandler.getElement(elementLocator);
                select = new Select(webElement);
                dropdownOptions = select.getOptions();
                gotOptions = true;
            } catch (Throwable throwable) {

                throw new RuntimeException("Step:- Verify options in (" + elementName + ")   Failure:- Unable to get options from dropdown, Exception occured: " + throwable.getMessage());
            }
            if (gotOptions) {
                actualNumberOfOptions = dropdownOptions.size();
                if (actualNumberOfOptions == expectedNumberOfOptions) {

                    verifiedOptionsCount = true;
                } else {
                    throw new RuntimeException("Step:- Verify number of options in (" + elementName + ")   Failure:- Actual number of options are: " + actualNumberOfOptions + ", which are not equal to expected number of options: " + expectedNumberOfOptions);

                }
            }
            if (verifiedOptionsCount) {
                for (int i = 0; i < expectedOptions.length; i++) {
                    if (expectedOptions[i].equals(dropdownOptions.get(i).getText())) {

                    } else {

                        throw new RuntimeException("Step:- Verify options in (" + elementName + ")   Failure:- Option: '" + dropdownOptions.get(i).getText() + "' is available in dropdown, instead of: '" + expectedOptions[i] + "'");
                    }
                }
            }
        } else {

            throw new RuntimeException("Step:- Verify options in (" + elementName + ")   Failure:- Unable to find element with locator: " + elementLocator);
        }

    }

}
