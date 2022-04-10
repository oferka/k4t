package org.karp.k4t.data.content.health;

import lombok.RequiredArgsConstructor;
import org.karp.k4t.service.UserService;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("userContent")
@RequiredArgsConstructor
@ConditionalOnEnabledHealthIndicator("userContent")
public class UserContentHealthIndicator implements HealthIndicator {

    private final UserService userService;

    @Override
    public Health health() {
        Health.Builder status;
        try {
            long count = userService.count();
            status = (count > 0)?Health.up():Health.down();
            status.withDetail("number_of_users", count);
        }
        catch (Exception e) {
            status = Health.down(e);
        }
        return status.build();
    }
}
