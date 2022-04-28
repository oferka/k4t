package org.karp.k4t.ui.feed;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.karp.k4t.Application;
import org.karp.k4t.ui.automation.runner.browser.Browser;
import org.karp.k4t.ui.automation.runner.browser.BrowserProvider;
import org.karp.k4t.ui.automation.runner.destination.DestinationProvider;
import org.karp.k4t.ui.automation.runner.driver.WebDriverProvider;
import org.karp.k4t.ui.automation.runner.views.feed.FeedViewRetriever;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.net.URI;

@Slf4j
@SpringBootTest(classes = Application.class)
class FeedViewTest {

    private ApplicationContext applicationContext;

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider driverFactory;

    @Autowired
    private DestinationProvider destinationProvider;

    @Autowired
    private FeedViewRetriever feedViewRetriever;

    @BeforeEach
    public void startApplication() {
        log.info("Start application started");
        applicationContext = SpringApplication.run(Application.class);
        log.info("Start application completed. Application ID is: {}", applicationContext.getId());
    }

    @Test
    public void shouldLoadWhenAccessedDirectly() {
        Browser browser = browserProvider.get();
        WebDriver driver = driverFactory.get(browser);
        URI feedViewUri = destinationProvider.getFeedView();
        driver.get(feedViewUri.toString());
        feedViewRetriever.get(driver, 20);
        driver.quit();
    }

    @Test
    public void shouldDisplayInitialContent() {
        Browser browser = browserProvider.get();
        WebDriver driver = driverFactory.get(browser);
        URI feedViewUri = destinationProvider.getFeedView();
        driver.get(feedViewUri.toString());
        feedViewRetriever.get(driver, 20);
        driver.quit();
    }

    @AfterEach
    public void stopApplication() {
        log.info("Stop application started");
        int exitCode = SpringApplication.exit(applicationContext);
        log.info("Stop application completed. Exit code is: {}", exitCode);
    }
}