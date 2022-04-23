package org.karp.k4t.data.content.health.user;

import org.junit.jupiter.api.Test;
import org.karp.k4t.model.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserContentHealthIndicatorTest extends UserTest {

    @Autowired
    private UserContentHealthIndicator userContentHealthIndicator;

    @Test
    void shouldBeHealthy() {
        Health health = userContentHealthIndicator.health();
        Status status = health.getStatus();
        assertEquals(Status.UP, status);
    }
}