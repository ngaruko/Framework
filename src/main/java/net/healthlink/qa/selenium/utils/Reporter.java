package net.healthlink.qa.selenium.utils;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium;
import net.healthlink.qa.selenium.componentHandlers.ScreenshotManager;

import java.io.File;
import java.net.URL;

/**
 * Created by beden on 2/9/2017.
 */
public class Reporter {

    //todo maybe make the methods static

    public static ExtentReports extentReport=new ExtentReports("file-path", true);
    private static ExtentTest extentTest=extentReport.startTest("Test name","Some Description");

    private static ScreenshotManager screenshotManager = new ScreenshotManager();


//   public Reporter(ExtentTest extentLogger) {
//       Reporter.extentTest = extentLogger;
//    }


    public static void reportSuccess(String message){

        if(extentReport != null) {
            extentTest.log(LogStatus.PASS, message);

        }
    }

    public static  void reportFailure(String message, Throwable throwable){

        if(extentReport != null) {
            extentTest.log(LogStatus.PASS, message + addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());

        }
    }

    public static  void reportInfo(String message){

        if(extentReport != null) {
            extentTest.log(LogStatus.INFO, message);

        }

    }

    /**
     * Configure extent result report including logger, step description, expected result, actual result and failure screenshot.
     *
     * @param scenarioName Name of the scenario (test case).
     * @param healthlinkSelenium
     */
    public static void configureExtentResultReport(String scenarioName, HealthlinkSelenium healthlinkSelenium) {
        if(extentReport == null) {
            extentReport = new ExtentReports("detailResultReport.html");  
            URL url = healthlinkSelenium.getClass().getResource("extent-config.xml");
            extentReport.loadConfig(new File(url.getPath()));
        }
        if(extentReport != null) {
            extentTest = extentReport.startTest(scenarioName);
        }
    }

    /**
     * End extent result report.
     *
     */
    public static void endExtentResultReport() {
        if(extentReport != null) {
            extentReport.endTest(extentTest);
            extentReport.flush();  
        }
    }

    public static String addScreenCapture(String fullScreenshot) {
        return extentTest.addScreenCapture(fullScreenshot);
    }
}
