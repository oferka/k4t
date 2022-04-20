package org.karp.k4t.data.content.health.search.term;

import lombok.RequiredArgsConstructor;
import org.karp.k4t.service.SearchTermService;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("searchTermContent")
@RequiredArgsConstructor
@ConditionalOnEnabledHealthIndicator("searchTermContent")
public class SearchTermContentHealthIndicator implements HealthIndicator {

    private final SearchTermService searchTermService;

    @Override
    public Health health() {
        Health.Builder status;
        try {
            long count = searchTermService.count();
            status = (count > 0)?Health.up():Health.down();
            status.withDetail("number_of_search_terms", count);
        }
        catch (Exception e) {
            status = Health.down(e);
        }
        return status.build();
    }
}
