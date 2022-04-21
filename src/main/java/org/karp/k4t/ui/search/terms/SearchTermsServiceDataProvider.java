package org.karp.k4t.ui.search.terms;

import lombok.RequiredArgsConstructor;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.service.SearchTermService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Profile({"search-terms-service-data-provider", "default"})
public class SearchTermsServiceDataProvider implements SearchTermsDataProvider {

    private final SearchTermService searchTermService;

    @Override
    public long count() {
        return searchTermService.count();
    }

    @Override
    public @NotNull List<SearchTerm> findAll() {
        return searchTermService.findAll();
    }

    @Override
    public @NotNull Optional<SearchTerm> findById(@NotNull Long id) {
        return searchTermService.findById(id);
    }

    @Override
    public @NotNull List<SearchTerm> findByText(@NotNull String text) {
        return searchTermService.findByText(text);
    }
}
