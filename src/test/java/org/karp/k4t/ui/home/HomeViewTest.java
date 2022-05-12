package org.karp.k4t.ui.home;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.karp.k4t.Application;
import org.karp.k4t.ui.ViewTest;
import org.karp.k4t.ui.automation.runner.browser.Browser;
import org.karp.k4t.ui.automation.runner.browser.BrowserProvider;
import org.karp.k4t.ui.automation.runner.destination.DestinationProvider;
import org.karp.k4t.ui.automation.runner.driver.WebDriverProvider;
import org.karp.k4t.ui.automation.runner.views.home.HomeViewRetriever;
import org.karp.k4t.ui.automation.runner.views.home.HomeViewStatusMarker;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

import static org.karp.k4t.ui.automation.runner.element.status.ElementStatus.*;

@Slf4j
@SpringBootTest(classes = Application.class)
public class HomeViewTest extends ViewTest {

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider webDriverProvider;

    @Autowired
    private DestinationProvider destinationProvider;

    @Autowired
    private HomeViewRetriever homeViewRetriever;

    @Autowired
    private HomeViewStatusMarker homeViewStatusMarker;

    @Test
    public void shouldLoadWhenAccessedDirectly() {
        WebDriver driver = loadView();
        driver.quit();
    }

    @Test
    public void shouldDisplayInitialContent() {
        WebDriver driver = loadView();
        homeViewStatusMarker.mark(driver, READY);
        homeViewStatusMarker.mark(driver, IN_PROGRESS);
        homeViewStatusMarker.mark(driver, PASSED);
        homeViewStatusMarker.mark(driver, FAILED);
        homeViewStatusMarker.mark(driver, TIMED_OUT);
        homeViewStatusMarker.mark(driver, NO_CONTENT);
        driver.quit();
    }

    private WebDriver loadView() {
        log.info("Load home view started");
        Browser browser = browserProvider.get();
        WebDriver driver = webDriverProvider.get(browser);
        URI homeViewUri = destinationProvider.getHomeView();
        driver.get(homeViewUri.toString());
        homeViewRetriever.get(driver, 30);
        log.info("Load home view completed");
        return driver;
    }
}
