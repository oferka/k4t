package org.karp.k4t.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.karp.k4t.model.User;
import org.karp.k4t.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public @NotNull List<User> findAll() {
        Iterable<User> items = userRepository.findAll();
        return StreamSupport
                .stream(items.spliterator(), false)
                .collect(Collectors.toList());
    }

    public @NotNull Optional<User> findById(@NotNull Long id) {
        return userRepository.findById(id);
    }

    public @NotNull List<User> findByFirstName(@NotNull String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public @NotNull List<User> findByLastName(@NotNull String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public Optional<User> findRandom() {
        List<User> items = findAll();
        if(items.isEmpty()) {
            return Optional.empty();
        }
        User item = items.get(RandomUtils.nextInt(0, items.size()));
        return Optional.of(item);
    }

    public Optional<Long> findRandomId() {
        List<User> items = findAll();
        if(items.isEmpty()) {
            return Optional.empty();
        }
        User item = items.get(RandomUtils.nextInt(0, items.size()));
        return Optional.of(item.getId());
    }

    public @NotNull User save(@NotNull User user) {
        return userRepository.save(user);
    }

    public @NotNull Iterable<User> saveAll(@NotNull Iterable<User> users) {
        return userRepository.saveAll(users);
    }

    public Optional<User> update(@NotNull User user) {
        Optional<User> result = Optional.empty();
        if(existsById(user.getId())) {
            result = Optional.of(save(user));
        }
        return result;
    }

    public Optional<User> delete(@NotNull User user) {
        return deleteById(user.getId());
    }

    public Optional<User> deleteById(@NotNull Long id) {
        Optional<User> item = findById(id);
        item.ifPresent(user -> userRepository.deleteById(user.getId()));
        return item;
    }

    public long count() {
        return userRepository.count();
    }

    public boolean existsById(@NotNull Long id) {
        return userRepository.existsById(id);
    }

    public boolean exists(@NotNull User user) {
        return userRepository.existsByFirstNameAndLastName(
                user.getFirstName(),
                user.getLastName()
        );
    }
}
