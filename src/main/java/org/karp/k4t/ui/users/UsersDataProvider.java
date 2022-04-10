package org.karp.k4t.ui.users;

import org.karp.k4t.model.User;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface UsersDataProvider {

    long count();

    @NotNull List<User> findAll();

    @NotNull Optional<User> findById(@NotNull Long id);
}
