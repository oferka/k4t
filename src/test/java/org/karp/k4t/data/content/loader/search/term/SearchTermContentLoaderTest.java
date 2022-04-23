package org.karp.k4t.data.content.loader.search.term;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.model.SearchTermTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SearchTermContentLoaderTest extends SearchTermTest {

    @Autowired
    private SearchTermContentLoader searchTermContentLoader;

    @Test
    void shouldEnsureContentLoaded() {
        Iterable<SearchTerm> loaded = searchTermContentLoader.ensureContentLoaded();
        assertFalse(IterableUtils.toList(loaded).isEmpty());
        searchTermRepository.deleteAll(loaded);
    }
}