package org.karp.k4t.data.content.health.search.term;

import org.junit.jupiter.api.Test;
import org.karp.k4t.model.SearchTermTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTermContentHealthIndicatorTest extends SearchTermTest {

    @Autowired
    private SearchTermContentHealthIndicator searchTermContentHealthIndicator;

    @Test
    void shouldBeHealthy() {
        Health health = searchTermContentHealthIndicator.health();
        Status status = health.getStatus();
        assertEquals(Status.UP, status);
    }
}