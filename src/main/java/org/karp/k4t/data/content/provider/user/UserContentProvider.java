package org.karp.k4t.data.content.provider.user;

import org.karp.k4t.model.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserContentProvider {

    @NotNull User get();

    @NotNull List<User> get(int numberOfItems);
}
