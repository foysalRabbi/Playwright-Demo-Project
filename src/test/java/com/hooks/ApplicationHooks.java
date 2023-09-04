package com.hooks;

import com.microsoft.playwright.Page;
import com.qa.managers.DriverFactory;
import com.qa.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Properties;


public class ApplicationHooks {
    private Page page;
    Properties props;

    @Before(order = 0)
    public void getProperty() {
        ConfigReader configReader = new ConfigReader();
        props = configReader.browserInitialization();
    }

    @Before(order = 1)
    public void lunchBrowser() {
        DriverFactory driverFactory = new DriverFactory();
        page = driverFactory.initBrowser(props);
    }

    @After(order = 0)
    public void tearDown() {
        page.close();
    }

    @After(order = 1)
    public void takeFailedScreenshot(Scenario sc) {
        if (sc.isFailed()) {
            String screenshotName = sc.getName().replaceAll("", "");
            byte[] sourcePath = page.screenshot();
            sc.attach(sourcePath, "image/png", screenshotName);
        }
    }


}
