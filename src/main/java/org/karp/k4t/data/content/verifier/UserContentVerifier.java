package org.karp.k4t.data.content.verifier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.model.User;
import org.karp.k4t.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserContentVerifier {

    private final UserService userService;

    public Iterable<User> findLoaded(Iterable<User> users) {
        List<User> result = new ArrayList<>();
        for(User user : users) {
            if(userService.exists(user)) {
                result.add(user);
            }
        }
        log.info("{} users found as loaded", result.size());
        return result;
    }

    public Iterable<User> findNotLoaded(Iterable<User> users) {
        List<User> result = new ArrayList<>();
        for(User user : users) {
            if(!userService.exists(user)) {
                result.add(user);
            }
        }
        log.info("{} users found as unloaded", result.size());
        return result;
    }
}
