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
import org.karp.k4t.ui.automation.runner.element.status.ElementStatus;
import org.karp.k4t.ui.automation.runner.views.feed.FeedViewRetriever;
import org.karp.k4t.ui.automation.runner.views.feed.FeedViewStatusMarker;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.net.URI;

import static org.karp.k4t.ui.automation.runner.element.status.ElementStatus.*;

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

    @Autowired
    private FeedViewStatusMarker feedViewStatusMarker;

    @BeforeEach
    public void startApplication() {
        log.info("Start application started");
        applicationContext = SpringApplication.run(Application.class);
        log.info("Start application completed. Application ID is: {}", applicationContext.getId());
    }

    @Test
    public void shouldLoadWhenAccessedDirectly() {
        WebDriver driver = loadView();
        driver.quit();
    }

    @Test
    public void shouldDisplayInitialContent() {
        WebDriver driver = loadView();
        feedViewStatusMarker.mark(driver, READY);
        feedViewStatusMarker.mark(driver, IN_PROGRESS);
        feedViewStatusMarker.mark(driver, PASSED);
        driver.quit();
    }

    private WebDriver loadView() {
        log.info("Load feed view started");
        Browser browser = browserProvider.get();
        WebDriver driver = driverFactory.get(browser);
        URI feedViewUri = destinationProvider.getFeedView();
        driver.get(feedViewUri.toString());
        feedViewRetriever.get(driver, 30);
        log.info("Load feed view completed");
        return driver;
    }

    @AfterEach
    public void stopApplication() {
        log.info("Stop application started");
        int exitCode = SpringApplication.exit(applicationContext);
        log.info("Stop application completed. Exit code is: {}", exitCode);
    }
}