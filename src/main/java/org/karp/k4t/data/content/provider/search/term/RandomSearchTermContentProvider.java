package org.karp.k4t.data.content.provider.search.term;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.model.SearchTerm;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Profile("random-search-term-content-provider")
public class RandomSearchTermContentProvider implements SearchTermContentProvider {

    private final SearchTermTextProvider searchTermTextProvider;

    @Override
    public @NotNull SearchTerm get() {
        return getSearchTerm();
    }

    @Override
    public List<SearchTerm> get(int numberOfItems) {
        List<SearchTerm> result =  new ArrayList<>();
        for(int i=0; i<numberOfItems; i++) {
            result.add(getSearchTerm());
        }
        log.info("{} search terms provided", result.size());
        return result;
    }

    private @NotNull SearchTerm getSearchTerm() {
        SearchTerm searchTerm = new SearchTerm();
        searchTerm.setText(searchTermTextProvider.get(searchTerm));
        return searchTerm;
    }
}
