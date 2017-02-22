package net.healthlink.qa.selenium;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.healthlink.qa.selenium.PageObjects.DasboardPage;
import net.healthlink.qa.selenium.PageObjects.LoginPage;
import net.healthlink.qa.selenium.services.ReportInjector;
import net.healthlink.qa.selenium.services.Reporter;
import org.junit.Assert;
import org.junit.Test;

public class AppTest

{


    @Test
    public void testApp() {
        //todo unit tests if applicable
       // given

       LoginPage loginPage = new LoginPage();

        loginPage.goTo();

        //when
        loginPage.login("bede", "pass");

        //assert belong in tests
        // then
        Assert.assertTrue(DasboardPage.isDisplayed());
        //

//given
        RegistrationPage.LegalName.sendKeys("mane");
        


    }

    @Test
    public void testReport() {
        //todo unit tests if applicable
        // given
        Injector injector= Guice.createInjector(new ReportInjector());
        Reporter reporter=injector.getInstance(Reporter.class);

        reporter.reportSuccess("Hey. We made it");


    }
}