package org.karp.k4t.ui.search.terms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.karp.k4t.model.SearchTerm;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTermChangeEvent {

    private Optional<SearchTerm> oldSearchTerm;

    private Optional<SearchTerm> newSearchTerm;
}
