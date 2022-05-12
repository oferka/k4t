package org.karp.k4t.ui.feed;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.karp.k4t.Application;
import org.karp.k4t.ui.ViewTest;
import org.karp.k4t.ui.automation.runner.destination.DestinationProvider;
import org.karp.k4t.ui.automation.runner.views.feed.FeedViewRetriever;
import org.karp.k4t.ui.automation.runner.views.feed.FeedViewStatusMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

import static org.karp.k4t.ui.automation.runner.element.status.ElementStatus.*;

@Slf4j
@SpringBootTest(classes = Application.class)
class FeedViewTest extends ViewTest {

    @Autowired
    private DestinationProvider destinationProvider;

    @Autowired
    private FeedViewRetriever feedViewRetriever;

    @Autowired
    private FeedViewStatusMarker feedViewStatusMarker;

    @Test
    public void shouldLoadWhenAccessedDirectly() {
        loadView();
    }

    @Test
    public void shouldDisplayInitialContent() {
        loadView();
        feedViewStatusMarker.mark(driver, READY);
        feedViewStatusMarker.mark(driver, IN_PROGRESS);
        feedViewStatusMarker.mark(driver, PASSED);
        feedViewStatusMarker.mark(driver, FAILED);
        feedViewStatusMarker.mark(driver, TIMED_OUT);
        feedViewStatusMarker.mark(driver, NO_CONTENT);
    }

    private void loadView() {
        log.info("Load feed view started");
        URI feedViewUri = destinationProvider.getFeedView();
        driver.get(feedViewUri.toString());
        feedViewRetriever.get(driver, 30);
        log.info("Load feed view completed");
    }
}