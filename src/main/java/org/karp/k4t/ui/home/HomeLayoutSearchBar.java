package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.search.terms.SearchState;
import org.karp.k4t.ui.shared.SearchBox;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutSearchBar.ID + CSS_FILE_EXTENSION)
public class HomeLayoutSearchBar extends HorizontalLayout {

    public static final String ID = HomeLayout.ID + "-search-bar";

    private final SearchBox searchBox;

    public HomeLayoutSearchBar(DataProvider dataProvider, SearchState searchState) {
        addClassName(ID);

        searchBox = new SearchBox(dataProvider, searchState);
        add(searchBox);
    }
}
