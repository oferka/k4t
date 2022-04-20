package org.karp.k4t.repository;

import org.karp.k4t.model.SearchTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchTermRepository extends JpaRepository<SearchTerm, Long> {

    List<SearchTerm> findByText(String text);

    Boolean existsByText(String text);
}
