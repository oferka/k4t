package org.karp.k4t.data.content.loader.user;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.karp.k4t.model.User;
import org.karp.k4t.model.UserTest;
import org.karp.k4t.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;

class UserContentLoaderTest extends UserTest {

    @Autowired
    private UserContentLoader userContentLoader;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldEnsureContentLoaded() {
        Iterable<User> loaded = userContentLoader.ensureContentLoaded();
        assertFalse(IterableUtils.toList(loaded).isEmpty());
        userRepository.deleteAll(loaded);
    }
}