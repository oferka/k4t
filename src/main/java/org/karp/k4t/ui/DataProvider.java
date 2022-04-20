package org.karp.k4t.ui;

import lombok.RequiredArgsConstructor;
import org.karp.k4t.ui.search.terms.SearchTermsDataProvider;
import org.karp.k4t.ui.users.UsersDataProvider;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class DataProvider {

    private final SearchTermsDataProvider searchTermsDataProvider;
    private final UsersDataProvider usersDataProvider;

    public @NotNull SearchTermsDataProvider getSearchTermsDataProvider() {
        return searchTermsDataProvider;
    }

    public @NotNull UsersDataProvider getUsersDataProvider() {
        return usersDataProvider;
    }
}
