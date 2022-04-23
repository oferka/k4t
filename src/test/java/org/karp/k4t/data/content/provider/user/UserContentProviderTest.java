package org.karp.k4t.data.content.provider.user;

import org.junit.jupiter.api.Test;
import org.karp.k4t.model.User;
import org.karp.k4t.model.UserTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserContentProviderTest extends UserTest {

    @Test
    void shouldGetItem() {
        User item = userContentProvider.get();
        assertNotNull(item);
    }

    @Test
    void shouldGetItems() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        assertNotNull(items);
        assertEquals(getNumberOfItemsToLoad(), items.size());
    }
}