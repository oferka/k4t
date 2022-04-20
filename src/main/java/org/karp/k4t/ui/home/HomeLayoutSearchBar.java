package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.shared.SearchTextField;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutSearchBar.ID + CSS_FILE_EXTENSION)
public class HomeLayoutSearchBar extends HorizontalLayout {

    public static final String ID = HomeLayout.ID + "-search-bar";

    private final SearchTextField searchTextField;

    public HomeLayoutSearchBar() {
        addClassName(ID);

        searchTextField = new SearchTextField();
        add(searchTextField);
    }
}
