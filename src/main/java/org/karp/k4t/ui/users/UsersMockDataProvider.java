package org.karp.k4t.ui.users;

import org.karp.k4t.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
@Profile({"users-mock-data-provider"})
public class UsersMockDataProvider implements UsersDataProvider {

    @Override
    public long count() {
        return 30;
    }

    @Override
    public @NotNull List<User> findAll() {
        return emptyList();
    }

    @Override
    public @NotNull Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
