package org.karp.k4t.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.model.SearchTermTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.karp.k4t.TestDataUtils.NONE_EXISTING_NAME;
import static org.karp.k4t.TestDataUtils.getNonExistingId;

class SearchTermRepositoryTest extends SearchTermTest {

    @Test
    void shouldSaveItem() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermRepository.save(item);
        assertEquals(item, saved);
        searchTermRepository.delete(saved);
    }

    @Test
    void shouldSaveItems() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        assertNotNull(saved);
        searchTermRepository.deleteAll(saved);
    }

    @Test
    void shouldFindItemById() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermRepository.save(item);
        Optional<SearchTerm> foundItemOptional = searchTermRepository.findById(item.getId());
        Assertions.assertTrue(foundItemOptional.isPresent());
        SearchTerm foundItem = foundItemOptional.get();
        assertEquals(item.getId(), foundItem.getId());
        searchTermRepository.delete(saved);
    }

    @Test
    void shouldNotFindItemById() {
        Optional<SearchTerm> foundItemOptional = searchTermRepository.findById(getNonExistingId());
        Assertions.assertTrue(foundItemOptional.isEmpty());
    }

        @Test
    void shouldFindItemByText() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermRepository.save(item);
        List<SearchTerm> foundItems = searchTermRepository.findByText(item.getText());
        assertFalse(foundItems.isEmpty());
        SearchTerm foundItem = foundItems.get(0);
        assertEquals(item.getText(), foundItem.getText());
        searchTermRepository.delete(saved);
    }

    @Test
    void shouldNotFindItemByText() {
        List<SearchTerm> foundItems = searchTermRepository.findByText(NONE_EXISTING_NAME);
        assertTrue(foundItems.isEmpty());
    }


    @Test
    void shouldExistById() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermRepository.save(item);
        boolean exists = searchTermRepository.existsById(saved.getId());
        assertTrue(exists);
        searchTermRepository.delete(saved);
    }

    @Test
    void shouldNotExistById() {
        boolean exists = searchTermRepository.existsById(getNonExistingId());
        assertFalse(exists);
    }

    @Test
    void shouldExistByText() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermRepository.save(item);
        boolean exists = searchTermRepository.existsByText(saved.getText());
        assertTrue(exists);
        searchTermRepository.delete(saved);
    }

    @Test
    void shouldNotExistByText() {
        boolean exists = searchTermRepository.existsByText(NONE_EXISTING_NAME);
        assertFalse(exists);
    }

    @Test
    void shouldCount() {
        long countBefore = searchTermRepository.count();
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        long countAfter = searchTermRepository.count();
        assertEquals(countAfter, countBefore + getNumberOfItemsToLoad());
        searchTermRepository.deleteAll(saved);
    }

    @Test
    void shouldDeleteItem() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermRepository.save(item);
        searchTermRepository.delete(item);
        boolean exists = searchTermRepository.existsById(saved.getId());
        assertFalse(exists);
    }

    @Test
    void shouldDeleteById() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermRepository.save(item);
        searchTermRepository.deleteById(item.getId());
        boolean exists = searchTermRepository.existsById(saved.getId());
        assertFalse(exists);
    }

    @Test
    void shouldNotDeleteById() {
        EmptyResultDataAccessException exception = Assertions.assertThrows(EmptyResultDataAccessException.class, () -> searchTermRepository.deleteById(getNonExistingId()));
        Assertions.assertTrue(Objects.requireNonNull(exception.getMessage()).contains("entity with id"));
    }

    @Test
    void shouldDeleteItems() {
        long countBefore = searchTermRepository.count();
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        int numberOfItemsToDelete = 3;
        searchTermRepository.deleteAll(items.subList(0, numberOfItemsToDelete));
        long countAfter = searchTermRepository.count();
        assertEquals((countBefore + getNumberOfItemsToLoad() - numberOfItemsToDelete), countAfter);
        searchTermRepository.deleteAll(saved);
    }
}