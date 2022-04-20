package org.karp.k4t.data.content.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.karp.k4t.data.content.loader.search.term.SearchTermContentLoader;
import org.karp.k4t.data.content.loader.user.UserContentLoader;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.model.User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContentLoader {

    private final UserContentLoader userContentLoader;
    private final SearchTermContentLoader searchTermContentLoader;

    public void ensureContentLoaded() {
        Iterable<User> users = userContentLoader.ensureContentLoaded();
        Iterable<SearchTerm> searchTerms = searchTermContentLoader.ensureContentLoaded();
        log.info("{} entities ensured loaded", IterableUtils.size(users) + IterableUtils.size(searchTerms));
    }
}
