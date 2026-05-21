package com.app.user.ui.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DriverFactory {
    private static WebDriver driver;
    private static final String SCREENSHOT_PATH = "target/screenshots/";

    public static void initializeDriver() {
        // Load configuration
        String browser = TestConfig.getBrowser();
        boolean headless = TestConfig.isHeadless();

        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(headless);
            driver = new ChromeDriver(options);
        } else if ("edge".equalsIgnoreCase(browser)) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.setHeadless(headless);
            driver = new EdgeDriver(options);
        }
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String takeScreenshot(String scenarioName) {
        String path = SCREENSHOT_PATH + scenarioName + "_" + System.currentTimeMillis() + ".png";
        // Add screenshot taking logic here
        return path;
    }
}