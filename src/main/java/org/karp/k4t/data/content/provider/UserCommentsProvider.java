package org.karp.k4t.data.content.provider;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.PositiveOrZero;

@Service
public class UserCommentsProvider {

    public @PositiveOrZero long get() {
        return RandomUtils.nextLong(0, 100000);
    }
}
