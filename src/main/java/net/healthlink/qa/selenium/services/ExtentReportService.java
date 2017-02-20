package net.healthlink.qa.selenium.services;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import net.healthlink.qa.selenium.componentHandlers.HealthlinkSelenium;
import net.healthlink.qa.selenium.componentHandlers.ScreenshotManager;

import java.io.File;
import java.net.URL;

/**
 * Created by beden on 20-Feb-17.
 */
public class ExtentReportService implements ReportService {

    public static ExtentReports extentReport;
    public static ExtentTest extentTest;
    private ScreenshotManager screenshotManager;

    @Override
    public void reportSuccess(String message) {
        System.out.println("Test pass!..." + message);
        if (extentReport != null) {
            extentTest.log(LogStatus.PASS, message);

        }
    }

    @Override
    public void reportFailure(String message, Throwable throwable) {

        if (extentReport != null) {
            extentTest.log(LogStatus.PASS, message + addScreenCapture(screenshotManager.getFullScreenshot()) + throwable.getMessage());
        }
    }

    @Override
    public void reportInfo(String message) {
        if (extentReport != null) {
            extentTest.log(LogStatus.INFO, message);
        }

    }

    @Override
    public void configureResultReport(String scenarioName, HealthlinkSelenium healthlinkSelenium) {
        if (extentReport == null) {
            extentReport = new ExtentReports("detailResultReport.html");
            URL url = healthlinkSelenium.getClass().getResource("extent-config.xml");
            extentReport.loadConfig(new File(url.getPath()));
        }
        if (extentReport != null) {
            extentTest = extentReport.startTest(scenarioName);
        }
    }

    @Override
    public void endResultReport() {
        if (extentReport != null) {
            extentReport.endTest(extentTest);
            extentReport.flush();
        }

    }

    @Override
    public String addScreenCapture(String fullScreenshot) {
        return extentTest.addScreenCapture(fullScreenshot);
    }
}
