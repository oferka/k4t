package org.karp.k4t.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.karp.k4t.Application;
import org.karp.k4t.data.content.loader.user.UserContentProviderConfiguration;
import org.karp.k4t.data.content.provider.user.UserContentProvider;
import org.karp.k4t.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.karp.k4t.TestDataUtils.getNonExistingId;

@SpringBootTest(classes = Application.class)
public abstract class UserTest {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected UserContentProvider userContentProvider;

    @Autowired
    protected UserContentProviderConfiguration userContentProviderConfiguration;

    protected long userContentCountBefore;

    @BeforeEach
    void captureContentStatus() {
        userContentCountBefore = userRepository.count();
    }

    @AfterEach
    void verifyContentStatusNotChanged() {
        long contentCountAfter = userRepository.count();
        assertEquals(userContentCountBefore, contentCountAfter);
    }

    protected int getNumberOfItemsToLoad() {
        return userContentProviderConfiguration.getNumberOfItems();
    }

    protected @NotNull User createUserWithNonExistingId(@NotNull User user) {
        return new User(
                getNonExistingId(),
                user.getFirstName(),
                user.getLastName(),
                user.getThumbnailPicture(),
                user.getDateOfRegistration(),
                user.getSummary(),
                user.getLikes(),
                user.getComments(),
                user.getShares()
        );
    }
}
