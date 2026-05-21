package com.app.user.ui.hooks;

import com.app.user.ui.core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp() {
        DriverFactory.initializeDriver();
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = DriverFactory.takeScreenshot(scenario.getName());
            logger.info("Screenshot saved: " + screenshotPath);
        }
        DriverFactory.quitDriver();
    }
}