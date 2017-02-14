package net.healthlink.qa.selenium;

import net.healthlink.qa.selenium.PageObjects.DasboardPage;
import net.healthlink.qa.selenium.PageObjects.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class AppTest

{


    @Test
    public void testApp() {
        //todo unit tests if applicable
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login("bede", "pass");

        //assert belong in tests
        Assert.assertTrue(DasboardPage.isDisplayed());


    }
}