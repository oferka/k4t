package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import org.karp.k4t.model.SearchTerm;

import java.util.List;

import static java.util.Arrays.asList;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + SearchBox.ID + CSS_FILE_EXTENSION)
public class SearchBox extends ComboBox<SearchTerm> {

    public static final String ID = "search-box";

    public SearchBox() {
        addClassName(ID);

        getElement().setAttribute("aria-label", "search");
        setPlaceholder("Search");
        setClearButtonVisible(true);
        setItems(getSearchTerms());
        setItemLabelGenerator(SearchTerm::getText);
    }

    private List<SearchTerm> getSearchTerms() {
        return asList(
                new SearchTerm(1L, "Search Term 1"),
                new SearchTerm(2L, "Search Term 2"),
                new SearchTerm(3L, "Search Term 3"),
                new SearchTerm(4L, "Search Term 4"),
                new SearchTerm(5L, "Search Term 5")
        );
    }
}
