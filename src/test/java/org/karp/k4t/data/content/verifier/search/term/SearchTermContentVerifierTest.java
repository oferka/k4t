package org.karp.k4t.data.content.verifier.search.term;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.model.SearchTermTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTermContentVerifierTest extends SearchTermTest {

    @Autowired
    private SearchTermContentVerifier searchTermContentVerifier;

    @Test
    void shouldFindLoaded() {
        List<SearchTerm> items = searchTermRepository.findAll();
        Iterable<SearchTerm> loaded = searchTermContentVerifier.findLoaded(items);
        assertEquals(IterableUtils.toList(loaded), items);
    }

    @Test
    void shouldFindNotLoaded() {
        List<SearchTerm> items = searchTermContentProvider.get(5);
        Iterable<SearchTerm> notLoaded = searchTermContentVerifier.findNotLoaded(items);
        Assertions.assertFalse(IterableUtils.toList(notLoaded).isEmpty());
    }
}