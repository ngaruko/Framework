package net.healthlink.qa.selenium.services;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium;

import java.io.File;
import java.net.URL;

/**
 * Created by beden on 17-Feb-17.
 */
public interface ReportService {
     void reportSuccess(String message);

      void reportFailure(String message, Throwable throwable);

      void reportInfo(String message);


     void configureResultReport(String scenarioName, HealthlinkSelenium healthlinkSelenium);

     void endResultReport() ;

     String addScreenCapture(String fullScreenshot) ;
}
