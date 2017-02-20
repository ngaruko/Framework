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

import net.healthlink.qa.selenium.componentHandlers.ButtonHandler;
import net.healthlink.qa.selenium.componentHandlers.ElementHandler;
import net.healthlink.qa.selenium.componentHandlers.TextboxHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The purpose of this...
 *
 * @author beden
 */
public class LoginPage {


    WebElement usernameTextBox;

     WebElement passwordTextBox;

     WebElement loginButton;

    public LoginPage() {
        usernameTextBox=new ElementHandler().getElement(By.id("user"));
         passwordTextBox=new ElementHandler().getElement(By.id("user"));
        loginButton=new ElementHandler().getElement(By.id("user"));
    }

    public  void goTo() {
        //navigate to url

    }



    public  void login(String username, String password) {

        //can use element handler function to handle exceptions and timeouts
usernameTextBox.sendKeys(username);
passwordTextBox.sendKeys(password);
loginButton.click();
        //new TextboxHandler().fillValue(usernameTextBox,username);
    }

}
