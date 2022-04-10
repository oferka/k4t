package org.karp.k4t.ui.users;

import lombok.RequiredArgsConstructor;
import org.karp.k4t.model.User;
import org.karp.k4t.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Profile({"users-service-data-provider", "default"})
public class UsersServiceDataProvider implements UsersDataProvider {

    private final UserService userService;

    @Override
    public long count() {
        return userService.count();
    }

    @Override
    public List<User> getItems() {
        return userService.findAll();
    }
}
