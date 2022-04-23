package org.karp.k4t.data.content.verifier.user;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.karp.k4t.model.User;
import org.karp.k4t.model.UserTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserContentVerifierTest extends UserTest {

    @Autowired
    private UserContentVerifier userContentVerifier;

    @Test
    void shouldFindLoaded() {
        List<User> items = userRepository.findAll();
        Iterable<User> loaded = userContentVerifier.findLoaded(items);
        assertEquals(IterableUtils.toList(loaded), items);
    }

    @Test
    void shouldFindNotLoaded() {
        List<User> items = userContentProvider.get(5);
        Iterable<User> notLoaded = userContentVerifier.findNotLoaded(items);
        Assertions.assertFalse(IterableUtils.toList(notLoaded).isEmpty());
    }
}