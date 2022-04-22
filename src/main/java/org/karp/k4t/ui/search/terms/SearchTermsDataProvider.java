package org.karp.k4t.ui.search.terms;

import org.karp.k4t.model.SearchTerm;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface SearchTermsDataProvider {

    long count();

    @NotNull List<SearchTerm> findAll();

    @NotNull Optional<SearchTerm> findById(@NotNull Long id);

    @NotNull List<SearchTerm> findByText(@NotNull String text);

    @NotNull SearchTerm save(@NotNull SearchTerm searchTerm);
}
