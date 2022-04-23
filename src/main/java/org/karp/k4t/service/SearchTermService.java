package org.karp.k4t.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.repository.SearchTermRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SearchTermService {

    private final SearchTermRepository searchTermRepository;

    public @NotNull List<SearchTerm> findAll() {
        Iterable<SearchTerm> items = searchTermRepository.findAll();
        return StreamSupport
                .stream(items.spliterator(), false)
                .collect(Collectors.toList());
    }

    public @NotNull Optional<SearchTerm> findById(@NotNull Long id) {
        return searchTermRepository.findById(id);
    }

    public @NotNull List<SearchTerm> findByText(@NotNull String text) {
        return searchTermRepository.findByText(text);
    }

    public Optional<SearchTerm> findRandom() {
        List<SearchTerm> items = findAll();
        if(items.isEmpty()) {
            return Optional.empty();
        }
        SearchTerm item = items.get(RandomUtils.nextInt(0, items.size()));
        return Optional.of(item);
    }

    public Optional<Long> findRandomId() {
        List<SearchTerm> items = findAll();
        if(items.isEmpty()) {
            return Optional.empty();
        }
        SearchTerm item = items.get(RandomUtils.nextInt(0, items.size()));
        return Optional.of(item.getId());
    }

    public @NotNull SearchTerm save(@NotNull SearchTerm searchTerm) {
        return searchTermRepository.save(searchTerm);
    }

    public @NotNull Iterable<SearchTerm> saveAll(@NotNull Iterable<SearchTerm> searchTerms) {
        return searchTermRepository.saveAll(searchTerms);
    }

    public Optional<SearchTerm> update(@NotNull SearchTerm searchTerm) {
        Optional<SearchTerm> result = Optional.empty();
        if(existsById(searchTerm.getId())) {
            result = Optional.of(save(searchTerm));
        }
        return result;
    }

    public Optional<SearchTerm> delete(@NotNull SearchTerm searchTerm) {
        return deleteById(searchTerm.getId());
    }

    public Optional<SearchTerm> deleteById(@NotNull Long id) {
        Optional<SearchTerm> item = findById(id);
        item.ifPresent(searchTerm -> searchTermRepository.deleteById(searchTerm.getId()));
        return item;
    }

    public long count() {
        return searchTermRepository.count();
    }

    public boolean existsById(@NotNull Long id) {
        return searchTermRepository.existsById(id);
    }

    public boolean exists(@NotNull SearchTerm searchTerm) {
        return searchTermRepository.existsByText(searchTerm.getText());
    }
}
