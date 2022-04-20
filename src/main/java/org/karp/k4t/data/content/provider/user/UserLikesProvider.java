package org.karp.k4t.data.content.provider.user;

import org.apache.commons.lang3.RandomUtils;
import org.karp.k4t.model.User;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Service
public class UserLikesProvider {

    public @PositiveOrZero long get(@NotNull User user) {
        return RandomUtils.nextLong(0, 100000);
    }
}
