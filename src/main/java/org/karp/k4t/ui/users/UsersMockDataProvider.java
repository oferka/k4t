package org.karp.k4t.ui.users;

import org.karp.k4t.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
@Profile({"users-mock-data-provider"})
public class UsersMockDataProvider implements UsersDataProvider {

    @Override
    public long count() {
        return 30;
    }

    @Override
    public List<User> getItems() {
        return emptyList();
    }
}
