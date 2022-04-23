package org.karp.k4t.data.content.provider.search.term;

import org.junit.jupiter.api.Test;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.model.SearchTermTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SearchTermContentProviderTest extends SearchTermTest {

    @Test
    void shouldGetItem() {
        SearchTerm item = searchTermContentProvider.get();
        assertNotNull(item);
    }

    @Test
    void shouldGetItems() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        assertNotNull(items);
        assertEquals(getNumberOfItemsToLoad(), items.size());
    }
}