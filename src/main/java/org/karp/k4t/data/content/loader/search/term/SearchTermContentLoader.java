package org.karp.k4t.data.content.loader.search.term;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.karp.k4t.data.content.provider.search.term.SearchTermContentProvider;
import org.karp.k4t.data.content.verifier.search.term.SearchTermContentVerifier;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.service.SearchTermService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchTermContentLoader {

    private final SearchTermContentProvider contentProvider;
    private final SearchTermContentVerifier contentVerifier;
    private final SearchTermService searchTermService;
    private final SearchTermContentProviderConfiguration contentProviderConfiguration;

    public @NotNull Iterable<SearchTerm> ensureContentLoaded() {
        List<SearchTerm> content = contentProvider.get(contentProviderConfiguration.getNumberOfItems());
        Iterable<SearchTerm> unloadedContent = contentVerifier.findNotLoaded(content);
        if(!IterableUtils.isEmpty(unloadedContent)) {
            Iterable<SearchTerm> saved = searchTermService.saveAll(unloadedContent);
            log.info("{} search terms saved", IterableUtils.size(saved));
        }
        log.info("{} search terms ensured loaded", content.size());
        return content;
    }
}
