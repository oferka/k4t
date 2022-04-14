package org.karp.k4t.data.content.provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Profile("random-user-content-provider")
public class RandomUserContentProvider implements UserContentProvider {

    private final UserFirstNameProvider userFirstNameProvider;
    private final UserLastNameProvider userLastNameProvider;
    private final UserThumbnailPictureProvider thumbnailPictureProvider;

    @Override
    public @NotNull User get() {
        return getUser();
    }

    @Override
    public List<User> get(int numberOfItems) {
        List<User> result =  new ArrayList<>();
        for(int i=0; i<numberOfItems; i++) {
            result.add(getUser());
        }
        log.info("{} users provided", result.size());
        return result;
    }

    private @NotNull User getUser() {
        return new User(
                userFirstNameProvider.get(),
                userLastNameProvider.get(),
                thumbnailPictureProvider.get()
        );
    }
}
