package org.karp.k4t.ui;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.karp.k4t.Application;
import org.karp.k4t.ui.automation.runner.browser.Browser;
import org.karp.k4t.ui.automation.runner.browser.BrowserProvider;
import org.karp.k4t.ui.automation.runner.driver.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
public abstract class ViewTest {

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider webDriverProvider;

    protected ApplicationContext applicationContext;

    protected WebDriver driver;

    @BeforeEach
    public void ensureApplicationRunning() {
        log.info("Ensure application running started");
        if(isApplicationRunning()) {
            log.info("Application is already running");
        }
        else {
            log.info("Application is not running. Going to start it");
            startApplication();
        }
        log.info("Ensure application running completed");
    }

    @BeforeEach
    public void initiateWebDriver() {
        log.info("Initiate web driver started");
        driver = getWebDriver();
        log.info("Initiate web driver completed");
    }

    @Test
    public void shouldLoadView() {
        log.info("View loaded successfully");
    }

    @AfterEach
    public void cleanupWebDriver() {
        log.info("Cleanup web driver started");
        driver.quit();
        log.info("Cleanup web driver completed");
    }

    private boolean isApplicationRunning() {
        return true;
    }

    private void startApplication() {
        log.info("Start application started");
        applicationContext = SpringApplication.run(Application.class);
        log.info("Start application completed. Application ID is: {}", applicationContext.getId());
    }

    private void stopApplication() {
        log.info("Stop application started");
        int exitCode = SpringApplication.exit(applicationContext);
        log.info("Stop application completed. Exit code is: {}", exitCode);
    }

    private WebDriver getWebDriver() {
        log.info("Get driver started");
        Browser browser = browserProvider.get();
        WebDriver driver = webDriverProvider.get(browser);
        log.info("Get driver completed");
        return driver;
    }
}
