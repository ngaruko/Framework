package net.healthlink.qa.selenium.utils;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium;
import net.healthlink.qa.selenium.componentHandlers.ScreenshotManager;
import net.healthlink.qa.selenium.services.ReportService;

import java.io.File;
import java.net.URL;

/**
 * Created by beden on 2/9/2017.
 */
public class ExtentReporter implements ReportService {

    //todo maybe make the methods static

    public static ExtentReports extentReport=new ExtentReports("file-path", true);
    private static ExtentTest extentTest=extentReport.startTest("Test name","Some Description");

    private static ScreenshotManager screenshotManager = new ScreenshotManager();

    @Override
    public void reportSuccess(String message) {
        if(extentReport != null) {
            extentTest.log(LogStatus.PASS, message);

        }
    }

    @Override
    public void reportFailure(String message, Throwable throwable) {

        if(extentReport != null) {
            extentTest.log(LogStatus.PASS, message + addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());

        }
    }

    @Override
    public void reportInfo(String message) {
        if(extentReport != null) {
            extentTest.log(LogStatus.INFO, message);

        }
    }

    @Override
    public void configureResultReport(String scenarioName, HealthlinkSelenium healthlinkSelenium) {

        if(extentReport == null) {
            extentReport = new ExtentReports("detailResultReport.html");
            URL url = healthlinkSelenium.getClass().getResource("extent-config.xml");
            extentReport.loadConfig(new File(url.getPath()));
        }
        if(extentReport != null) {
            extentTest = extentReport.startTest(scenarioName);
        }

    }

    @Override
    public void endResultReport() {

        if(extentReport != null) {
            extentReport.endTest(extentTest);
            extentReport.flush();
        }

    }

    @Override
    public String addScreenCapture(String fullScreenshot) {
        return extentTest.addScreenCapture(fullScreenshot);
    }


//   public ExtentReporter(ExtentTest extentLogger) {
//       ExtentReporter.extentTest = extentLogger;
//    }


}
