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
package net.healthlink.qa.selenium.componentHandlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class ComboBoxHandler {

    private  Select select;
    private  ElementHandler elementHandler=new ElementHandler();

    public  void SelectElement(By locator, int index)
    {
        select = new Select(elementHandler.getElement(locator));
        select.selectByIndex(index);
    }

    public  void SelectElement(By locator, String visibleText)
    {
        select = new Select(elementHandler.getElement(locator));
        select.selectByVisibleText(visibleText);
    }

    public  void SelectElementByValue(By locator, String valueTexts)
    {
        select = new Select(elementHandler.getElement(locator));
        select.selectByValue(valueTexts);
    }

    public  List<String> GetAllItem(By locator)
    {
        ArrayList<String> results = new ArrayList<>();
        select = new Select(elementHandler.getElement(locator));
        Stream<WebElement> stream=select.getOptions().stream();
        stream.forEach(webElement ->results.add(webElement.getText()));
        return results;

    }

    public  void SelectElement(WebElement element, String visibleText)
    {
        select = new Select(element);
        select.selectByValue(visibleText);
    }

}
