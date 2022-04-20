package org.karp.k4t.data.content.provider.search.term;

import org.karp.k4t.model.SearchTerm;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface SearchTermContentProvider {

    @NotNull SearchTerm get();

    @NotNull List<SearchTerm> get(int numberOfItems);
}
