package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.ui.DataProvider;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + SearchBox.ID + CSS_FILE_EXTENSION)
public class SearchBox extends ComboBox<SearchTerm> {

    public static final String ID = "search-box";

    public SearchBox(DataProvider dataProvider) {
        addClassName(ID);

        getElement().setAttribute("aria-label", "search");
        setPlaceholder("Search");
        setClearButtonVisible(true);
        setItems(dataProvider.getSearchTermsDataProvider().findAll());
        setItemLabelGenerator(SearchTerm::getText);
    }
}
