package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.QueryParameters;
import elemental.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.SearchView;
import org.karp.k4t.ui.search.terms.SearchState;
import org.karp.k4t.ui.search.terms.SearchTermChangeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@Slf4j
@CssImport(SHARED_FOLDER + SearchBox.ID + CSS_FILE_EXTENSION)
public class SearchBox extends ComboBox<SearchTerm> {

    public static final String ID = "search-box";

    private final SearchState searchState;

    public SearchBox(DataProvider dataProvider, SearchState searchState) {
        this.searchState = searchState;
        addClassName(ID);

        getElement().setAttribute("aria-label", "search");
        setPlaceholder("Search");
        setClearButtonVisible(true);
        setAllowCustomValue(true);
        addCustomValueSetListener(this::customValueEntered);
        addSelectedItemChangeListener(this::selectedItemChanged);
        setItems(dataProvider.getSearchTermsDataProvider().findAll());
        setItemLabelGenerator(SearchTerm::getText);
        searchState.addSearchTermChangeListener(this::searchTermChanged);
    }

    private void searchTermChanged(SearchTermChangeEvent searchTermChangeEvent) {
        String oldSearchTermText = searchTermChangeEvent.getOldSearchTermText().orElse(null);
        String newSearchTermText = searchTermChangeEvent.getNewSearchTermText().orElse(null);
        log.info("Search term changed. old search term: {}, new search term: {}", oldSearchTermText, newSearchTermText);
    }

    private void selectedItemChanged(SelectedItemChangeEvent<ComboBox<SearchTerm>> comboBoxSelectedItemChangeEvent) {
        JsonObject selected = comboBoxSelectedItemChangeEvent.getSelectedItem();
        if(selected != null) {
            log.info("Search item selected: {}", selected);
            String label = selected.getString("label");
            navigateToSearchView(label);
        }
        else {
            log.info("Search selection cleaned");
        }
    }

    private void customValueEntered(CustomValueSetEvent<ComboBox<SearchTerm>> customValueSetEvent) {
        String customValue = customValueSetEvent.getDetail();
        log.info("Search custom value entered: {}", customValue);
        navigateToSearchView(customValue);
    }

    private void navigateToSearchView(String query) {
        Map<String, List<String>> parameters = new HashMap<>();
        parameters.put("query", List.of(query));
        parameters.put("type", List.of("all"));
        QueryParameters queryParameters = new QueryParameters(parameters);
        getUI().ifPresent(ui -> ui.navigate(SearchView.ROUTE, queryParameters));
        searchState.setSearchTerm(Optional.of(query));
    }
}
