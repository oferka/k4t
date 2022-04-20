package org.karp.k4t.data.content.verifier.search.term;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.service.SearchTermService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchTermContentVerifier {

    private final SearchTermService searchTermService;

    public Iterable<SearchTerm> findLoaded(Iterable<SearchTerm> searchTerms) {
        List<SearchTerm> result = new ArrayList<>();
        for(SearchTerm searchTerm : searchTerms) {
            if(searchTermService.exists(searchTerm)) {
                result.add(searchTerm);
            }
        }
        log.info("{} search terms found as loaded", result.size());
        return result;
    }

    public Iterable<SearchTerm> findNotLoaded(Iterable<SearchTerm> searchTerms) {
        List<SearchTerm> result = new ArrayList<>();
        for(SearchTerm searchTerm : searchTerms) {
            if(!searchTermService.exists(searchTerm)) {
                result.add(searchTerm);
            }
        }
        log.info("{} search terms found as unloaded", result.size());
        return result;
    }
}
