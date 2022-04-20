package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.shared.SearchBox;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutSearchBar.ID + CSS_FILE_EXTENSION)
public class HomeLayoutSearchBar extends HorizontalLayout {

    public static final String ID = HomeLayout.ID + "-search-bar";

    private final SearchBox searchBox;

    public HomeLayoutSearchBar() {
        addClassName(ID);

        searchBox = new SearchBox();
        add(searchBox);
    }
}
