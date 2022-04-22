package org.karp.k4t.ui.search.terms;

import org.karp.k4t.model.SearchTerm;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
@Profile({"search-terms-mock-data-provider"})
public class SearchTermsMockDataProvider implements SearchTermsDataProvider {
    @Override
    public long count() {
        return 50;
    }

    @Override
    public List<SearchTerm> findAll() {
        return emptyList();
    }

    @Override
    public Optional<SearchTerm> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<SearchTerm> findByText(String text) {
        return emptyList();
    }

    @Override
    public SearchTerm save(SearchTerm searchTerm) {
        return null;
    }
}
