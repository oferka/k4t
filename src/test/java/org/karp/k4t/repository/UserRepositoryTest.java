package org.karp.k4t.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.karp.k4t.model.User;
import org.karp.k4t.model.UserTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.karp.k4t.TestDataUtils.NONE_EXISTING_NAME;
import static org.karp.k4t.TestDataUtils.getNonExistingId;

class UserRepositoryTest extends UserTest {

    @Test
    void shouldSaveItem() {
        User item = userContentProvider.get();
        User saved = userRepository.save(item);
        assertEquals(item, saved);
        userRepository.delete(saved);
    }

    @Test
    void shouldSaveItems() {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        assertNotNull(saved);
        userRepository.deleteAll(saved);
    }

    @Test
    void shouldFindItemById() {
        User item = userContentProvider.get();
        User saved = userRepository.save(item);
        Optional<User> foundItemOptional = userRepository.findById(item.getId());
        Assertions.assertTrue(foundItemOptional.isPresent());
        User foundItem = foundItemOptional.get();
        assertEquals(item.getId(), foundItem.getId());
        userRepository.delete(saved);
    }

    @Test
    void shouldNotFindItemById() {
        Optional<User> foundItemOptional = userRepository.findById(getNonExistingId());
        Assertions.assertTrue(foundItemOptional.isEmpty());
    }

    @Test
    void shouldFindItemByFirstName() {
        User item = userContentProvider.get();
        User saved = userRepository.save(item);
        List<User> foundItems = userRepository.findByFirstName(item.getFirstName());
        assertFalse(foundItems.isEmpty());
        User foundItem = foundItems.get(0);
        assertEquals(item.getFirstName(), foundItem.getFirstName());
        userRepository.delete(saved);
    }

    @Test
    void shouldNotFindItemByFirstName() {
        List<User> foundItems = userRepository.findByFirstName(NONE_EXISTING_NAME);
        assertTrue(foundItems.isEmpty());
    }

    @Test
    void shouldFindItemByLastName() {
        User item = userContentProvider.get();
        User saved = userRepository.save(item);
        List<User> foundItems = userRepository.findByLastName(item.getLastName());
        assertFalse(foundItems.isEmpty());
        User foundItem = foundItems.get(0);
        assertEquals(item.getLastName(), foundItem.getLastName());
        userRepository.delete(saved);
    }

    @Test
    void shouldNotFindItemByLastName() {
        List<User> foundItems = userRepository.findByLastName(NONE_EXISTING_NAME);
        assertTrue(foundItems.isEmpty());
    }


    @Test
    void shouldExistById() {
        User item = userContentProvider.get();
        User saved = userRepository.save(item);
        boolean exists = userRepository.existsById(saved.getId());
        assertTrue(exists);
        userRepository.delete(saved);
    }

    @Test
    void shouldNotExistById() {
        boolean exists = userRepository.existsById(getNonExistingId());
        assertFalse(exists);
    }

    @Test
    void shouldExistByFirstNameAndLstName() {
        User item = userContentProvider.get();
        User saved = userRepository.save(item);
        boolean exists = userRepository.existsByFirstNameAndLastName(saved.getFirstName(), saved.getLastName());
        assertTrue(exists);
        userRepository.delete(saved);
    }

    @Test
    void shouldNotExistByFirstNameAndLstName() {
        boolean exists = userRepository.existsByFirstNameAndLastName(NONE_EXISTING_NAME, NONE_EXISTING_NAME);
        assertFalse(exists);
    }

    @Test
    void shouldCount() {
        long countBefore = userRepository.count();
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        long countAfter = userRepository.count();
        assertEquals(countAfter, countBefore + getNumberOfItemsToLoad());
        userRepository.deleteAll(saved);
    }

    @Test
    void shouldDeleteItem() {
        User item = userContentProvider.get();
        User saved = userRepository.save(item);
        userRepository.delete(item);
        boolean exists = userRepository.existsById(saved.getId());
        assertFalse(exists);
    }

    @Test
    void shouldDeleteById() {
        User item = userContentProvider.get();
        User saved = userRepository.save(item);
        userRepository.deleteById(item.getId());
        boolean exists = userRepository.existsById(saved.getId());
        assertFalse(exists);
    }

    @Test
    void shouldNotDeleteById() {
        EmptyResultDataAccessException exception = Assertions.assertThrows(EmptyResultDataAccessException.class, () -> userRepository.deleteById(getNonExistingId()));
        Assertions.assertTrue(Objects.requireNonNull(exception.getMessage()).contains("entity with id"));
    }

    @Test
    void shouldDeleteItems() {
        long countBefore = userRepository.count();
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        int numberOfItemsToDelete = 3;
        userRepository.deleteAll(items.subList(0, numberOfItemsToDelete));
        long countAfter = userRepository.count();
        assertEquals((countBefore + getNumberOfItemsToLoad() - numberOfItemsToDelete), countAfter);
        userRepository.deleteAll(saved);
    }
}