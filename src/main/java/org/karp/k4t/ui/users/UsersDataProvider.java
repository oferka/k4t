package org.karp.k4t.ui.users;

import org.karp.k4t.model.User;

import java.util.List;

public interface UsersDataProvider {

    long count();

    List<User> getItems();
}
