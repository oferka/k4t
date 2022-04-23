package org.karp.k4t.service;

import org.junit.jupiter.api.Test;
import org.karp.k4t.model.User;
import org.karp.k4t.model.UserTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.karp.k4t.TestDataUtils.NONE_EXISTING_NAME;
import static org.karp.k4t.TestDataUtils.getNonExistingId;

class UserServiceTest extends UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldFindAll() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> savedItems = userRepository.saveAll(items);
        List<User> foundItems = userService.findAll();
        assertNotNull(foundItems);
        userRepository.deleteAll(savedItems);
    }

    @Test
    public void shouldFindById() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        Long id = items.get(0).getId();
        Optional<User> found = userService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotFindById() {
        Optional<User> found = userService.findById(getNonExistingId());
        assertTrue(found.isEmpty());
    }

    @Test
    public void shouldFindByFirstName() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        String firstName = items.get(0).getFirstName();
        List<User> found = userService.findByFirstName(firstName);
        assertFalse(found.isEmpty());
        assertEquals(firstName, found.get(0).getFirstName());
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotFindByFirstName() {
        List<User> found = userService.findByFirstName(NONE_EXISTING_NAME);
        assertTrue(found.isEmpty());
    }

    @Test
    public void shouldFindByLastName() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        String lastName = items.get(0).getLastName();
        List<User> found = userService.findByLastName(lastName);
        assertFalse(found.isEmpty());
        assertEquals(lastName, found.get(0).getLastName());
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotFindByLastName() {
        List<User> found = userService.findByLastName(NONE_EXISTING_NAME);
        assertTrue(found.isEmpty());
    }

    @Test
    public void shouldFindRandom() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        Optional<User> found = userService.findRandom();
        assertTrue(found.isPresent());
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldFindRandomId() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        Optional<Long> found = userService.findRandomId();
        assertTrue(found.isPresent());
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldSave() {
        User item = userContentProvider.get();
        User saved = userService.save(item);
        assertEquals(saved, item);
        userRepository.delete(item);
    }

    @Test
    public void shouldSaveAll() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userService.saveAll(items);
        assertNotNull(saved);
        userRepository.deleteAll(items);
    }

    @Test
    public void shouldUpdate() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        User item = items.get(0);
        Optional<User> updated = userService.update(item);
        assertTrue(updated.isPresent());
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotUpdate() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        User item = createUserWithNonExistingId(items.get(0));
        Optional<User> updated = userService.update(item);
        assertTrue(updated.isEmpty());
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldDelete() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        User item = items.get(0);
        Optional<User> deleted = userService.delete(item);
        assertTrue(deleted.isPresent());
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotDelete() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        User item = createUserWithNonExistingId(items.get(0));
        Optional<User> deleted = userService.delete(item);
        assertTrue(deleted.isEmpty());
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldDeleteById() {
        User item = userContentProvider.get();
        User saved = userRepository.save(item);
        Long id = saved.getId();
        Optional<User> deleted = userService.deleteById(id);
        assertTrue(deleted.isPresent());
        boolean exists = userRepository.existsById(id);
        assertFalse(exists);
    }

    @Test
    public void shouldNotDeleteById() {
        Optional<User> deleted = userService.deleteById(getNonExistingId());
        assertTrue(deleted.isEmpty());
    }

    @Test
    void shouldCount() {
        long countBefore = userRepository.count();
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        long countAfter = userService.count();
        assertEquals(countBefore + getNumberOfItemsToLoad(), countAfter);
        userRepository.deleteAll(saved);
    }
}