package org.karp.k4t.data.content.loader.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.karp.k4t.data.content.provider.user.UserContentProvider;
import org.karp.k4t.data.content.verifier.user.UserContentVerifier;
import org.karp.k4t.model.User;
import org.karp.k4t.service.UserService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserContentLoader {

    private final UserContentProvider contentProvider;
    private final UserContentVerifier contentVerifier;
    private final UserService userService;
    private final UserContentProviderConfiguration contentProviderConfiguration;

    public @NotNull Iterable<User> ensureContentLoaded() {
        List<User> content = contentProvider.get(contentProviderConfiguration.getNumberOfItems());
        Iterable<User> unloadedContent = contentVerifier.findNotLoaded(content);
        if(!IterableUtils.isEmpty(unloadedContent)) {
            Iterable<User> saved = userService.saveAll(unloadedContent);
            log.info("{} users saved", IterableUtils.size(saved));
        }
        log.info("{} users ensured loaded", content.size());
        return content;
    }
}
