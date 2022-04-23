package org.karp.k4t.service;

import org.junit.jupiter.api.Test;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.model.SearchTermTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.karp.k4t.TestDataUtils.NONE_EXISTING_NAME;
import static org.karp.k4t.TestDataUtils.getNonExistingId;

class SearchTermServiceTest extends SearchTermTest {

    @Autowired
    private SearchTermService searchTermService;

    @Test
    public void shouldFindAll() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> savedItems = searchTermRepository.saveAll(items);
        List<SearchTerm> foundItems = searchTermService.findAll();
        assertNotNull(foundItems);
        searchTermRepository.deleteAll(savedItems);
    }

    @Test
    public void shouldFindById() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        Long id = items.get(0).getId();
        Optional<SearchTerm> found = searchTermService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
        searchTermRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotFindById() {
        Optional<SearchTerm> found = searchTermService.findById(getNonExistingId());
        assertTrue(found.isEmpty());
    }

    @Test
    public void shouldFindByText() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        String text = items.get(0).getText();
        List<SearchTerm> found = searchTermService.findByText(text);
        assertFalse(found.isEmpty());
        assertEquals(text, found.get(0).getText());
        searchTermRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotFindByText() {
        List<SearchTerm> found = searchTermService.findByText(NONE_EXISTING_NAME);
        assertTrue(found.isEmpty());
    }

    @Test
    public void shouldFindRandom() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        Optional<SearchTerm> found = searchTermService.findRandom();
        assertTrue(found.isPresent());
        searchTermRepository.deleteAll(saved);
    }

    @Test
    public void shouldFindRandomId() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        Optional<Long> found = searchTermService.findRandomId();
        assertTrue(found.isPresent());
        searchTermRepository.deleteAll(saved);
    }

    @Test
    public void shouldSave() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermService.save(item);
        assertEquals(saved, item);
        searchTermRepository.delete(item);
    }

    @Test
    public void shouldSaveAll() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermService.saveAll(items);
        assertNotNull(saved);
        searchTermRepository.deleteAll(items);
    }

    @Test
    public void shouldUpdate() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        SearchTerm item = items.get(0);
        Optional<SearchTerm> updated = searchTermService.update(item);
        assertTrue(updated.isPresent());
        searchTermRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotUpdate() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        SearchTerm item = createSearchTermWithNonExistingId(items.get(0));
        Optional<SearchTerm> updated = searchTermService.update(item);
        assertTrue(updated.isEmpty());
        searchTermRepository.deleteAll(saved);
    }

    @Test
    public void shouldDelete() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        SearchTerm item = items.get(0);
        Optional<SearchTerm> deleted = searchTermService.delete(item);
        assertTrue(deleted.isPresent());
        searchTermRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotDelete() {
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        SearchTerm item = createSearchTermWithNonExistingId(items.get(0));
        Optional<SearchTerm> deleted = searchTermService.delete(item);
        assertTrue(deleted.isEmpty());
        searchTermRepository.deleteAll(saved);
    }

    @Test
    public void shouldDeleteById() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermRepository.save(item);
        Long id = saved.getId();
        Optional<SearchTerm> deleted = searchTermService.deleteById(id);
        assertTrue(deleted.isPresent());
        boolean exists = searchTermRepository.existsById(id);
        assertFalse(exists);
    }

    @Test
    public void shouldNotDeleteById() {
        Optional<SearchTerm> deleted = searchTermService.deleteById(getNonExistingId());
        assertTrue(deleted.isEmpty());
    }

    @Test
    void shouldCount() {
        long countBefore = searchTermRepository.count();
        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
        long countAfter = searchTermService.count();
        assertEquals(countBefore + getNumberOfItemsToLoad(), countAfter);
        searchTermRepository.deleteAll(saved);
    }

    @Test
    public void shouldExist() {
        SearchTerm item = searchTermContentProvider.get();
        SearchTerm saved = searchTermRepository.save(item);
        boolean exists = searchTermService.exists(item);
        assertTrue(exists);
        searchTermRepository.delete(saved);
    }
}