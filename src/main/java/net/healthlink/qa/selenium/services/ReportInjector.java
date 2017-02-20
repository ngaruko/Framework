package net.healthlink.qa.selenium.services;

import com.google.inject.AbstractModule;

/**
 * Created by beden on 20-Feb-17.
 */
public class ReportInjector extends AbstractModule {
    @Override
    protected void configure() {
        bind(ReportService.class).to(ExtentReportService.class);

    }
}
