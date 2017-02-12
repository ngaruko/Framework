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

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import com.relevantcodes.extentreports.LogStatus;

/**
 * This class contains all methods related to keyboard actions
 *
 * @author jaspal
 */
public class KeyboardActionHandler {


    public void pressKeyboardKey(Keys key) {
        try {
            Keyboard keyboard = ((HasInputDevices) HealthlinkSelenium.driver).getKeyboard();
            keyboard.pressKey(key);

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Press key from keyboard ("+key.name()+")   Failure:- Unable to press enter, Exception occured: " + throwable.getMessage());
        }
    }
    

    public void pressKeyboardKeys(Keys key, char character) {
        try {
            String charToString = Character.toString(character);
            Keyboard keyboard = ((HasInputDevices) HealthlinkSelenium.driver).getKeyboard();
            keyboard.sendKeys(key, charToString);

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Press two keys together from keyboard ("+key.name()+", "+character+")   Failure:- Unable to press keys, Exception occured: " + throwable.getMessage());
        }
    }
    

    public void pressKeyboardKeys(Keys key1, Keys key2, char character) {
        try {
            String charToString = Character.toString(character);
            Keyboard keyboard = ((HasInputDevices) HealthlinkSelenium.driver).getKeyboard();
            keyboard.sendKeys(key1, key2, charToString);

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Press three keys together from keyboard ("+key1.name()+", "+key2.name()+", "+character+")   Failure:- Unable to press keys, Exception occured: " + throwable.getMessage());
        }
    }

}
