package org.karp.k4t.data.content.provider.search.term;

import com.github.javafaker.Faker;
import org.karp.k4t.model.SearchTerm;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Service
public class SearchTermTextProvider {

    public @NotNull @Size(min = 1, max = 64) @NotBlank String get(@NotNull SearchTerm searchTerm) {
        return new Faker().food().dish();
    }
}
