package org.karp.k4t.data.content.provider.user;

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
    private final UserDateOfRegistrationProvider userDateOfRegistrationProvider;
    private final UserSummaryProvider userSummaryProvider;
    private final UserLikesProvider userLikesProvider;
    private final UserCommentsProvider userCommentsProvider;
    private final UserSharesProvider userSharesProvider;

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
        User user = new User();
        user.setFirstName(userFirstNameProvider.get(user));
        user.setLastName(userLastNameProvider.get(user));
        user.setThumbnailPicture(thumbnailPictureProvider.get(user));
        user.setDateOfRegistration(userDateOfRegistrationProvider.get(user));
        user.setSummary(userSummaryProvider.get(user));
        user.setLikes(userLikesProvider.get(user));
        user.setComments(userCommentsProvider.get(user));
        user.setShares(userSharesProvider.get(user));
        return user;
    }
}
