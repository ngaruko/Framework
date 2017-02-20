package net.healthlink.qa.selenium.services;

import com.google.inject.Inject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium;

import java.io.File;
import java.net.URL;

/**
 * Created by beden on 20-Feb-17.
 */
public class Reporter {


    private ReportService service;

    //Guice

    //	constructor based injector
    @Inject
    public Reporter(ReportService svc){
        this.service=svc;
    }


    
    public void reportSuccess(String message) {
        service.reportSuccess(message);
    }

    
    public void reportFailure(String message, Throwable throwable) {
service.reportFailure(message,throwable);

    }

    
    public void reportInfo(String message) {
     service.reportInfo(message);
    }

    
    public void configureResultReport(String scenarioName, HealthlinkSelenium healthlinkSelenium) {
      service.configureResultReport(scenarioName, healthlinkSelenium);
    }

    
    public void endResultReport() {
     service.endResultReport();

    }

    
    public String addScreenCapture(String fullScreenshot) {
       return service.addScreenCapture(fullScreenshot);
    }
    
    
    
    

}
