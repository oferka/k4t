package org.karp.k4t.data.content.provider;

import org.apache.commons.lang3.RandomUtils;
import org.karp.k4t.model.User;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Service
public class UserDateOfRegistrationProvider {

    public ZonedDateTime get(@NotNull User user) {
        long daysAgo = RandomUtils.nextLong(3, 1000);
        return ZonedDateTime.now().minusDays(daysAgo);
    }
}
