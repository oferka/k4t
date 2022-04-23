package org.karp.k4t.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.karp.k4t.Application;
import org.karp.k4t.data.content.loader.search.term.SearchTermContentProviderConfiguration;
import org.karp.k4t.data.content.provider.search.term.SearchTermContentProvider;
import org.karp.k4t.repository.SearchTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.karp.k4t.TestDataUtils.getNonExistingId;

@SpringBootTest(classes = Application.class)
public abstract class SearchTermTest {

    @Autowired
    protected SearchTermRepository searchTermRepository;

    @Autowired
    protected SearchTermContentProvider searchTermContentProvider;

    @Autowired
    protected SearchTermContentProviderConfiguration searchTermContentProviderConfiguration;

    protected long searchTermContentCountBefore;

    @BeforeEach
    void captureContentStatus() {
        searchTermContentCountBefore = searchTermRepository.count();
    }

    @AfterEach
    void verifyContentStatusNotChanged() {
        long contentCountAfter = searchTermRepository.count();
        assertEquals(searchTermContentCountBefore, contentCountAfter);
    }

    protected int getNumberOfItemsToLoad() {
        return searchTermContentProviderConfiguration.getNumberOfItems();
    }

    protected @NotNull SearchTerm createSearchTermWithNonExistingId(@NotNull SearchTerm searchTerm) {
        return new SearchTerm(
                getNonExistingId(),
                searchTerm.getText()
        );
    }
}
