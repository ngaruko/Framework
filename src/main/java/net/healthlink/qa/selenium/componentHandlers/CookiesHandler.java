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

public class CookiesHandler {

    public void deleteAllCookies() {
        try {
            HealthlinkSelenium.driver.manage().deleteAllCookies();

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Delete all cookies   Failure:- Unable to delete cookies, Exception occured: " + throwable.getMessage());
        }
    }
    

    public void deleteCookie(String cookieName) {
        try {
            HealthlinkSelenium.driver.manage().deleteCookieNamed(cookieName);

        }
        catch (Throwable throwable ) {

            throw new RuntimeException("Step:- Delete cookie   Failure:- Unable to delete cookie named: "+cookieName+", Exception occured: " + throwable.getMessage());
        }
    }

}
