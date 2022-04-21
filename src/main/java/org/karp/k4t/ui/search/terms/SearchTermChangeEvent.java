package org.karp.k4t.ui.search.terms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTermChangeEvent {

    private Optional<String> oldSearchTermText;

    private Optional<String> newSearchTermText;
}
