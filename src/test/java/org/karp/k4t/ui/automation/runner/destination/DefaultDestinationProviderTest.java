package org.karp.k4t.ui.automation.runner.destination;

import org.junit.jupiter.api.Test;
import org.karp.k4t.Application;
import org.karp.k4t.ui.feed.FeedView;
import org.karp.k4t.ui.home.HomeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Application.class)
class DefaultDestinationProviderTest {

    @Autowired
    private DestinationProvider destinationProvider;

    @Test
    public void shouldGetDefaultView() {
        URI uri = destinationProvider.getDefaultView();
        assertNotNull(uri);
    }

    @Test
    public void shouldGetHomeView() {
        URI uri = destinationProvider.getHomeView();
        assertNotNull(uri);
        assertTrue(uri.getPath().contains(HomeView.ROUTE));
    }

    @Test
    public void shouldGetFeedView() {
        URI uri = destinationProvider.getFeedView();
        assertNotNull(uri);
        assertTrue(uri.getPath().contains(FeedView.ROUTE));
    }
}